package com.nazmul.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.CurrentDeskInfoImpl;
import com.nazmul.eShop.model.CurrentDeskInfo;

@Controller
@RequestMapping("/currentDesk")
public class CurrentDeskInfoController {
	
	@Autowired
	private CurrentDeskInfoImpl currentDeskImpl;
	
	
	@GetMapping("/curent_status/{invoice}")
	@ResponseBody
	public List<CurrentDeskInfo> currentDesk(@PathVariable String invoice){
		List<CurrentDeskInfo> currentDeskList=null;
		
		try {
			currentDeskList=currentDeskImpl.currentDesk(invoice);
		} catch (Exception e) {
			
		}
		
		return currentDeskList;
	}

}
