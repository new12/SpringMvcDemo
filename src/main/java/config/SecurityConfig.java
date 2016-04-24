package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import service.AuthService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private AuthService authService;

    @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
//       auth
//       .inMemoryAuthentication().withUser("user").password("password").roles("USER");
        auth.authenticationProvider(daoAuthenticationProvider());
   }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/static/**").permitAll()
                .antMatchers("/user").access("hasRole('admin_view')")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().and()
                .csrf().disable();
    	
    }
    @Bean
    public Md5PasswordEncoder md5PasswordEncoder(){
        return  new Md5PasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(authService);
        dao.setPasswordEncoder(md5PasswordEncoder());
        return dao;
    }

}
