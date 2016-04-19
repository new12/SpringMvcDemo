package service;

import basic.BasicTest;
import entity.Domain;
import entity.Privilege;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kylong on 2016/4/19.
 */

public class PrivilegeServiceTest extends BasicTest{
    @Autowired
    private PrivilegeService service;
    @Autowired
    private DomainService domainService;
    @Test
    public void testSaveDomain(){
        Domain category = new Domain();
        category.setName("job");
        domainService.save(category);
    }

    @Test
    public void testSavePrivilege(){
        Privilege e = new Privilege();
        e.setName("查看job表");
        e.setValue("view");
        service.save(1, e);
    }

}
