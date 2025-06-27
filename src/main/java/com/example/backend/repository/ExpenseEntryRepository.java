package com.example.backend.repository;

import com.example.backend.entity.ExpenseEntry;
import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, Long> {
    List<ExpenseEntry> findByUser(User user);
}

// Why We Use a Repository in Spring Data JPA (to interact with the daatbases)
// 1) Eliminates Boilerplate Code
// 2) Built-in CRUD Operations
//      By extending JpaRepository, you instantly get: save(), findById(), findAll(), deleteById(), existsById(), count(), ...
// 3) Custom Query Support
//      List<Expense> findByCategory(String category);
//      Spring Data JPA automatically generates the SQL based on the method name.