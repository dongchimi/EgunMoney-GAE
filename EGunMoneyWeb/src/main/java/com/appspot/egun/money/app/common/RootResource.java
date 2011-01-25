package com.appspot.egun.money.app.common;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("/")
@Produces("text/html")
public class RootResource {

	@GET
	@Path("")
	public Viewable index() {
		return new Viewable("index", null);
	}
}
