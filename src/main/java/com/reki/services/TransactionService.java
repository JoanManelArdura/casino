package com.reki.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reki.Player;
import com.reki.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transRepo;
	
	public TransactionService(TransactionRepository transRepo) {
		this.transRepo= transRepo;
	}
	
	public void setTransaction(Player player, double amount, String source) {
		Transaction trans = new Transaction(player, amount, source);
		transRepo.save(trans);
	}
}
