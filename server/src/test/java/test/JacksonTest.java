package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by kylong on 2016/11/9.
 */
public class JacksonTest {
    @Test
    public void test1() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("kevin");
        user.setPassword("123456");
        user.setAddress("shanghai putuo");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }

    @Test
    public void test2() throws IOException {
        String s = "{\"id\":1,\"password\":\"123456\",\"addr\":\"shanghai putuo\"}";
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(s, User.class);
        System.out.println(user.getAddress());
    }
}
