package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;

import java.net.URI;

import static org.springframework.security.oauth2.common.OAuth2AccessToken.*;

/**
 * Created by kylong on 2016/5/11.
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {

    private final String location = "http://localhost:8080/server/job/name/";
    private RestOperations restOperations;


    @RequestMapping(value = "/job/{name}")
    @ResponseBody
    public String call(@PathVariable String name){
        String url = location + name;
        return restOperations.getForObject(URI.create(url),String.class);
    }
    @Autowired
    public void setRestOperations(RestOperations restOperations){
        this.restOperations = restOperations;
    }
}
