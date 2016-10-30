package config;

import aspect.LogAspect;
import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import validator.CheckCaceValidator;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2016/4/16.
 */
@Configuration
@ComponentScan(basePackages = {"service","dao"})
@PropertySource("classpath:resources.properties")
@EnableTransactionManagement
//@EnableAspectJAutoProxy
@Import({SecurityConfig.class,MethodSecurityConfig.class,OAuth2ServerConfig.class})
public class RootConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.password}")
    private String dbPassword;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.initialSize}")
    private int dbInitialSize;

    @Value("${db.minIdle}")
    private int dbMinIdle;

    @Value("${db.maxActive}")
    private int dbMaxActive;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
        sfb.setDataSource(dataSource);
        sfb.setPackagesToScan("entity");
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",dbDriver);
        props.setProperty("hibernate.show_sql","false");
        props.setProperty("hibernate.format_sql","false");
        props.setProperty("hibernate.jdbc.fetch_size","80");
        props.setProperty("hibernate.jdbc.batch_size","35");
        sfb.setHibernateProperties(props);
        return sfb;
    }

    @Bean
    public DataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setUsername(dbUsername);
        druidDataSource.setPassword(dbPassword);

        druidDataSource.setInitialSize(dbInitialSize);
        druidDataSource.setMinIdle(dbMinIdle);
        druidDataSource.setMaxActive(dbMaxActive);

        druidDataSource.setValidationQuery("select 'adhoc' ");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(false);

        try {
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            LOGGER.error("error",e);
        }

        return druidDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
        return  hibernateTransactionManager;
    }

//    @Bean
//    public LocalValidatorFactoryBean localValidatorFactoryBean(){
//        return  new LocalValidatorFactoryBean();
//    }
//
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor(){
//        MethodValidationPostProcessor postProcessor =   new MethodValidationPostProcessor();
//        postProcessor.setValidatorFactory(localValidatorFactoryBean());
//        return  postProcessor;
//    }
//
//    @Bean
//    public CheckCaceValidator checkCaceValidator(){
//        CheckCaceValidator validator = new CheckCaceValidator();
//        validator.setFlag("bean");
//        return  validator;
//    }
//
//    @Bean
//    public LogAspect logAspect(){
//        return  new LogAspect();
//    }
//
//
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
       emfb.setPackagesToScan("dao.impl.jpa");
        return  emfb;
    }

//    @Bean
//    public PersistenceAnnotationBeanPostProcessor paPostProcessor(){
//        return  new PersistenceAnnotationBeanPostProcessor();
//    }
//
    @Bean
    public BeanPostProcessor persistenceTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory emf){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(emf);
        return jpaTransactionManager;
    }
}
