package service;

import entity.Job;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import validator.CaseMode;
import validator.CheckCase;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */
@Validated
public interface JobService extends BaseService<Job> {

    List<Job> findByName(String name);
}
