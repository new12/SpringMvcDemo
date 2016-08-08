package test;

/**
 * Created by kylong on 2016/6/13.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest test = new ExceptionTest();
        try {
            test.throwException();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void throwException(){
        throw  new RuntimeException("haha");
    }
}
