package com.nazmul.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;


import com.nazmul.eShop.ServiceImpl.ProductCatagoryServiceImpl;
import com.nazmul.eShop.model.ProductCatagoryInfo;

@Controller
public class ProductCatagoryController {
  @Autowired
  private ProductCatagoryServiceImpl impl;
	
	@GetMapping(value="/catagory_list")
	@ResponseBody
	public List<ProductCatagoryInfo> getAjaxCatagoryList(WebRequest req){
		int brandCode = Integer.parseInt(req.getParameter("brandCode"));
		 int productId=Integer.parseInt(req.getParameter("productId"));
		
		List<ProductCatagoryInfo> CatagoryList= null;
		try {
			CatagoryList=impl.listAllCatagoryByProductId(brandCode,productId);
			System.out.print(CatagoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CatagoryList;
	}
	
}
