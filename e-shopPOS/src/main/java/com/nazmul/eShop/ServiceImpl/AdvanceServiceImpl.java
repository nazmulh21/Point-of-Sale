package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.AdvanceInfo;
import com.nazmul.eShop.repository.AdvanceRepo;
import com.nazmul.eShop.service.AdvanceService;

@Service
@Transactional
public class AdvanceServiceImpl implements AdvanceService{
	
	@Autowired
	private AdvanceRepo advanceRepo;

	@Override
	public void doSaveAdvance(AdvanceInfo advanceInfo) {
		advanceRepo.save(advanceInfo);
		
	}

	@Override
	public List<AdvanceInfo> getAdvanceByMobile(String mobile) {
		
		return advanceRepo.getAdvanceByMobile(mobile);
	}

	@Override
	public void updateAdvance(String advance, String customerMobile) {
		advanceRepo.updateAdvance(advance, customerMobile);
		
	}

	@Override
	public String getAdvanceBeforeSave(String customerMobile) {
		
		return advanceRepo.getAdvanceBeforSave(customerMobile);
	}

	
}
