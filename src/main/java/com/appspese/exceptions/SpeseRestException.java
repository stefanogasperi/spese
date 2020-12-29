package com.appspese.exceptions;

import java.io.Serializable;

import javax.ws.rs.core.Response;

public class SpeseRestException extends RuntimeException implements Serializable
{

	private static final long serialVersionUID = 1298089305729760452L;

	private final Response.Status status;
	
    public Response.Status getStatus() {
		return status;
	}

	public SpeseRestException(Response.Status status) {
        this.status = status;
    }
        
    public SpeseRestException(String msg, Response.Status status)   {
        super(msg);
        this.status = status;
    }
    
    public SpeseRestException(String msg, Exception e, Response.Status status)  {
        super(msg, e);
        this.status = status;
    }
	
}
