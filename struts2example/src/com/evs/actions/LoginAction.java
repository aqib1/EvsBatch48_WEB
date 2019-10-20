package com.evs.actions;

import com.evs.models.UserModel1;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserModel1>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserModel1 userModel1;
	
	@Override
	public String execute() throws Exception {
		String result = "success";
		System.out.println(userModel1.getName());
		return result;
	}
	public void setUserModel1(UserModel1 userModel1) {
		this.userModel1 = userModel1;
	}
	public UserModel1 getUserModel1() {
		return userModel1;
	}
	@Override
	public UserModel1 getModel() {
		userModel1 = new UserModel1();
		return userModel1;
	}

}
