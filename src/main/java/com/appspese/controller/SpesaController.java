package com.appspese.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.appspese.dao.SpesaDao;
import com.appspese.dao.UtenteDao;
import com.appspese.dto.Spesa;
import com.appspese.dto.SpesaMapper;
import com.appspese.dto.UtenteMapper;
import com.appspese.model.Utente;


@Path("/spese")
@Transactional
public class SpesaController {
	
	@Inject
	private SpesaDao speseDao;

	@Inject
	private UtenteDao utenteDao;
	
	@Inject
	private SpesaMapper spesaMapper;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSpesa(Spesa spesaDto) {
		List<Utente> utenteList = utenteDao.findByNome(spesaDto.getChi());
		if (utenteList.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Utente non presente").build();			
		}
		com.appspese.model.Spesa spesaNew = spesaMapper.spesaDtoToSpesa(spesaDto);
		spesaNew.setChi(utenteList.get(0));
		speseDao.persist(spesaNew);
		Spesa spesaOut = spesaMapper.spesaToSpesaDto(spesaNew);
		return Response.status(Status.CREATED).entity(spesaOut).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpesa(@PathParam("id") Long id) {
		com.appspese.model.Spesa s = speseDao.findById(id);
		return Response.ok().entity(s).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpese() {
		List<com.appspese.model.Spesa> sl = speseDao.findAll();
		return Response.ok().entity(sl).build();
	}
	
}
