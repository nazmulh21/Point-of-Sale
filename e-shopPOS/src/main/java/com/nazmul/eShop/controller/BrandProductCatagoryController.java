package com.nazmul.eShop.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nazmul.eShop.ServiceImpl.BrandProductCatagorySaveServiceImpl;
import com.nazmul.eShop.model.BrandInfo;
import com.nazmul.eShop.model.BrandProductCatagorySaveInfo;
import com.nazmul.eShop.model.SaleInfo;
import com.nazmul.eShop.service.BrandProductCatagorySaveService;

@Controller
@RequestMapping("/category")
public class BrandProductCatagoryController {
	private BrandProductCatagorySaveService service;
	
	@Autowired
	private BrandProductCatagorySaveServiceImpl brandProductCataImpl;

	public BrandProductCatagoryController(BrandProductCatagorySaveService service) {

		this.service = service;
	}
	
	@GetMapping("/category_show")
	public ModelAndView showBrand() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("brandProductCatagory", new BrandProductCatagorySaveInfo());
		mav.setViewName("brand_product_catagory_form");
		return mav;

	}
	@PostMapping("/brand_Product_Catagory_Save")
	public String doSave(BrandProductCatagorySaveInfo info,RedirectAttributes redirect) {
		Random random = new Random();
		String rand = String.valueOf(random.nextInt(9000)); 
		String nam =info.getCatagoryName(); 
		int brand=info.getBrandCode(); 
		String lastChar =String.valueOf(nam.charAt(nam.length() - 1)).toUpperCase();
		String pid = info.getCatagoryName();// .split("-",2); // 
     	//String arraValue= Arrays.toString(pid);
		String val = pid.substring(0, 3).toUpperCase()+brand +rand + lastChar;
		info.setCatagoryProductId(val);
				 
		service.doSave(info);
		redirect.addFlashAttribute("msg", "Brand Product and Category Save Successfully");
		
		return "redirect:/category/category_show";
	}
	

	@GetMapping("/get_all_product_name") //Show all product name, this method created for show sale product name wise
	@ResponseBody
	public List<BrandProductCatagorySaveInfo> getProductName(){
		List<BrandProductCatagorySaveInfo> productList=null;
		try {
			productList=brandProductCataImpl.getAllProductName();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return productList;
	}

}
