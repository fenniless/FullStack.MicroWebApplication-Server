package com.group3.budgetApp.model;

import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Example;

import javax.persistence.*;
//import java.util.Date;
import java.time.LocalDate;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Column(name = "from_account_id")
    private Integer fromAccountId;
    @Column(name = "to_account_id")
    private Integer toAccountId;
    @Column
    private String memo;
    //    @Column(name = "transaction_type")
    //    private Integer transactionType;
    @ManyToOne(cascade = ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_type")
    private TransactionType transactionType;
    @Column(name = "transaction_dt")
    private LocalDate transactionDt;
    @Column
    private Double amount = 0.0;

    public Transaction() {
    }

    public Transaction(Integer fromAccountId, Integer toAccountId, Double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

   // public Transaction(Integer transactionId, Integer fromAccountId, Integer toAccountId, String memo, Double amount, Integer transactionType, LocalDate transactionDt) {
   public Transaction(Integer transactionId, Integer fromAccountId, Integer toAccountId, String memo, Double amount, TransactionType transactionType, LocalDate transactionDt) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.memo = memo;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionDt = transactionDt;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public Integer getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

//    public Integer getTransactionType() {
//        return transactionType;
//    }
//
//    public void setTransactionType(Integer transactionType) {
//        this.transactionType = transactionType;
//    }

    public TransactionType getTransactionType() {
        if(this.transactionType == null)
        {
            return new TransactionType();
        }
        else {
            return transactionType;
        }
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDt() {
        return transactionDt;
    }

    public void setTransactionDt(LocalDate transactionDt) {
        this.transactionDt = transactionDt;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromAccountId=" + fromAccountId +
                ", toAccountId=" + toAccountId +
                ", memo='" + memo + '\'' +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", transactionDt=" + transactionDt +
                '}';
    }
}
