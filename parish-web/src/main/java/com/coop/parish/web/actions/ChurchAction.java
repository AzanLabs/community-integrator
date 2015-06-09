package com.coop.parish.web.actions;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.ChurchBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.ChurchService;
import com.coop.parish.web.utils.WebUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class ChurchAction extends ActionSupport implements SessionAware {

	private static final String className = ChurchAction.class.getName(); //needed by action support class to serialize
	private static final long serialVersionUID = 3719148551858332373L; //logger
	private final Logger logger = LogManager.getLogger(ChurchAction.class);
	private ChurchBean churchBean; //church bean which will be auto populated from request
	private int id; //church_id needed for read and delete action
	private ChurchService service = null; //common service needed to communicate
	private Map<String, Object> session;
	
	public String saveChurch(){
		//save church action which needs input from churchbean
		logger.debug("Entering into Method : "+className +" > save church");
		try{
			service = ServiceLocator.instance().getChurchService();
			churchBean = service.saveChurch(churchBean);
			if(WebUtils.isUserLoggedIn(session)){
				session.put("churchId", churchBean.getId());
				session.put("isSet", "YES");
			}
		} catch (ParishException e) {
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (Exception e){
			e.printStackTrace();
			logger.error("Error during save church", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String getMyChurch(){
		//gives back the church if found , input is church_id
		try{
			service = ServiceLocator.instance().getChurchService();
			churchBean = service.getChurchById(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during getting Church", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String editChurch(){
		try{
			service = ServiceLocator.instance().getChurchService();
			churchBean = service.updateChurch(churchBean);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during updating church", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String disableChurch(){
		try{
			service = ServiceLocator.instance().getChurchService();
			id = service.deleteChurch(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during deleting church", e);
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	//getters and setters method used by the struts to inject the params 
	public ChurchBean getChurchBean() {
		return this.churchBean;
	}
	
	@RequiredFieldValidator(key="bean.required")
	@VisitorFieldValidator
	public void setChurchBean(ChurchBean churchBean) {
		this.churchBean = churchBean;
	}
	
	public void validate(){
		//custom validation method
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
