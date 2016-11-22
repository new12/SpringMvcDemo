package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

/**
 * Created by kylong on 2016/11/9.
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setName("kevin");
        user.setPassword("123456");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);
        System.out.println(s);
    }
}
