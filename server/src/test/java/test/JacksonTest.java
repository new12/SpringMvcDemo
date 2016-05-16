package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kylong on 2016/5/15.
 */
public class JacksonTest {
    String value = "[{\"test\":123,\"hi\":123},{\"hi\":123}]";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectReader reader = mapper.readerFor(List.class);
    private static  final ObjectWriter listWriter = mapper.writerFor(List.class);
    @Test
    public void test() throws IOException {
        List<Map<String,String>> o = reader.readValue(value);
        System.out.println(o);
    }
    @Test
    public void testWrite() throws JsonProcessingException {
        List<Map<String,String>> lst = new ArrayList<Map<String, String>>();
        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("name","tom");
        map1.put("age","23");
        Map<String,String> map2 = new HashMap<String,String>();
        map2.put("name","jim");
        map2.put("age","21");
        lst.add(map1);
        lst.add(map2);
        System.out.println(listWriter.writeValueAsString(lst));
    }

    @Test
    public void testEnum() throws JsonProcessingException {
        String json = mapper.writeValueAsString(Type.TYPE1);
        System.out.println(json);
    }
}
