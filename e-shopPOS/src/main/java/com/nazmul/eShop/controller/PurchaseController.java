package com.nazmul.eShop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nazmul.eShop.RandomStringGenerator;
import com.nazmul.eShop.ServiceImpl.CommentsInfoServiceImpl;
import com.nazmul.eShop.ServiceImpl.CurrentDeskInfoImpl;
import com.nazmul.eShop.ServiceImpl.PurchaseServiceImpl;
import com.nazmul.eShop.ServiceImpl.StockServiceImpl;
import com.nazmul.eShop.model.CommentsInfo;
import com.nazmul.eShop.model.CurrentDeskInfo;
import com.nazmul.eShop.model.PurchaseInfo;
import com.nazmul.eShop.model.StockInfo;
import com.nazmul.eShop.service.PurchaseService;

@Controller
@RequestMapping("/p")
public class PurchaseController {
	@Autowired
	private StockServiceImpl stockImpl;

	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private PurchaseServiceImpl purchaseServiceImpl;
	
	@Autowired
	private CommentsInfoServiceImpl commentsImpl;
	
	@Autowired
	private CurrentDeskInfoImpl currentDeskImpl;

	public PurchaseController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}

	@GetMapping("/admin")
	public String showMainPage() {

		return "admin";
	}

	@GetMapping("/purchase")
	public ModelAndView show(RedirectAttributes redirect, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new PurchaseInfo());
		mav.setViewName("/purchase_form");
		// redirect.addFlashAttribute("test",new PurchaseInfo().getPriceKey());

		return mav;

	}

	@PostMapping("/save_purchase/{inv}/{comment}")
	public RedirectView savePurchase(@PathVariable String inv,@PathVariable(name="comment",required=false) String comment,@RequestBody List<PurchaseInfo> purchases, RedirectAttributes redirect, CommentsInfo commentsInfo, CurrentDeskInfo currentDeskInfo) {
		int min = 100;
		int max = 1000;
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		
		List<PurchaseInfo> list = new ArrayList<>();
		for (PurchaseInfo purchas : purchases) {
			
			String pvalue = purchas.getPurchasePrice();
			String pv = String.valueOf(random_int);
			String mainValu = pv + pvalue;
			purchas.setPriceKey((mainValu));
			purchas.setStatus("1");
			purchas.setProductInsertBy("xyz");
			purchas.setProduct_update_by("xyz");
			purchas.setInsDate(new Date());
			purchas.setUpdateDate(new Date());
			//purchas.setExpiredDate(new Date());
		  //System.out.print("Dateeeeeeeee"+purchas.getExpiredDate());
		
			
			list.add(purchas);
		}
		
		List<PurchaseInfo> purchas = purchaseService.doSaveProductAll(list);
		//..............Here Save Comments, Status and Current Desk in Comment table.............//
		  if(comment!=null && !comment.equals("null")) {
			  commentsInfo.setInvoiceNo(inv);
	    		commentsInfo.setStatus("Created by:Nazmul Hasan in branch:Mirpur-01");
	    		commentsInfo.setComments(comment);
	    		commentsInfo.setCurrentDesk("Aproval User");
	    		commentsInfo.setProcessTime(new Date());
	    		commentsImpl.doSaveComments(commentsInfo);
		  }else {
			    commentsInfo.setInvoiceNo(inv);
	    		commentsInfo.setStatus("Created by:Nazmul Hasan in branch:Mirpur-01");
	    		commentsInfo.setComments("");
	    		commentsInfo.setCurrentDesk("Aproval User");
	    		commentsInfo.setProcessTime(new Date());
	    		commentsImpl.doSaveComments(commentsInfo);
	    		
		  }
		  //........................current Desk Save here..................................//
		  currentDeskInfo.setInvoiceNo(inv);
		  currentDeskInfo.setCurrentDesk("Aproval User");
		  currentDeskImpl.doSaveCurrentDesk(currentDeskInfo);
    		
		redirect.addFlashAttribute("mss", "Purchase Save Successfully");
		return new RedirectView("/p/purchase");
	}

	/*
	 * @GetMapping("/inv")
	 * 
	 * @ResponseBody public String createInvoice() { // create date as a number
	 * 
	 * Date dt = new Date(); SimpleDateFormat ft = new SimpleDateFormat("ddMMyy");
	 * String datId = ft.format(dt); // model.addAttribute("invoice", datId); //
	 * System.out.print("Date Id" + datId);
	 * 
	 * PurchaseInfo inv = purchaseService.maxval(); int i = 1; if (inv == null) {
	 * 
	 * return "P" + datId + "001"; } else {
	 * 
	 * LocalDate localDate = LocalDate.now();
	 * 
	 * if (LocalDate.now().withDayOfMonth(1).isEqual(localDate)) {
	 * 
	 * return "P" + datId + "001";
	 * 
	 * } else {
	 * 
	 * AtomicInteger atomicInteger = new AtomicInteger(); return "P" + datId + "00"
	 * + atomicInteger.addAndGet(1);
	 * 
	 * }
	 * 
	 * } }
	 */
  // this method used for create invoice no.
	@GetMapping("/getInv")
	@ResponseBody
	public String getInvoiceNo() {
		// create date as a number

		PurchaseInfo inv = purchaseService.maxval();
		String sysDate = new SimpleDateFormat("ddMMyy").format(new Date());
		if(inv==null) {
			inv=new PurchaseInfo();
			inv.setInvoiceNo("P00000000000");
		}
		String invoiceNumber = inv.getInvoiceNo();
		String initial ="P"+ new SimpleDateFormat("ddMMyy").format(new Date());
		Integer nextInt = Integer.parseInt(invoiceNumber.substring(7, 10));
		Integer nextTotal =Integer.parseInt(invoiceNumber.substring(invoiceNumber.length()-3));
        
		
		RandomStringGenerator randObj = new RandomStringGenerator();
		String invoice = randObj.getSequence(initial, nextInt,nextTotal);
		

		return invoice;
		}
	

	/*
	 * String initial = new SimpleDateFormat("ddMMyy").format(new Date());
	 * 
	 * int nextInt = 0; RandomStringGenerator randObj = new RandomStringGenerator();
	 * String retu = randObj.getSequence(initial, nextInt, null);
	 */
 //this method used for Purchase list wait for permit.
	@GetMapping("/purchaseList")
	public String plistShow() {
		return "redirect:/p/plist";
	}
	
	 //show all purchase list for permission 
	@GetMapping("/plist") 
	public String purchaseList(Model model) {
		String msgg="No record found !!";
		List<PurchaseInfo> list = null;
		list = purchaseServiceImpl.purchaseList();
		
		
		model.addAttribute("plist", new PurchaseInfo());
		model.addAttribute("Purchaselist", list);
		if(list.isEmpty()) {
			model.addAttribute("msgg",msgg);
		}
		
		return "purchaseListShowStatusActive_form";
	}
	
	//this method used show  login page
	@GetMapping("/login")
	public String doLogin() {
		
		return "redicrect:/p/admin";
	}
	
	
	@GetMapping("/permit/{invoiceNo}") //product add to stock by invoice No 
	public String permitShow(@PathVariable("invoiceNo") String invoiceNo, Model model) {
		List<PurchaseInfo> list = null;
		list = purchaseServiceImpl.findByInvoiceNo(invoiceNo);
		//list.stream().filter(p ->
		model.addAttribute("plist", list);
		model.addAttribute("invoiceNo", invoiceNo);
		return "purchases_permission_form";
	}
	
	
	
	//Here Purchase Product show by between date to date
	
	@GetMapping("/findByDateProduct/{startDate}/{endDate}")
	@ResponseBody
  public List<PurchaseInfo> findByDateProduct (@PathVariable("startDate")  @DateTimeFormat(pattern = "dd-MM-yy") Date startDate, @PathVariable("endDate")  @DateTimeFormat(pattern = "dd-MM-yy") Date endDate, 
		  PurchaseInfo info, Model model) throws Exception{
		String noDataFound="No record found...!!";
		Calendar c = Calendar.getInstance();
		c.setTime(endDate);
		c.add(Calendar.DATE, 1);
		endDate = c.getTime();

		List<PurchaseInfo> findByDateList = null;
		findByDateList = purchaseServiceImpl.findByBetweenDateProduct(startDate, endDate);
		model.addAttribute("findByDateList", findByDateList);
		
		if(findByDateList.isEmpty()) {
			model.addAttribute("noDataFound", noDataFound);
			
		}
		return findByDateList;
	}
	
	
	
	@GetMapping("/product_show_date_wise")
	public String doShowProductDateWiseForm() {
		
		return "show_product_findBy_date_wise";
	}
	
	
