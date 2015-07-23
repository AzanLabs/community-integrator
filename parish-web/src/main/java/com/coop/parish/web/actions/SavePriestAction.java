package com.coop.parish.web.actions;

import java.io.File;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.coop.parish.core.ServiceLocator;
import com.coop.parish.core.beans.PriestBean;
import com.coop.parish.core.beans.UserBean;
import com.coop.parish.core.exceptions.ParishException;
import com.coop.parish.core.service.PriestService;
import com.coop.parish.web.utils.UploadUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class SavePriestAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 2819892671305369437L;
	private PriestBean priestBean;
	private Map<String, Object> session;
	//for file upload
	private File file;
	private String contentType;
	private String fileName;
	
	public String save(){
		try{
			UserBean user = (UserBean)session.get("user");
			if(file != null){
				UploadUtils.checkFileSize(file, 400L);
				UploadUtils.checkFileType(file, contentType);
			}
			PriestService service = ServiceLocator.instance().getPriestService();
			priestBean = service.savePriest(priestBean, user, null);
		
		}catch(ParishException e){
			addActionError(e.getMessage());
			e.printStackTrace();
			return Action.ERROR;
		}catch(Exception e){
			addActionError(e.getMessage());
			e.printStackTrace();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}

	public PriestBean getPriestBean() {
		return priestBean;
	}
	
	@RequiredFieldValidator(message="Invalid Request")
	public void setPriestBean(PriestBean priestBean) {
		this.priestBean = priestBean;
	}
	
	public void setUpload(File file){
		this.file = file;
	}
	
	public void setUploadContentType(String contentType){
		this.contentType = contentType;
	}
	
	public void setUploadFileName(String fileName){
		this.fileName = fileName;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
