package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
public class RootConfig {
    private static Logger LOGGER = LoggerFactory.getLogger(RootConfig.class);

    @Value("{db.url}")
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
        sfb.setPackagesToScan(new String[]{"entity"});
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
}
