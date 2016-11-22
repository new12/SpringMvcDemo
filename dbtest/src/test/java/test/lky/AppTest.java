package test.lky;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args){
        try{
            UnsupportedClassVersionError r = new UnsupportedClassVersionError();
            throw r;
        }catch (Throwable e){
            System.out.println(e.toString());
        }finally {
            System.out.println("i am finally");
        }
    }
}
