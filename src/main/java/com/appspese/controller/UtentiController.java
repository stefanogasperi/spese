package com.appspese.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appspese.dao.UtentiDao;


@Path("/utenti")
public class UtentiController {

	@Inject
	private UtentiDao utentiDao;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response getUtente(@PathParam("id") Long id) {
		return Response.ok().entity(utentiDao.findById(id)).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getUtenti() {
		return Response.ok().entity(utentiDao.findAll()).build();
	}
}
