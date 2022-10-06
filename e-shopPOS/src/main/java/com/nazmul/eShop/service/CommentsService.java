package com.nazmul.eShop.service;

import java.util.List;

import com.nazmul.eShop.model.CommentsInfo;

public interface CommentsService {
	
	void doSaveComments(CommentsInfo commentsInfo);
	List<CommentsInfo> commentList(String invoiceNo);
   // List<CommentsInfo> currentdDesk(String invoice);
}
