package com.appspese.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.annotation.XmlRootElement;

import com.appspese.dao.SpeseDao;
import com.appspese.dao.UtentiDao;
import com.appspese.model.Spese;
import com.appspese.model.Utenti;


@Path("/spese")
@Transactional
public class SpeseController {
	
	@Inject
	private SpeseDao speseDao;

	@Inject
	private UtentiDao utenteDao;

	@POST
	public Response addSpesa(Spese s) {
		//speseDao.persist(s); non funziona il cascade da rest se passo l'utente xche detached. ( la s la crep e va bene. Infatti per put / update si usa merge non persist.
		//Se passo l'id utente lo usa (update se esiste, crea se non esiste! con l'id passato ignorato e preso da sequence
		//(crea anche se null e genera lui da sequence))
		Utenti u = s.getChi();
		u = utenteDao.merge(u);
		s.setChi(u);
		speseDao.persist(s);
		
		return Response.status(Status.CREATED).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	/*per farlo andare in xml devi annotare com @XmlRootElement il dto/entity*/
	public Response getSpesa(@PathParam("id") Long id) {
		Spese s = speseDao.findById(id);
		return Response.ok().entity(s).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getSpese() {
		List<Spese> sl = speseDao.findAll();
		return Response.ok().entity(sl).build();
	}
	
}
