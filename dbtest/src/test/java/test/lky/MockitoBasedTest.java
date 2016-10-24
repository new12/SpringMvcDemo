package test.lky;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

/**
 * Created by didi on 16/10/16.
 */
public class MockitoBasedTest {
    @Before
    public void setUp() throws Exception {
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        MockitoAnnotations.initMocks(this);
    }


}
