package com.dave.enterprise.rest.jersey;
import java.util.Date;
import java.util.SimpleTimeZone;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.*;
 
@Path("/timeservice")
public class TimeService {
 
	  @GET
	  @Produces("application/json")
	  public Response getTime() throws JSONException, ParseException {
		  
		  
		JSONObject jsonObject = new JSONObject();
 
		jsonObject.put("Time Zone", "PHT"); 
		jsonObject.put("TimeOfDay", new Date().toString());
 
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	  }

}