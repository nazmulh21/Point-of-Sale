package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.TransactionHistoryInfo;
import com.nazmul.eShop.repository.TransactionHistoryRepo;
import com.nazmul.eShop.service.TransactionHistoryService;

@Service
@Transactional
public class TransactionHistoryImpl implements TransactionHistoryService {
	@Autowired
	private TransactionHistoryRepo transactionRepo;

	@Override
	public void doSaveTransactionHistory(TransactionHistoryInfo transactionInfo) {
		transactionRepo.save(transactionInfo);
		
	}

	@Override
	public List<TransactionHistoryInfo> getAllTransactionHistoryByInvoiceNo(String invoiceNo) {
		
		return transactionRepo.getAllTransactionHistoryByInvoice(invoiceNo);
	}

}
