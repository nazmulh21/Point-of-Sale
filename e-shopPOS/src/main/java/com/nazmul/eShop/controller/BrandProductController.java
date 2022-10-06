package com.nazmul.eShop.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nazmul.eShop.ServiceImpl.BrandAndProductServiceImpl;
import com.nazmul.eShop.model.BrandAndProductInfo;
import com.nazmul.eShop.model.ProductInfo;
import com.nazmul.eShop.model.ProductInfoId;
import com.nazmul.eShop.service.BrandAndProductService;

@Controller
@RequestMapping("/brandProduct")
public class BrandProductController {
	private final BrandAndProductService brandService;
	
	
	
	
	public BrandProductController(BrandAndProductService brandService) {
		
		this.brandService = brandService;
	}
	
	@GetMapping("/")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", new BrandAndProductInfo());
		mav.setViewName("/product_form");
		return mav;

	}



	@PostMapping("/save")
	public RedirectView doSveProduct(@ModelAttribute BrandAndProductInfo brandProductInfo, RedirectAttributes redirect) {
		
		 // Random random = new Random(); String rand =
		 // String.valueOf(random.nextInt(9000)); String nam =
		 // brandProductInfo.getProductName(); String
		 // brand=brandProductInfo.getBrandCode(); String lastChar =
		 // String.valueOf(nam.charAt(nam.length() - 1)).toUpperCase(); 
		 // String pid =brandProductInfo.getProductName();// .split("-",2); // 
		 // String arraValue= Arrays.toString(pid); 
		 // String val = pid.substring(0, 3).toUpperCase()+brand +
		 // rand + lastChar;
		//brandProductInfo.setProductId(val);
		 
		
		
		//create invoice from date
		Date dt = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("ddMMyy");
		String datId = ft.format(dt);
		System.out.print("Date Id " + datId);

		brandProductInfo = brandService.doSaveBrandProduct(brandProductInfo);
		redirect.addFlashAttribute("msg", "Brand and Product Save Successfully");
		return new RedirectView("/brandProduct/");
	}

}
