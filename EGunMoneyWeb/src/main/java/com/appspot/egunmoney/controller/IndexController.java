package com.appspot.egunmoney.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Index Controller
 * @author dklee
 * @since 2010.09.13
 */
@Component
@Scope("request")
public class IndexController {
	
	public String execute() {
		return "";
	}
}
