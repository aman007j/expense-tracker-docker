package com.example.backend.service;

import com.example.backend.entity.ExpenseEntry;
import com.example.backend.entity.User;
import com.example.backend.repository.ExpenseEntryRepository;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseEntryService {
    @Autowired
    private ExpenseEntryRepository expenseEntryRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(ExpenseEntry entry, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        entry.setUser(user);
        expenseEntryRepository.save(entry);
    }
}


// service class connects controller and repository class