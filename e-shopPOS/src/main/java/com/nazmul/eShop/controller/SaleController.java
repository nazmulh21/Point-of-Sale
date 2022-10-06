package com.nazmul.eShop.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.engine.transaction.internal.TransactionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.CustomerServiceImpl;
import com.nazmul.eShop.ServiceImpl.DuesInfoServiceImpl;
import com.nazmul.eShop.ServiceImpl.SaleServiceImpl;
import com.nazmul.eShop.ServiceImpl.StockServiceImpl;
import com.nazmul.eShop.ServiceImpl.TransactionHistoryImpl;
import com.nazmul.eShop.model.CustomerInfo;
import com.nazmul.eShop.model.DuesInfo;
import com.nazmul.eShop.model.SaleInfo;
import com.nazmul.eShop.model.StockInfo;
import com.nazmul.eShop.model.TransactionHistoryInfo;

@Controller
@RequestMapping("/sale")
public class SaleController {
	
	 @Autowired
     private StockServiceImpl stockImp;
	 
	 @Autowired
     private SaleServiceImpl saleImpl;
	 
	 @Autowired
     private CustomerServiceImpl customerImpl;
	 
	 @Autowired
     private DuesInfoServiceImpl duesImpl;
	 
	 @Autowired
	 private TransactionHistoryImpl transactionImpl;
	 
	
	@GetMapping("/sale_form_show")
	public String saleFormShow() {
		
		return "sale_form";
	}
	
	@GetMapping("/get_stock_by_productId/{catagoryProductId}")
	@ResponseBody
	public List<StockInfo> getStockByProductId(@PathVariable String catagoryProductId) {
		List<StockInfo>	stock=stockImp.getStockByProductId(catagoryProductId);
		return stock;
	}
	
	@GetMapping("/catagory_Names")
	@ResponseBody
	public List<String> getCatagoryNames(){
		List<String> getNames=stockImp.getAllCatagoryName();
		return getNames;
	}
	
	@PostMapping("/save_sales/{invoice}/{customerName}/{customerMobile}/{dues}/{totalSale}/{actualPaidAmount}")
	public String sales(@PathVariable String invoice,@PathVariable String customerName,
			@PathVariable(name="customerMobile",required = false) String customerMobile,
			@PathVariable(name="dues",required = false) String dues,@PathVariable String totalSale,
			@PathVariable String actualPaidAmount, @RequestBody List<SaleInfo> sales,
			StockInfo stock,DuesInfo duesInfo,CustomerInfo cinfo, TransactionHistoryInfo transactionInfo) {
		List<SaleInfo> salesList = new ArrayList<>();
		for (SaleInfo sale : sales) {
			String priceKey=sale.getPurchasePrice();
			String price=priceKey.substring(3);//remove 3character price key convert into price
			sale.setPurchasePrice(price);
			sale.setInvoiceNo(invoice);
			String unitPrice=sale.getUnitPrice();
			int q=sale.getQty();
			int profit=Integer.parseInt(unitPrice)-Integer.parseInt(price);
			int acctualProfit=q*profit;
			sale.setProfit(String.valueOf(acctualProfit));
			
			
			String mobile=sale.getCustomerId();
			
			cinfo.setCustomerMobile(mobile);
			cinfo.setCustomerName(customerName);
			customerImpl.saveCustomer(cinfo);
			
			//String customerId =customerImpl.getCustomerId(sale.getCustomerId());//get customer Id against mobile
			
			
			//sale.setCustomerId(mobile);
		    stockImp.updateStockAfterSale(sale.getQty(),
		    sale.getCatagoryProductId()); //this method sale quantity minus from stock. and stock table updated.
			sale.setSaleDate(new Date());
			sale.setSaleBy("Nazmul");
			salesList.add(sale);
			
			
		}
		saleImpl.doSaveSale(salesList); //this method save all sale products.
		
	//.........................dues save here...............................//
		
		if(dues !=null && !dues.equals("null") && customerMobile !=null && !customerMobile.equals("null")) {
			duesInfo.setInvoiceNo(invoice);
			duesInfo.setDues(dues);
			duesInfo.setCustomerName(customerName);
			duesInfo.setCustomerMobile(customerMobile);
			duesInfo.setDuesDate(new Date());
			duesImpl.doSaveDues(duesInfo);
		} 
			  else { duesInfo.setInvoiceNo(invoice); duesInfo.setDues("0");
			  duesInfo.setCustomerName(customerName); duesInfo.setCustomerMobile("001");
			  duesInfo.setDuesDate(new Date());
			  duesImpl.doSaveDues(duesInfo); }
		
	//...................................save transaction here..............................//	
		transactionInfo.setStatus("Sale By: Nazmul Hasan, Branch:Mirpur");
		  transactionInfo.setInvoice(invoice); transactionInfo.setTotalBill(totalSale);
		  transactionInfo.setPaidBill(actualPaidAmount);
		  transactionInfo.setTotalPaidBill(actualPaidAmount);
		  transactionInfo.setDues(dues);
		  transactionInfo.setIssueDate(new Date());
		  transactionImpl.doSaveTransactionHistory(transactionInfo);
	//.........................end transaction here............................................//		 
		
		return "redirect:/sale/sale_form_show";
	}
	
	@GetMapping("/show_sale_date_wise_form")
	public String showSaleFormDateWise() {
		
		return "show_sale_date_wise";
	}
	
	@GetMapping("/get_all_sale_date_wise/{catagoryName}/{startDate}/{endDate}")
	@ResponseBody
	public List<SaleInfo> getSaleDateWise(
			 @PathVariable(name="catagoryName",required=false)String catagoryName, @PathVariable("startDate")  @DateTimeFormat(pattern = "dd-MM-yy") Date startDate, @PathVariable("endDate")  @DateTimeFormat(pattern = "dd-MM-yy") Date endDate){
		System.out.print("null "+ catagoryName);
		List<SaleInfo> saleList=null;
		try {
			//LocalDate endDatePlusOne = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1);
			Calendar c = Calendar.getInstance(); 
			c.setTime(endDate); 
			c.add(Calendar.DATE, 1);
			endDate = c.getTime();
			
			  System.out.print(catagoryName !=null && catagoryName.equals(" null"));
			   if(catagoryName !=null && !catagoryName.equals("null")) {
				   saleList=saleImpl.getDataTwoDateAndCatagoryProductId(catagoryName, startDate, endDate);
				
			   } else{
				   System.out.print("Testing......");
					  saleList=saleImpl.getAllSaleDateWise(startDate, endDate);
					  }
			   
					 
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return saleList;
	}
	
	
	

}
