package test.lky.express;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by longkeyu on 2016/12/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-expression.xml"})
public class BeanTest {

    @Autowired
    private NumberGuess numberGuess;
    @Autowired
    private ShapeGuess shapeGuess;

    @Value("#{systemProperties['user.dir']}")
    private String workingdir;

    @Value("#{student1.name}")
    private String name;

    private int id;
    @Autowired
    public void configId(@Value("#{student1.id}") int id){
        this.id = id;
    }

    @Value("#{'i am literal'}")
    private String literal;
    //这样也是可行的
//    @Value("#{student1.id}")
//    public void configId(int id){
//        this.id = id;
//    }

    @Test
    public void testUseMethod(){
        System.out.println(numberGuess.getRandomNumber());
    }

    @Test
    public void testUseSystemProperties(){
        System.out.println(numberGuess.getClasspath());
    }

    @Test
    public void testReferOtherBean(){
        System.out.println(shapeGuess.getInitialshapeSeed());
    }

    @Test
    public void testAnnotation(){
        System.err.println(workingdir);
        System.err.println(name);
    }

    @Test
    public void testFieldAnnotation(){
        System.out.println(id);
    }

    @Test
    public void testLiteral(){
        System.out.println(literal);
    }
}
