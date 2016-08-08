package bean;

/**
 * Created by kylong on 2016/7/25.
 */
public class B {
    private C c;
    public void print(){
        System.out.println("B");
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
