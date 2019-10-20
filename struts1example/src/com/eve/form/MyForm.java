package com.eve.form;

import org.apache.struts.action.ActionForm;

public class MyForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7111111071770296776L;
	private String message;
	private boolean show = true;
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}

}
