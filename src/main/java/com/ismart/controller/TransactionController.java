package com.ismart.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismart.model.Transaction;
import com.ismart.service.TransactionService;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class TransactionController {

	Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@PostMapping("/makeTransaction")
	public ResponseEntity<Transaction> saveTransaction(@Valid @RequestBody Transaction transaction){
		logger.info("saveTransaction");
		logger.info("transaction : " + transaction);
		
		Transaction response = transactionService.saveTransaction(transaction);
		logger.info("transaction : " + transaction);
		return new ResponseEntity<Transaction>(response, HttpStatus.OK);
	}


}
