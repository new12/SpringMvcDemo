import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylong on 2016/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class PasswordClient {
    @Value("${accessTokenUri}")
    private String accessTokenUrl;
    @Autowired
    private AccessTokenProviderChain accessTokenProvider;
    public OAuth2AccessToken getToken(){
        OAuth2AccessToken oAuth2AccessToken = tokenProvider().obtainAccessToken(resource(), new DefaultAccessTokenRequest());
        System.out.println(oAuth2AccessToken.getValue());
        return  oAuth2AccessToken;
    }

    @Test
    public void refreshToken(){
        OAuth2AccessToken token = getToken();
        OAuth2AccessToken refreshAccessToken = tokenProvider().refreshAccessToken(resource(), token.getRefreshToken(), new DefaultAccessTokenRequest());
        System.out.println(refreshAccessToken.getValue());
    }

    private ResourceOwnerPasswordAccessTokenProvider tokenProvider(){
        ResourceOwnerPasswordAccessTokenProvider provider = new ResourceOwnerPasswordAccessTokenProvider();
        return  provider;
    }

    private OAuth2ProtectedResourceDetails resource(){
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setPassword("123");
        details.setUsername("user");
        details.setAccessTokenUri(accessTokenUrl);
        details.setClientId("test");
        details.setClientSecret("secret");
        return  details;
    }
}
