package com.nazmul.eShop.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.PurchasesMasterInvSeqServiceImpl;
import com.nazmul.eShop.model.PurchaseMasterInvoiceSecquenceInfo;

@Controller
public class PurchasesMasterInvSequenceController {

	 @Autowired
	 private PurchasesMasterInvSeqServiceImpl impl;
	 
	 @GetMapping("/inv_code")
	 @ResponseBody
	 public PurchaseMasterInvoiceSecquenceInfo getInvDes(PurchaseMasterInvoiceSecquenceInfo invSeqInfo) {
		 
		 PurchaseMasterInvoiceSecquenceInfo invCode=impl.getInvCode();
                if(invCode==null){
                	invCode=new PurchaseMasterInvoiceSecquenceInfo();
                	invCode.setInvoiceCode(1);
                	return invCode;
                	//invCode.setInvoiceNo("b");
                }
                AtomicInteger atomicInteger = new AtomicInteger(); 
               
                atomicInteger.addAndGet(1);
            
		 return invCode;
	 }
}
