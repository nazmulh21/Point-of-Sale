package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.TransactionHistoryInfo;

public interface TransactionHistoryService {
	void doSaveTransactionHistory(TransactionHistoryInfo transactionInfo);
	
	List<TransactionHistoryInfo> getAllTransactionHistoryByInvoiceNo(String invoiceNo);
}
