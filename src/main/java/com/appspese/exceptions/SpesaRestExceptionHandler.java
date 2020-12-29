package com.appspese.exceptions;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.appspese.exceptions.SpeseRestException;

@Provider
public class SpesaRestExceptionHandler implements ExceptionMapper<SpeseRestException> {

	public SpesaRestExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(SpeseRestException exception) {
		return Response.status(exception.getStatus()).entity(exception.getMessage()).build();  
	}

}
