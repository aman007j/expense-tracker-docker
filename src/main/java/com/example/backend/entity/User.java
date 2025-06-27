package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // encrypt

    @Column(nullable = false, unique = true)
    private String email;

    private String mobile;

//    private boolean isVerified = false;
    // Server checks if username/email already exists.
    //If not, store the new user in DB with isVerified = false.
    //Send OTP to their email.
    //User enters OTP to verify.
    //If OTP is valid, update isVerified = true.
    //Only allow login if isVerified is true.


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseEntry> expenses;


}
