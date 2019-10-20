package com.evs.actions;

import com.evs.models.UserModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<UserModel>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8182756708438255515L;
	private UserModel model;
	@Override
	public String execute() throws Exception {
		String result = "error";
		if(model!=null) {
			if(model.getUsername()!=null && model.getPassword()!=null) {
				if(!model.getUsername().isEmpty() && !model.getPassword().isEmpty()){
					if(model.getUsername().equals("aqib") && model.getPassword().equals("123")) {
						result = "success";
					}
				}
			}
		}
		return result;
	}

	public void setModel(UserModel model) {
		this.model = model;
	}
	@Override
	public UserModel getModel() {
		model = new UserModel();
		return model;
	}
}
