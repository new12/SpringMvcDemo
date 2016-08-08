package test;

import config.RootConfig;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by kylong on 2016/5/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class UserDaoTest {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testMerge(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
       try{
           User user = (User) session.get(User.class,1 );
           user.setName("admin");
           session.update(user);
           transaction.commit();
       }catch (Exception e){
            transaction.rollback();
       }
        session.close();
    }

}
