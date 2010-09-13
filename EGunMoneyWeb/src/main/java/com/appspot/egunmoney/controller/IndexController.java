package com.appspot.egunmoney.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

/**
 * Index Controller
 * @author dklee
 * @since 2010.09.13
 */
@Component
@Scope("request")
public class IndexController {
	
	public String execute() {
		System.out.println("11111111111111111111");
		return Action.SUCCESS;
	}
}
