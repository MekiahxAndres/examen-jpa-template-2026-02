package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "commit_hash", nullable = false)
    private String commitHash;

    @Column(nullable = false)
    private String message;

    @Column(name = "lines_added", nullable = false)
    private Integer linesAdded;

    @Column(name = "lines_deleted", nullable = false)
    private Integer linesDeleted;

    @Column(name = "commit_date", nullable = false)
    private Timestamp commitDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "repository_id", nullable = false)
    private Repository repository;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
}
