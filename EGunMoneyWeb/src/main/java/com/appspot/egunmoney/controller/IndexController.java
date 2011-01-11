package com.appspot.egunmoney.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.appspot.egunmoney.utility.SessionManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

/**
 * Index Controller
 * @author dklee
 * @since 2010.09.13
 */
@Component
@Scope("request")
public class IndexController {
	
	public String execute() {
		
		SessionManager.newInstance( ActionContext.getContext().getSession() );
		
		return Action.SUCCESS;
	}
}
