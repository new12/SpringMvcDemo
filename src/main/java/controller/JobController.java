package controller;

import entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import service.JobService;

import java.util.List;

/**
 * Created by kylong on 2016/4/25.
 */
@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping(value = "/job/{name}")
    public List<Job> findByName(@PathVariable String name){
        return  jobService.findByName(name);
    }
}
