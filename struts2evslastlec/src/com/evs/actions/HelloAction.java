package com.evs.actions;

import com.evs.models.HelloModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class HelloAction extends ActionSupport implements ModelDriven<HelloModel> {
	/**
		 * 
		 */
	private static final long serialVersionUID = 4506472145501739120L;
	private HelloModel model;

	@Override
	public String execute() throws Exception {
		return "success";
	}

	public String abc() {
		return "success";
	}

	public void setModel(HelloModel model) {
		this.model = model;
	}

	@Override
	public HelloModel getModel() {
		this.model = new HelloModel();
		return this.model;
	}
}
