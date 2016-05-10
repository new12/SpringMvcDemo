package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created by kylong on 2016/5/9.
 */
@Configuration
public class OAuth2ServerConfig {
    private static final String DEMO_RESOURCE_ID="demo";
    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(DEMO_RESOURCE_ID).stateless(false);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                        .requestMatchers().antMatchers("/job/**")
                    .and()
                        .authorizeRequests().antMatchers("/job/**").access("hasRole('admin')");
        }
    }
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{
        @Autowired
        private DataSource dataSource;

        @Autowired
        private AuthenticationManager auth;

        @Bean
        public JdbcTokenStore jdbcTokenStore(){
            return  new JdbcTokenStore(dataSource);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.jdbc(dataSource);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(jdbcTokenStore()).authenticationManager(auth);
        }
    }
}
