package com.appspese.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/spese")
public class ProvaController {
	
	@GET
	@Path("/prova")
	@Produces(MediaType.APPLICATION_JSON)
	public Response prova() {
		return Response.ok().entity("Hello word!").build();
	}

}
