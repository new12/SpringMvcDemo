package basic;

import org.junit.Test;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kylong on 2016/4/20.
 */
public class Md5Test {
    @Test
    public void testEqual(){
        String password  = "sda@`,lsfjdcfh@123*scdy7zi[],./l:";
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String s1 = encoder.encodePassword(password, null);
        String s2 = MD5(password);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
    }


    private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            // System.out.println("MD5(" + sourceStr + ",32) = " + result);

            // System.out.println("MD5(" + sourceStr + ",16) = " +
            // buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
}
