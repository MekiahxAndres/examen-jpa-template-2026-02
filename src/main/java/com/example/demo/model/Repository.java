package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "is_template", nullable = false)
    private String isTemplate;

    @Column(name = "is_private", nullable = false)
    private String isPrivate;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<PullRequest> taughtRepositories;

    @ManyToOne(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<PullRequest> reviewedPullRequests;

    @ManyToOne(mappedBy = "commit", cascade = CascadeType.ALL)
    private List<Commit> commits;

}
