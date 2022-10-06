package com.nazmul.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.AdvanceServiceImpl;
import com.nazmul.eShop.model.AdvanceInfo;

@Controller
@RequestMapping("/advance")
public class AdvanceController {
	
	@Autowired
	private AdvanceServiceImpl advanceImpl;
	
	@Autowired
    private AdvanceServiceImpl advanceImple;
	
	@GetMapping("/show_advance_form")
	public String showAdvanceForm() {
		return "advance_save_form";
	}
	
	@PostMapping("/advance_save")
	public String doSaveAdvance(@RequestBody AdvanceInfo advanceInfo) {
		try {
			advanceImpl.doSaveAdvance(advanceInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/advance/show_advance_form";
	}
	
	@GetMapping("/getAdvance/{mobile}")
	@ResponseBody
	public List<AdvanceInfo> getAdvanceByMobile(@PathVariable String mobile) {
		
		List<AdvanceInfo> adv=advanceImpl.getAdvanceByMobile(mobile);
		
		return adv;
	}
	
	
	
	
	//................advance save or if advance already has than update advance here..................
	@PostMapping("/getAdvance_before_save/{customerMobile}/{newAdvance}/{customerName}")
	public String saveAdvanceFromDuesPaidForm(@PathVariable String customerMobile, @PathVariable String newAdvance,
			 @PathVariable String customerName, AdvanceInfo advanceInfo) {
		
			System.out.print("newAdvance else" + newAdvance);
			advanceInfo.setCustomerMobile(customerMobile);
			advanceInfo.setAdvance(newAdvance);
			advanceInfo.setCustomerName(customerName);
			advanceImple.doSaveAdvance(advanceInfo);
		
		
		return "customer_dues_paid_form";
	}

}
