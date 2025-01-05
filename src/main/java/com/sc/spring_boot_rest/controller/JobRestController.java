package com.sc.spring_boot_rest.controller;

import com.sc.spring_boot_rest.model.JobPost;
import com.sc.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobPosts();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost job) {
        service.addJobPost(job);
    }

    @DeleteMapping("deleteJob/{postId}")
    public void deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
    }

    @PutMapping("updateJob")
    public void updateJob(@RequestBody JobPost job) {
        service.updateJob(job);
    }
    @PostMapping("load")
    public String load(){
        service.load();
        return "Success";
    }
    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
    return service.findByKeyWord(keyword);
    }
}
