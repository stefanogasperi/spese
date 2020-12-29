package com.appspese.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.appspese.dto.Spesa;
import com.appspese.service.SpesaService;


@Path("/spese")
public class SpesaController {

	@Inject
	private SpesaService spesaService;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSpesa(Spesa spesaDto) {
		Spesa spesaOut = spesaService.addSpesa(spesaDto);
		return Response.status(Status.CREATED).entity(spesaOut).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpesa(@PathParam("id") Long id) {
		Spesa spesaOut = spesaService.findById(id);
		return Response.ok().entity(spesaOut).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpese() {
		List<Spesa> sl = spesaService.findAll();
		return Response.ok().entity(sl).build();
	}
	
}
