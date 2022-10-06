package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nazmul.eShop.exception.NotFoundException;
import com.nazmul.eShop.model.StockInfo;
import com.nazmul.eShop.repository.StockRepository;
import com.nazmul.eShop.service.StockService;

@Service
@Transactional
public class StockServiceImpl implements StockService{
     
	private final StockRepository stockRepo;
	
	public StockServiceImpl(StockRepository stockRepo) {
		super();
		this.stockRepo = stockRepo;
	}

	@Override
	public void doSaveStock(StockInfo stock) {
		
		stockRepo.save(stock);
	}

	

	@Override
	public List<StockInfo> doSaveStcoks(List<StockInfo> allStock) {
		
		return stockRepo.saveAll(allStock);
	}

	@Override
	public String getQuantityByProducId(String productId) {
		
		return stockRepo.getQuantityByProductId(productId);
	}

	@Override
	public List<String> getAllProductId() {
		
		return stockRepo.getAllProductId();
	}

	@Override
	public List<StockInfo> getStockByProductId(String catagoryProductId) {
		
		return stockRepo.getStockAllByProductId(catagoryProductId) ;
	}

	@Override
	public List<String> getAllCatagoryName() {
		
		return stockRepo.getStockAllcatagoryName();
	}

	@Override
	public void updateStockAfterSale(int qty, String productId) {
		StockInfo stock= stockRepo.findById(productId).orElseThrow(()->new NotFoundException("stock product not found"));
		int quantity=stock.getProductQuantity();
		int availableQuantity=quantity-qty;
		stock.setProductQuantity(availableQuantity);
		
		stockRepo.save(stock);
	}

	@Override
	public List<StockInfo> getCurrentStock() {
		
		return stockRepo.getCurrentAllStock();
	}

	

	

	

}
