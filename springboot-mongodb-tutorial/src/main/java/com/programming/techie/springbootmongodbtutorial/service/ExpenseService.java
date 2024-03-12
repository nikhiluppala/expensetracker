package com.programming.techie.springbootmongodbtutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.programming.techie.springbootmongodbtutorial.model.Expense;
import com.programming.techie.springbootmongodbtutorial.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
		
	}

	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
		
	}
	public void updateExpense(Expense expense) {
		Expense savedExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("Cannot find expense by Id %s", expense.getId())));
		
		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		savedExpense.setExpenseCategory(expense.getExpenseCategory());
		
		expenseRepository.save(expense);
	}
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
		
	}
	public Expense getExpenseByName(String name) {
		return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
				String.format("Cannot find expense by name %s", name)));
	}
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
