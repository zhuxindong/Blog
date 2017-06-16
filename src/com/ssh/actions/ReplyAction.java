package com.ssh.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class ReplyAction extends ActionSupport implements ServletRequestAware,
														  ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	
	
	
	
	
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
		this.session=request.getSession();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
