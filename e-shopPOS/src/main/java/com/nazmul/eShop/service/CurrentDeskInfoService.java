package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.CurrentDeskInfo;

public interface CurrentDeskInfoService {
	void doSaveCurrentDesk(CurrentDeskInfo currentDeskInfo);
	
   List<CurrentDeskInfo> currentDesk(String invoiceNo);
}
