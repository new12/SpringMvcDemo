package dbunit;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.lky.mapper.UserMapper;
import test.lky.model.User;
import test.lky.service.UserServiceImpl;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by didi on 2016/12/1.
 */
public class AnnotationSampleTest1 extends BaseTest {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSource dataSource;

    @Test
    @DatabaseSetup("/dbunit/user1.xml")
    public void testdelete() {
//        List<User> users = userMapper.selectAll();
        Assert.assertEquals(userService.delete(1), 1);
//        List<User> users1 = userMapper.selectAll();
    }

    @Test
    @DatabaseSetup("/dbunit/user1.xml")
    public void testSelect() {
//        List<User> users2 = userMapper.selectAll();
        User user = userService.get(0);
//        Assert.assertEquals("lily", user.getName());
    }

    @Test
    @DatabaseSetup("/dbunit/user.xml")
    public void testDiff(){
        List<User> users3 = userMapper.selectAll();
    }


    public void selectAll() {
        java.sql.Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            String sql = "select * from user ORDER by id for update";
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                //下表从1开始
                System.out.print(resultSet.getString(1) + ",");
                System.out.print(resultSet.getString(2) + ",");
                System.out.print(resultSet.getString(3) + ",");
                System.out.println(resultSet.getString(4));
            }
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {

            try {
                conn.setAutoCommit(true);
                resultSet.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
