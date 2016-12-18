package test.lky.express;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.*;

/**
 * Created by longkeyu on 2016/12/17.
 */
public class BaseTest {
    ExpressionParser parser;
    @Before
    public void init(){
       parser = new SpelExpressionParser();
    }
    @Test
    public void test1() {
        Expression exp = parser.parseExpression("'Hello world!'");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    @Test
    public void testMethod(){
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        System.out.println(message);
    }

    @Test
    public void testBytes(){
        ExpressionParser parser = new SpelExpressionParser();

// invokes 'getBytes()'
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
    }

    @Test
    public void testDot(){
        ExpressionParser parser = new SpelExpressionParser();

// invokes 'getBytes().length'
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
    }

    @Test
    public void testConstructor(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
    }

    @Test
    public void testContext(){
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

// The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        String name1 = (String) exp.getValue(new Student(1,"opopop"));
        System.out.println(name);
        System.out.println(name1);
    }

    @Test
    public void testBoolean(){
        Expression expression = parser.parseExpression("name ==  'Nikola Tesla'");
        Boolean result = (Boolean) expression.getValue(new Student(1,"Nikola Tesla"));
        System.out.println(result);
    }

    @Test
    public void testGenericType(){
        Simple simple = new Simple();

        simple.booleanList.add(true);

        StandardEvaluationContext simpleContext = new StandardEvaluationContext(simple);

// false is passed in here as a string. SpEL and the conversion service will
// correctly recognize that it needs to be a Boolean and convert it
        parser.parseExpression("booleanList[0]").setValue(simpleContext, "false");

// b will be false
        Boolean b = simple.booleanList.get(0);
    }

    @Test
    public void testIndex(){
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);
        ExpressionParser parser = new SpelExpressionParser(config);

        Expression expression = parser.parseExpression("list[3]");

        Demo demo = new Demo();

        Object o = expression.getValue(demo);
    }

    class Demo {
        public List<String> list;
    }

    class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }

    public static  class Inventor{
        private String name;
        private Date birthday;
        private String national;
        public Inventor(String name, Date birthday, String national){
            this.name = name;
            this.birthday = birthday;
            this.national = national;
        }
        public Inventor(){

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getNational() {
            return national;
        }

        public void setNational(String national) {
            this.national = national;
        }
    }

    public static class Student
    {
        private int id;
        private String name;
        private Map<String,List<String>> province;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, List<String>> getProvince() {
            return province;
        }

        public void setProvince(Map<String, List<String>> province) {
            this.province = province;
        }
    }


    @Test
    public void testLiteral(){
        ExpressionParser parser = new SpelExpressionParser();
        // Strings are delimited by single quotes. To put a single quote itself in a string use two single quote characters.
        String helloWorld = (String) parser.parseExpression("'Hello '' world'").getValue();
        double avo = (Double) parser.parseExpression("6.02331415E+23").getValue();
        int maxValue = (Integer) parser.parseExpression("0x7FFFFFFF").getValue();
        boolean trueValue = (Boolean) parser.parseExpression("true").getValue();
        Object nullValue = parser.parseExpression("null").getValue();
        System.out.println(helloWorld);
        System.out.println(avo);
        System.out.println(maxValue);
        System.out.println(trueValue);
        System.out.println(nullValue);
    }

    @Test
    public void testMap(){
        Student st = new Student(2,"hhhhhh");
        Map<String,List<String>> province = new HashMap<>();
        province.put("sichuan",Arrays.asList("chengdu","mianyang"));
        st.setProvince(province);
        System.out.println(parser.parseExpression("province['sichuan']").getValue(st));
        System.out.println(parser.parseExpression("#this['sichuan']").getValue(province));
    }

    @Test
    public void testList(){
        List number = (List) parser.parseExpression("{1,2,3,4}").getValue();
        System.out.println(number);
    }


    @Test
    public void testOperators(){
        // evaluates to true
        boolean trueValue = parser.parseExpression("2 == 2").getValue(Boolean.class);
        assert trueValue;

// evaluates to false
        boolean falseValue = parser.parseExpression("2 < -5.0").getValue(Boolean.class);
        assert !falseValue;
// evaluates to true
        boolean trueValue1 = parser.parseExpression("'black' < 'block'").getValue(Boolean.class);
        assert  trueValue1;
    }

    @Test
    public void testMath(){
        int two = parser.parseExpression("1 + 1").getValue(Integer.class); // 2

        String testString = parser.parseExpression(
                "'test' + ' ' + 'string'").getValue(String.class); // 'test string'

// Subtraction
        int four = parser.parseExpression("1 - -3").getValue(Integer.class); // 4

        double d = parser.parseExpression("1000.00 - 1e4").getValue(Double.class); // -9000

// Multiplication
        int six = parser.parseExpression("-2 * -3").getValue(Integer.class); // 6

        double twentyFour = parser.parseExpression("2.0 * 3e0 * 4").getValue(Double.class); // 24.0

// Division
        int minusTwo = parser.parseExpression("6 / -3").getValue(Integer.class); // -2

        double one = parser.parseExpression("8.0 / 4e0 / 2").getValue(Double.class); // 1.0

// Modulus
        int three = parser.parseExpression("7 % 4").getValue(Integer.class); // 3

        int one1 = parser.parseExpression("8 / 5 % 2").getValue(Integer.class); // 1

// Operator precedence
        int minusTwentyOne = parser.parseExpression("1+2-3*8").getValue(Integer.class); // -21
    }

    @Test
    public void testAssignment(){
        Inventor inventor = new Inventor();
        StandardEvaluationContext inventorContext = new StandardEvaluationContext(inventor);

        parser.parseExpression("Name").setValue(inventorContext, "Alexander Seovic2");
        System.out.println(inventor.getName());

//alternatively
        String aleks = parser.parseExpression(
                "Name = 'Alexandar Seovic'").getValue(inventorContext, String.class);
        System.out.println(inventor.getName());
    }
}
