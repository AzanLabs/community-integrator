package com.coop.parish.web.actions;

import java.io.File;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.PriestService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

public class PriestAction extends ActionSupport implements SessionAware{

	private static final String className = PriestAction.class.getName(); //needed by action support class to serialize
	private static final long serialVersionUID = 3719148551858332373L; //logger
	private final Logger logger = LogManager.getLogger(ChurchAction.class);
	private PriestBean priestBean; //priest bean which will be auto populated from request
	private int id; //priest_id needed for read and delete action
	private PriestService service = null; //common service needed to communicate
	private File file;
	private String type;
	private String fileName;
	private Map<String, Object> session;
	
	public String savePriest(){
		logger.debug("Entering into Method : "+className +" > save priest");
		/*try{
			service = ServiceLocator.instance().getPriestService();
			priestBean = service.savePriest(priestBean);
		} catch (ParishException e) {
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		} catch (Exception e){
			e.printStackTrace();
			logger.error("Error during saving priest", e);
			addActionError("Contact Sys Admin");
			return Action.ERROR;
		}*/
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String getPriestById(){
		//gives back the priest if found , input is priest_id
		try{
			service = ServiceLocator.instance().getPriestService();
			priestBean = service.getPriestById(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during getting priest", e);
			addActionError("Contact Sys Admin");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public String editPriest(){
		try{
			UserBean user = (UserBean)session.get("user");
			service = ServiceLocator.instance().getPriestService();
			priestBean = service.updatePriest(priestBean, user);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during updating priest", e);
			addActionError("Contact Sys Admin");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	@SkipValidation
	public String disablePriest(){
		try{
			service = ServiceLocator.instance().getPriestService();
			id = service.deletePriest(id);
		}catch(ParishException e){
			e.printStackTrace();
			logger.warn("caught Parish Exception "+e.getMessage());
			addActionError(e.getMessage());
			return Action.ERROR;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error during deleting church", e);
			addActionError("Contact Sys Admin");
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	
	public void validate(){
		//custom validation method
	}
	
	public void setUpload(File file){
		this.file = file;
	}
	
	public void setUploadFileName(String fileName){
		this.fileName = fileName;
	}
	
	public void setUploadContentType(String type){
		this.type = type;
	}
	public PriestBean getPriestBean() {
		return priestBean;
	}
	@RequiredFieldValidator(key="bean.required")
	@VisitorFieldValidator
	public void setPriestBean(PriestBean priestBean) {
		this.priestBean = priestBean;
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
