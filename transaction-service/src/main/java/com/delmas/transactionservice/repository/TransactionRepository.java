package com.delmas.transactionservice.repository;

import com.delmas.transactionservice.entities.Transaction;
import com.delmas.transactionservice.entities.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(long accountId);
    List<Transaction> findByStatus(TransactionStatus transactionStatus);
}
