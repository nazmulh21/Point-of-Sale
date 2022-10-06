package com.nazmul.eShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.nazmul.eShop.ServiceImpl.BrandServiceImpl;
import com.nazmul.eShop.model.BrandInfo;
import com.nazmul.eShop.model.ProductInfo;
import com.nazmul.eShop.service.BrandService;

@Controller
@RequestMapping("/b")
public class BrandController {
	@Autowired
	private BrandServiceImpl brandServiceImpl;
	
	private final BrandService bService;

	public BrandController(BrandService bService) {
		
		this.bService = bService;
	}
	
	@GetMapping("/brand")
	public ModelAndView showBrand() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("brand", new BrandInfo());
		mav.setViewName("brand_form");
		return mav;

	}

	
	
	
	@PostMapping("/brand_save")
	public RedirectView doSaveAllBrand(@RequestBody BrandInfo brandInfo, RedirectAttributes redirect) {
		brandInfo=bService.dosave(brandInfo);
		System.out.print("Afterrr " + brandInfo.getBrandName());
		   
		redirect.addFlashAttribute("msg", "Brand Name Save Successfully");
		
		return new RedirectView("/brandProduct/");
	}
	
	
	@RequestMapping(value = "/brand_list", method = RequestMethod.GET)
	@ResponseBody
	public List<BrandInfo> showAllBrand(Model model) {
		List<BrandInfo> listBrand = null;
		try {
			listBrand = brandServiceImpl.getBrandList();
			System.out.print("After All Brandddd " + listBrand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBrand;

	}
	
	@RequestMapping(value = "/brand_list_show_product_table", method = RequestMethod.GET)
	@ResponseBody
	public List<BrandInfo> showAllBrandForInserProductTable(Model model) {
		List<BrandInfo> listBrand = null;
		try {
			listBrand = brandServiceImpl.BrandBrandListForInsert();
			System.out.print("After All Brandddd " + listBrand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBrand;

	}
	

}
