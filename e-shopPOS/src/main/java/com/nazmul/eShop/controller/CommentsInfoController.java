package com.nazmul.eShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nazmul.eShop.ServiceImpl.CommentsInfoServiceImpl;
import com.nazmul.eShop.model.CommentsInfo;

@Controller
@RequestMapping("/comment")
public class CommentsInfoController {
	@Autowired
	private CommentsInfoServiceImpl commentsImpl;
	
	
	
	@GetMapping("/commentList/{invoiceNo}")
	@ResponseBody
	public List<CommentsInfo> showAllComments(@PathVariable String invoiceNo){
		 List<CommentsInfo> commentList=null;
		 try {
			 commentList=commentsImpl.commentList(invoiceNo);
		} catch (Exception e) {
			
		}
		 return commentList;
	}
	
	/*
	 * @GetMapping("/currentDesk")
	 * 
	 * @ResponseBody public List<CommentsInfo> currentDesk(//@PathVariable String
	 * invoiceNo ){ List<CommentsInfo> currentDesk=null; try {
	 * currentDesk=commentsImpl.currentdDesk("P100922017017"); } catch (Exception e)
	 * {
	 * 
	 * } return currentDesk; }
	 */
	
}
