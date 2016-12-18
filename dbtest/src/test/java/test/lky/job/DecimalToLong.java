package test.lky.job;

import java.math.BigDecimal;

/**
 * Created by longkeyu on 2016/12/5.
 */
public class DecimalToLong {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal("2222");
        System.out.println(Long.parseLong(b.toString()));
    }
}
