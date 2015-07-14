package com.coop.parish.core.beans;

import com.coop.parish.data.modal.User;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class UserBean {
	
	private int id;
	private String identifier;
	private String password;
	private String role;
	private Integer churchId;
	private Integer parishId;
	private boolean isActive;
	
	public UserBean(){}
	
	public UserBean(int id){
		this.id = id;
	}
	
	public UserBean(User user){
		if(user != null){
			this.setId(user.getId());
			this.setIdentifier(user.getIdentifier());
			this.setPassword(user.getPassword());
			this.setActive(user.isActive());
		}
	}
	
	public User toBO(){
		User user = new User();
		user.setId(this.getId());
		user.setIdentifier(this.getIdentifier());
		user.setPassword(this.getPassword());
		user.setActive(this.isActive());
		return user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"asa"}, message="")
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@RequiredStringValidator(key="bean.field.required", messageParams={"asa"}, message="")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Integer getChurchId() {
		return churchId;
	}

	public void setChurchId(Integer churchId) {
		this.churchId = churchId;
	}

	public Integer getParishId() {
		return parishId;
	}

	public void setParishId(Integer parishId) {
		this.parishId = parishId;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
