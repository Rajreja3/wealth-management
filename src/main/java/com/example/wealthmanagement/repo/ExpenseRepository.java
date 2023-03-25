package com.example.wealthmanagement.repo;

import com.example.wealthmanagement.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

}
