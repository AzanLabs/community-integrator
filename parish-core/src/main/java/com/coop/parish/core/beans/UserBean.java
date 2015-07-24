package com.coop.parish.core.beans;

import com.coop.parish.data.modal.User;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * User Bean Class which represents the User Entity.
 * This Bean has methods to convert Bean to Entity Object and Entity Object to beans,
 * The Entity - Bean , Bean - Entity Conversion does not Consider all the fields involved, 
 * This Bean also has the Struts Validation Annotation, Only common Validations should be present here.
 * Action Specific Validations should be done in validate method.  
 */
public class UserBean {
	
	private Integer id;
	private String identifier;
	private String password;
	private Character userType;
	private Integer priestId;
	private Integer churchId;
	
	public UserBean(){}
	
	public UserBean(Integer id) {
		this.id = id;
	}
	
	/**
	 * Converts Entity Objects to beans.
	 * Some fields present in the Entity Objects might be omitted in the beans , ex : Audit fields.
	 * Add if necessary
	 * @param user  User Entity Object, null returns empty bean with no values set. 
	 * @return userbean 
	 */
	public UserBean(User user) {
		if(user != null){
			this.setId(user.getId());
			this.setIdentifier(user.getIdentifier());
			this.setUserType(user.getType());
			this.setPriestId(user.getPriestId());
			this.setChurchId(user.getChurchId());
		}
	}
	
	/**
	 * Converts "this" bean to the relative Entity Object.
	 * The Returned Entity Object is not complete, fields which need not to be modified directly by user are omitted.
	 * @param null
	 * @return User  user Entity Object, having the values of "this" bean, returns Empty Entity Object if bean is empty
	 */
	public User toBO(){
		User user = new User();
		user.setId(this.getId());
		user.setIdentifier(this.getIdentifier());
		user.setPassword(this.getPassword());
		user.setType(this.getUserType());
		
		return user;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Identifier"})
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"Password"})
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Character getUserType() {
		return userType;
	}

	public void setUserType(Character userType) {
		this.userType = userType;
	}
	
	public Integer getPriestId() {
		return priestId;
	}

	public void setPriestId(Integer priestId) {
		this.priestId = priestId;
	}
	
	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}
}
