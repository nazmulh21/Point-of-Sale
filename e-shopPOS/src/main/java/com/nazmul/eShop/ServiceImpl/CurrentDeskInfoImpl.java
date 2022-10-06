package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.CurrentDeskInfo;
import com.nazmul.eShop.repository.CurrentDeskInfoRepo;
import com.nazmul.eShop.service.CurrentDeskInfoService;

@Service
@Transactional
public class CurrentDeskInfoImpl implements CurrentDeskInfoService {

	@Autowired
	private CurrentDeskInfoRepo currentDeskRepo;

	@Override
	public void doSaveCurrentDesk(CurrentDeskInfo currentDeskInfo) {
		currentDeskRepo.save(currentDeskInfo);

	}

	@Override
	public List<CurrentDeskInfo> currentDesk(String invoiceNo) {

		return currentDeskRepo.currentDeskList(invoiceNo);
	}

}
