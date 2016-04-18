package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

/**
 * Created by Administrator on 2016/4/16.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
       auth
       .inMemoryAuthentication().withUser("user").password("password").roles("USER");
   }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests().antMatchers("/static/**").permitAll()
    		.anyRequest().authenticated()
    	.and()
    		.formLogin()
    		.loginPage("/login")
    		.permitAll()
                .and().csrf().disable();
    	
    }
}
