package com.evs.actions;

import com.evs.models.UserModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HelloWorldAction extends ActionSupport implements ModelDriven<UserModel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserModel userModel;
	@Override
	public String execute() {
		userModel.setUsername("aqib");
		return "success";
	}
	public void setModel(UserModel userModel) {
		this.userModel = userModel;
	}
	@Override
	public UserModel getModel() {
		userModel = new UserModel();
		return userModel;
	}
}
