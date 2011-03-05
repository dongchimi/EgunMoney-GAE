package com.appspot.egun.money.app.auth;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

@Component
@Singleton

@Produces("text/html")
@Path("/")
public class IndexResource {
 
	/** ·Î°Å */
	private static final Logger logger = Logger.getLogger(IndexResource.class.getSimpleName());
	
	@GET
	@Path("/index")
	public Viewable index() {
		logger.log(Level.WARNING, "call IndexResource");
		return new Viewable("/auth/signin.html");
	}

}
