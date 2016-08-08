package aop;

/**
 * Created by kylong on 2016/7/26.
 */
public class TestTarget implements AbcInterface {
    @Override
    public void print() {
        System.out.println("I am target");
    }
}
