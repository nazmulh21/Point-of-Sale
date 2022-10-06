package com.nazmul.eShop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.AdvanceServiceImpl;
import com.nazmul.eShop.ServiceImpl.DuesInfoServiceImpl;
import com.nazmul.eShop.ServiceImpl.SaleServiceImpl;
import com.nazmul.eShop.ServiceImpl.TransactionHistoryImpl;
import com.nazmul.eShop.model.DuesInfo;
import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.SaleInfo;
import com.nazmul.eShop.model.TransactionHistoryInfo;

@Controller
@RequestMapping("/dues")
public class DuesInfoController {
	
	@Autowired
	private DuesInfoServiceImpl duesImpl;
	
	@Autowired
	private SaleServiceImpl saleServiceImpl;
	
	@Autowired
    private TransactionHistoryImpl transactionImpl;
	
	@Autowired
    private AdvanceServiceImpl advanceImple;
	
	
	@GetMapping("/dues_show")
	public String showDues() {
		return "redirect:/dues/get_dues_list";
	}
	//......................dues customer list.....................//
	@GetMapping("/dues_customer_list_show")
	public String allCustomerDuesShow() {
		return "redirect:/dues/get_dues_customer_list";
	}
//................................dues customer list.......................//	
	
	@GetMapping("/get_dues_customer_list")
	public String getDuesShowCustomerList(Model model) {
		List<DuesInfo> getDuesList=null;
		
		try {
			getDuesList=duesImpl.getAllDuesList();
			model.addAttribute("duesList", getDuesList);
		} catch (Exception e) {
			
		}
		return "dues_All_list_customer";
	}
	
	
	//.......................for help passing customer mobile and show customer details.....................//
	
	  @GetMapping("/get_dues_customer_mobile/{customerMobile}") 
	  public String customerDuesDetails(@PathVariable("customerMobile") String customerMobile, Model model) {
		 
			List<DuesInfo> list = null;
			list = duesImpl.getDuesCustomerMobileWise(customerMobile);
			model.addAttribute("duesList", list);
		    model.addAttribute("customerMobile", customerMobile);
	  return "customer_dues_paid_form";
	  }
	 
	
	//..............................all dues list...........................//
	@GetMapping("/get_dues_list")
	public String getDuesList(Model model) {
		List<DuesInfo> getDuesList=null;
		
		try {
			getDuesList=duesImpl.getAllDuesList();
			model.addAttribute("duesList", getDuesList);
		} catch (Exception e) {
			
		}
		return "dues_list_form";
	}
	
	
	//........................for help get dues invoice passing here...............................//
	@GetMapping("/get_dues/{invoiceNo}") 
	public String duesShow(@PathVariable("invoiceNo") String invoiceNo, Model model) {
		List<SaleInfo> list = null;
		list = saleServiceImpl.getSaleDues(invoiceNo);
		model.addAttribute("duesList", list);
		model.addAttribute("invoiceNo", invoiceNo);
		return "dues_paid_form";
	}
	
	//.................................pass mobile no get customer name here.......................//
		@GetMapping("/get_dues_custome_mobile_wise/{customerMobile}") 
		@ResponseBody
		public List<DuesInfo> getDuesCustomerNameMobileWise(@PathVariable("customerMobile") String customerMobile) {
			List<DuesInfo> list = null;
			try {
				list = duesImpl.getDuesCustomerMobileWise(customerMobile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return list;
		}
	
	
	//.................................get dues details by invoice here.......................//
	@GetMapping("/get_dues_invoice_wise/{invoiceNo}") 
	@ResponseBody
	public List<DuesInfo> getDuesInvoiceWise(@PathVariable("invoiceNo") String invoiceNo) {
		List<DuesInfo> list = null;
		list = duesImpl.getDuesInvoiceWise(invoiceNo);
		
		return list;
	}
	
	@PutMapping("/dues_update/{dues}/{invoiceNo}/{totalSale}/{duesPayable}/{actualTotalPaid}")
	public String duesUpdate(@PathVariable String dues,@PathVariable String invoiceNo,
			@PathVariable String totalSale,
			@PathVariable String duesPayable,
			@PathVariable String actualTotalPaid,
			TransactionHistoryInfo transactionInfo) {
		
		duesImpl.duesUpdated(dues, invoiceNo);
		
		//...................................save transaction here..............................//	
		
		  transactionInfo.setStatus("Dues Collected By: Nazmul Hasan, Branch:Mirpur");
		  transactionInfo.setInvoice(invoiceNo); 
		  transactionInfo.setTotalBill(totalSale);
		  transactionInfo.setPaidBill(duesPayable);
		  transactionInfo.setTotalPaidBill(actualTotalPaid);
		  transactionInfo.setDues(dues);
		  transactionInfo.setIssueDate(new Date());
		  transactionImpl.doSaveTransactionHistory(transactionInfo);
		 
			//.........................end transaction here............................................//	
		return "dues_list_form";
	}
	
	@GetMapping("/get_total_dues")
	@ResponseBody
	public List<DuesInfo> totalDuesCalculate(){
		List<DuesInfo> duesList=null;
		
		try {
			duesList=duesImpl.getAllDuesList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duesList;
	}
	
	//................multiple invoice dues update here for same customer.................//
	@PutMapping("/multiple_dues_update/{invoiceNo}/{dues}")
	public String multipleDuesUpdate(@PathVariable String invoiceNo, @PathVariable String dues) {
		
		duesImpl.duesUpdated(dues, invoiceNo);
		
		return "customer_dues_paid_form";
	}
	
  
 

}
