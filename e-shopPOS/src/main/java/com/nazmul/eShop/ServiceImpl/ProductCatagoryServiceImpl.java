package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.ProductCatagoryInfo;
import com.nazmul.eShop.repository.ProductCatagoriRepo;
import com.nazmul.eShop.repository.ProductCatagoryRepository;
import com.nazmul.eShop.service.ProductCatagoryService;

@Service
@Transactional
public class ProductCatagoryServiceImpl implements ProductCatagoryService{
	
	@Autowired
	private ProductCatagoryRepository repo;

	@Override
	public List<ProductCatagoryInfo> listAllProductCatagory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<ProductCatagoryInfo> listAllCatagoryByProductId(int brandCode, int productId) {
		List<ProductCatagoryInfo> list=null;
		try {
			list=repo.findAllByProductId(brandCode,productId);
			System.out.print("from ServiceImp"+list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ProductCatagoryInfo getCatagoryByCode(int catagoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
