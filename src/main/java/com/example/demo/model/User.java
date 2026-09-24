package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classroom> userClassrooms;

    @OneToMany(mappedBy = "owner_id", cascade = CascadeType.ALL)
    private List<Repository> userRepositories;

    @OneToMany(mappedBy = "author_id", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewer_id", cascade = CascadeType.ALL)
    private List<PullRequest> reviewerPullRequests;

    @OneToMany(mappedBy = "author_id", cascade = CascadeType.ALL)
    private List<Commit> authorCommits;







}
