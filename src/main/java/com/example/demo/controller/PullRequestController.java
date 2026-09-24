package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

   @Autowired
   private final IPullRequestRepository pullRequestRepository;



    @GetMapping("/cons1")
    public List<PullRequest> cons1() {
        return pullRequestRepository.findByRepository_Assignment_Classroom_NameAndStatusOrderByCreatedAtDesc("Computacion en Internet II - Grupo 1", "OPEN");
    }
}
