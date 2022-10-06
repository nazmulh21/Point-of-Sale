package com.nazmul.eShop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nazmul.eShop.ServiceImpl.CommentsInfoServiceImpl;
import com.nazmul.eShop.ServiceImpl.CurrentDeskInfoImpl;
import com.nazmul.eShop.ServiceImpl.PurchaseServiceImpl;
import com.nazmul.eShop.ServiceImpl.StockServiceImpl;
import com.nazmul.eShop.model.CommentsInfo;
import com.nazmul.eShop.model.CurrentDeskInfo;
import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.StockInfo;

@Controller
@RequestMapping("/stocks")
public class StocksController {
      @Autowired
      private StockServiceImpl stockImp;
      
      @Autowired
      private PurchaseServiceImpl purchaseImpl;
      
      @Autowired
  	  private CommentsInfoServiceImpl commentsImpl;
      
      @Autowired
  	private CurrentDeskInfoImpl currentDeskImpl;
      
      
    //Here product add to Stock table and update Purchase table where status 1. and permit completed.
      
	@PostMapping("/save_stocks/{invoiceNo}") 
	public RedirectView saveStocks(@RequestBody List<StockInfo> stocks, RedirectAttributes redirect,
			PurchaseInfo info, WebRequest req, @PathVariable("invoiceNo") String invoiceNo,CommentsInfo commentsInfo, CurrentDeskInfo currentDeskInfo) {
		
		
		List<StockInfo> list = new ArrayList<>();
		for (StockInfo stock : stocks) {
			String quanityttttt=stockImp.getQuantityByProducId(stock.getCatagoryProductId());
			if(quanityttttt==null) {
				quanityttttt=String.valueOf(0);
			}
			System.out.println("Quanittttttttttttty " +quanityttttt);
			int q=stock.getProductQuantity();
			int quantitytotal=Integer.parseInt(quanityttttt)+q;
			stock.setProductQuantity(quantitytotal);
			stock.setInsDate(new Date());
			stock.setUpdateDate(new Date());
			list.add(stock);
		}
		
		
		
		List<StockInfo> stock = stockImp.doSaveStcoks(list);
		purchaseImpl.doUpdate(invoiceNo);
		
		
		//..............Her Save Comments, Status,Current Desk in Comment table.............//
			    commentsInfo.setInvoiceNo(invoiceNo);
	    		commentsInfo.setStatus("Stock Added by:Nazmul Hasan in branch:Mirpur-01");
	    		commentsInfo.setComments("");
	    		commentsInfo.setCurrentDesk("Stock Added");
	    		commentsInfo.setProcessTime(new Date());
	    		commentsImpl.doSaveComments(commentsInfo);
	    		
	 //......................current desk update here ...........................//   		
	    		currentDeskInfo.setInvoiceNo(invoiceNo);
	    		currentDeskInfo.setCurrentDesk("Stock Added by Approval User");
				currentDeskImpl.doSaveCurrentDesk(currentDeskInfo);
		 
		
		
		redirect.addFlashAttribute("mss", "Stock Save Successfully");
		return new RedirectView("/p/admin");
		//return "redirect:/p/purchaseList";
		
	}
	
	
	
	@GetMapping("pid")  // get all product Id by this method. for further reusability.
	@ResponseBody
	public List<String> getPId(){
		List<String> pidList=null;
		pidList=stockImp.getAllProductId();
		
		return pidList;
	}
	
	
	@GetMapping("/currentStockShow")
    public String showStock() {
		return "redirect:/stocks/getCurrent_stock";
	}
	
	
	@GetMapping("/getCurrent_stock")
	public String getCurrentStock(StockInfo stock, Model model) {
		 List<StockInfo> getStockList=null;
		 getStockList=stockImp.getCurrentStock();
		 System.out.print(getStockList);
		 model.addAttribute("getStockList", getStockList);
		return "current_stock_form";
	}
	
	
}
