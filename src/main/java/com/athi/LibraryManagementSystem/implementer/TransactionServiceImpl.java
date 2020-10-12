package com.athi.LibraryManagementSystem.implementer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.athi.LibraryManagementSystem.repository.TransactionRepository;
import com.athi.LibraryManagementSystem.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository transactionRepository;
}
