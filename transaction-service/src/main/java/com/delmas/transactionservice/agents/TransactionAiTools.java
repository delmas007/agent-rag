package com.delmas.transactionservice.agents;

import com.delmas.transactionservice.entities.Transaction;
import com.delmas.transactionservice.entities.TransactionStatus;
import com.delmas.transactionservice.repository.TransactionRepository;
import dev.langchain4j.agent.tool.Tool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TransactionAiTools {
    private TransactionRepository transactionRepository;

    public TransactionAiTools(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Tool("Get All Transactions")
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
    @Tool("Get All Transactions By Account ID")
    public List<Transaction> getAllTransactionsByAccountId(long accountId){
        return transactionRepository.findByAccountId(accountId);
    }
    @Tool
    public Transaction updateTransactionStatus(Long transactionId, TransactionStatus transactionStatus){
        Transaction transaction = transactionRepository.findById(transactionId).get();
        transaction.setStatus(transactionStatus);
        transactionRepository.save(transaction);
        return transaction;
    }
}
