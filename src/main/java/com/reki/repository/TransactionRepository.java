package com.reki.repository;

import org.springframework.data.repository.CrudRepository;

import com.reki.services.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
}
