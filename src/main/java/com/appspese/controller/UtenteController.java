package com.appspese.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.appspese.dto.Utente;
import com.appspese.service.UtenteService;


@Path("/utenti")
public class UtenteController {

	@Inject
	private UtenteService utenteService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtente(@PathParam("id") Long id) {
		return Response.ok().entity(utenteService.findById(id)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtenti() {
		return Response.ok().entity(utenteService.findAll()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUtente(Utente utenteDto) {
		Utente utenteNew = utenteService.add(utenteDto);
		return Response.ok().entity(utenteNew).build();
	}
}
