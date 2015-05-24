package com.coop.parish.web.actions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	public static final Logger log = LogManager.getLogger(HomeAction.class.getName());
	public String id;
	private HomeModal homeModal;
	public String execute(){
		
		System.out.println("Hai u r at home");
		log.error("hai u r here");
		log.error("is id inserted"+id);
		
		//System.out.println("msg is"+homeModal.getMsg());
		return "success";
	}
	public HomeModal getHomeModal() {
		return homeModal;
	}
	public void setHomeModal(HomeModal homeModal) {
		this.homeModal = homeModal;
	}
}
