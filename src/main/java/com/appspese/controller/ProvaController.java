package com.appspese.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appspese.service.SqlInjService;

@Path("/")
public class ProvaController {
	
	@Inject
	private SqlInjService sqlInj;
	
	@GET
	@Path("/prova")
	@Produces(MediaType.APPLICATION_JSON)
	public Response prova() {
		return Response.ok().entity("Hello word!").build();
	}

	@GET
	@Path("/sqlinj")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response sqlinjection(@QueryParam("pwd") String pwd) {
		System.out.println("pwd="+pwd);
		//pwd = (pwd==null)?"pwd1":pwd; //"pwd1"  //"pwd1' or 1=1 --''"
		//pwd = "pwd1' or 1=1 --'";
		pwd = "pwd2";
		sqlInj.cq(pwd);
		System.out.println("pwd="+pwd);
		return Response.ok().entity("fatto").build();
	}
}
