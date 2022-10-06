package com.nazmul.eShop.ServiceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nazmul.eShop.model.CommentsInfo;
import com.nazmul.eShop.repository.CommentsInfoRepository;
import com.nazmul.eShop.service.CommentsService;
@Service
@Transactional
public class CommentsInfoServiceImpl implements CommentsService {
	
	@Autowired
	private CommentsInfoRepository commentsRepo;

	@Override
	public void doSaveComments(CommentsInfo commentsInfo) {
		
		commentsRepo.save(commentsInfo);
	}

	@Override
	public List<CommentsInfo> commentList(String invoiceNo) {
		
		return commentsRepo.commentsList(invoiceNo);
	}

	/*
	 * @Override public List<CommentsInfo> currentdDesk(String invoice) {
	 * 
	 * return commentsRepo.findTopByOrderByCurrentDeskDesc(invoice); }
	 */

}
