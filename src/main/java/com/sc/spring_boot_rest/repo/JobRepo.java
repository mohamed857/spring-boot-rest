package com.sc.spring_boot_rest.repo;

import com.sc.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}
