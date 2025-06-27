package com.example.backend.entity;

import com.example.backend.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "expense_entries")
public class ExpenseEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String description;

    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}

// we create our plain java class into jpa entity using spring data jpa

// JPA-Java specification for ORM
// Hibernate-Popular implementation of JPA
// Spring Data JPA-Spring abstraction over JPA & Hibernate


// strategy = GenerationType.IDENTITY tells JPA:
//
//    "I won't provide a value for this ID field."
//
//    "Let the database generate it automatically, usually by incrementing it by 1."