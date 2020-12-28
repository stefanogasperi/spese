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

import com.appspese.dao.UtenteDao;
import com.appspese.dto.Utente;
import com.appspese.dto.UtenteMapper;


@Transactional
@Path("/utenti")
public class UtenteController {

	@Inject
	private UtenteDao utenteDao;
	
	@Inject
	private UtenteMapper utenteMapper;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtente(@PathParam("id") Long id) {
		return Response.ok().entity(utenteDao.findById(id)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUtenti() {
		return Response.ok().entity(utenteDao.findAll()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUtente(Utente utenteDto) {
		List<com.appspese.model.Utente> utenteList = utenteDao.findByNome(utenteDto.getNome());
		if (utenteList.size()>0) {
			return Response.status(Response.Status.BAD_REQUEST).entity("Utente gia presente").build();			
		}
		com.appspese.model.Utente utenteNew = utenteMapper.utenteDtoToUtente(utenteDto);
		utenteDao.persist(utenteNew);
		return Response.ok().entity(utenteNew).build();
	}
}
