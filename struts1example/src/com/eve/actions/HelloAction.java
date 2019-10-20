package com.eve.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.eve.form.MyForm;

public class HelloAction extends Action{

@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {
	MyForm myForm = (MyForm) form;
	myForm.setMessage("hi there aqib");
	request.setAttribute("isShow", myForm.isShow());
	return mapping.findForward("success");
}
}
