package com.nazmul.eShop.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import com.nazmul.eShop.ServiceImpl.ProductServiceImpl;
import com.nazmul.eShop.model.ProductInfo;
import com.nazmul.eShop.model.ProductInfoId;
import com.nazmul.eShop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl serviceImpl;

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	
	@RequestMapping(value = "/product_list", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductInfo> showAllProducts(Model model,WebRequest req, ProductInfo pInfo) {
		List<ProductInfo> listProducts = null;
		try {
			listProducts = serviceImpl.listAllProductByBrandCode(Integer.parseInt(req.getParameter("BRAND_CODE")));
			System.out.print("After All Producttttt " + listProducts);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listProducts;

	}
	
	
	

}
