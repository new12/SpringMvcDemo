package service;

import basic.BasicTest;
import entity.Domain;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kylong on 2016/4/19.
 */

public class PrivilegeServiceTest extends BasicTest{
    @Autowired
    private PrivilegeService service;
    @Autowired
    private DomainService categoryService;
    @Test
    public void testSaveCategory(){
        Domain category = new Domain();
        category.setName("job");
        categoryService.save(category);
    }

}
