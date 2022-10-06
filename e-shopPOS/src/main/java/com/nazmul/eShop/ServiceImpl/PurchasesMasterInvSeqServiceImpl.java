package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.PurchaseMasterInvoiceSecquenceInfo;
import com.nazmul.eShop.repository.PurchasesMasterInvoiceSeqRepository;
import com.nazmul.eShop.service.PurchaseMusterInvSeqService;

@Service
@Transactional
public class PurchasesMasterInvSeqServiceImpl implements PurchaseMusterInvSeqService {
	
	@Autowired
	private PurchasesMasterInvoiceSeqRepository invSeq;

	@Override
	public PurchaseMasterInvoiceSecquenceInfo getInvCode() {
		
		return invSeq.getInvoiceCodeDes();
	}
	
	
}