//........................sent Back................................................................//
	@GetMapping("/sent_back/{invoiceNo}") //product add to stock by invoice No 
	public String sentBack(@PathVariable("invoiceNo") String invoiceNo, Model model, HttpSession session) {
		List<PurchaseInfo> list = null;
		list = purchaseServiceImpl.findByInvoiceNo(invoiceNo);
		model.addAttribute("plist", list);
		model.addAttribute("invoiceNo", invoiceNo);
		session.setAttribute("invoiceNo", invoiceNo);
		return "sent_back_form";

	}
	
	
	
	
    //....................................update and sent back......................................//
		@GetMapping("/sent_back_purchase") 
		public RedirectView saveStocks(RedirectAttributes redirect,PurchaseInfo info, WebRequest req,Model model,CommentsInfo commentsInfo, CurrentDeskInfo currentDeskInfo) {
			      //info.setComment("comment");
			      info.setSentBackBy("Nazmul");
			      model.addAttribute("info",info);
			purchaseServiceImpl.sentBackUpdate(info.getComment(), info.getSentBackBy(),info.getInvoiceNo());
			
			//..............Here Save Comments, Status and Current Desk in Comment table.............//
			  
			commentsInfo.setInvoiceNo(info.getInvoiceNo());
			commentsInfo.setStatus("Sent Back by:Nazmul Hasan in branch:Mirpur-01");
			commentsInfo.setComments(info.getComment());
			commentsInfo.setCurrentDesk("Branch Maker User");
			commentsInfo.setProcessTime(new Date());
			commentsImpl.doSaveComments(commentsInfo);

			// ........................current Desk Save here..................................//
			

			currentDeskInfo.setInvoiceNo(info.getInvoiceNo());
			currentDeskInfo.setCurrentDesk("Branch Maker User");
			currentDeskImpl.doSaveCurrentDesk(currentDeskInfo);
			 
	    
			redirect.addFlashAttribute("mss", "Sent Back Successfully");
			return new RedirectView("/p/admin");
			
		}
		
		//show all Sent Back List wait here
		@GetMapping("/sent_back_list")
		public String getSentBankList() {
			
			return "redirect:/p/get_sent_back_list";
		}
		
		
		// Get all sent back purchase list where wait for update
		@GetMapping("/get_sent_back_list")
		//@ResponseBody
		public String  getSentBackList(Model model){
			String msg="No record found !!";
			List<PurchaseInfo> list=null;
			list=purchaseServiceImpl.sentBackList();
			if(list.isEmpty()) {
				model.addAttribute("msg",msg);
			}
			model.addAttribute("sent_back_list",list);
			return "sent_back_list_form";
		}
	//.....................from sent back list 	to update page.............................//
		@GetMapping("/update/{invoiceNo}") //sentBack update here 
		public String updateSentBack(@PathVariable("invoiceNo") String invoiceNo,Model model,PurchaseInfo purchaseInfo) {
			List<PurchaseInfo> list = null;
			list = purchaseServiceImpl.findByInvoiceNo(invoiceNo);
			model.addAttribute("plist", list);
			model.addAttribute("invoiceNo", invoiceNo);
			model.addAttribute("comment",purchaseInfo.getComment());
			
   
			return "sent_back_update_form";
		}
		
		
		//............................from approval user sent back application for updated to maker user here and sent to approval user after updated....................................//
		@PutMapping("/update_sentBack_application/{invoiceNo}/{comment}")
		@ResponseBody
		public String updatSentBackApplication(@RequestBody List<PurchaseInfo> purchases,@PathVariable("invoiceNo") String invoiceNo, @PathVariable(name="comment",required=false) String comment,CommentsInfo commentsInfo, CurrentDeskInfo currentDeskInfo) {

			for (PurchaseInfo info : purchases) {
				String catagoryProduct = info.getCatagoryProductId();
				String qty = info.getProductQuanity();
				String purchasePric = info.getPurchasePrice();
				String sellingP = info.getSellingPrice();
				String priceKe = info.getPriceKey();
				String firstTherreDigitGet = priceKe.substring(0, 3);
				String newPriceKey = firstTherreDigitGet + purchasePric;
				String unitOfQty = info.getUnitOfQuanity();
				String updateBy = "Nazmul";
			 
			 purchaseServiceImpl.updatePurchaseAfterSentBack(qty,purchasePric,sellingP,newPriceKey,unitOfQty,updateBy,invoiceNo,catagoryProduct);
			 
			}
			//..............Here Save Comments, Status and Current Desk in Comment table.............//
			if (comment != null && !comment.equals("null")) {
				commentsInfo.setInvoiceNo(invoiceNo);
				commentsInfo.setStatus("Updated after senent back by:Nazmul Hasan in branch:Mirpur-01");
				commentsInfo.setComments(comment);
				commentsInfo.setCurrentDesk("Approval User");
				commentsInfo.setProcessTime(new Date());
				commentsImpl.doSaveComments(commentsInfo);
			} else {
				commentsInfo.setInvoiceNo(invoiceNo);
				commentsInfo.setStatus("Updated after sent back by:Nazmul Hasan in branch:Mirpur-01");
				commentsInfo.setComments("");
				commentsInfo.setCurrentDesk("Approval User");
				commentsInfo.setProcessTime(new Date());
				commentsImpl.doSaveComments(commentsInfo);
			}
			
			 //........................current Desk Save here..................................//
			currentDeskInfo.setInvoiceNo(invoiceNo);
			currentDeskInfo.setCurrentDesk("Aproval User");
			  currentDeskImpl.doSaveCurrentDesk(currentDeskInfo);
	    		
			
			return "Updated";
		}
		
	
	
	
}
