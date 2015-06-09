package com.coop.parish.core.beans;

import com.coop.parish.data.modal.User;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class UserBean {
	
	private int id;
	private String identifier;
	private String password;
	private String role;
	private Integer belongsTo;
	
	public UserBean(){}
	
	public UserBean(int id){
		this.id = id;
	}
	
	public UserBean(User user){
		if(user != null){
			this.setId(user.getId());
			this.setIdentifier(user.getIdentifier());
			this.setPassword(user.getPassword());
			this.setRole(user.getRole());
			this.setBelongsTo(user.getBelongsTo());
		}
	}
	
	public User toBO(){
		User user = new User();
		user.setId(this.getId());
		user.setIdentifier(this.getIdentifier());
		user.setPassword(this.getPassword());
		user.setRole(this.getRole());
		user.setBelongsTo(this.getBelongsTo());
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
	
	public Integer getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Integer belongsTo) {
		this.belongsTo = belongsTo;
	}
}
