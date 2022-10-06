package com.nazmul.eShop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.TransactionHistoryImpl;
import com.nazmul.eShop.model.TransactionHistoryInfo;

@Controller
@RequestMapping("/transaction")
public class TransactionHistoryController {
	
	@Autowired
	private TransactionHistoryImpl transactionHistoryImpl;
	
	@GetMapping("/getAll_transaction_by_invoice/{invoice}")
	@ResponseBody
	public List<TransactionHistoryInfo> doSaveSaleTransactionHistory(@PathVariable String invoice) {
		List<TransactionHistoryInfo> getAllTransactionListByInvoiceNo=null;
		try {
			getAllTransactionListByInvoiceNo=transactionHistoryImpl.getAllTransactionHistoryByInvoiceNo(invoice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		
		return getAllTransactionListByInvoiceNo;
		
	}

}
