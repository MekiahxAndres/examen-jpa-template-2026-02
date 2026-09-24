package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {


    List<PullRequest> findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc(String classroomName, String status);

}
