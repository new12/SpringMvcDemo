package bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kylong on 2016/7/25.
 */
public class A {
    private B b;
    public void print(){
        System.out.println("A");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
