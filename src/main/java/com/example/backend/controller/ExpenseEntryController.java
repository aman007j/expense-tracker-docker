package com.example.backend.controller;

import com.example.backend.entity.ExpenseEntry;
import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.ExpenseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class ExpenseEntryController {

    @Autowired
    private ExpenseEntryService expenseEntryService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/expense/")
    public ResponseEntity<?> addExpense(@RequestBody ExpenseEntry myEntry) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        try {
            expenseEntryService.saveEntry(myEntry, username);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
