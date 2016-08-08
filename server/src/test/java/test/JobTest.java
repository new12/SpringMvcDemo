package test;

import entity.Job;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by kylong on 2016/5/17.
 */
public class JobTest {

    private static Validator validator;
    @BeforeClass
    public static void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void jobNameisNull(){
        Job job = new Job();
        job.setName("hi");
        Set<ConstraintViolation<Job>> constraintViolations = validator.validate(job);
        assertEquals(1, constraintViolations.size());
        assertEquals(
                "Case mode must be UPPER.",
                constraintViolations.iterator().next().getMessage());
    }
}
