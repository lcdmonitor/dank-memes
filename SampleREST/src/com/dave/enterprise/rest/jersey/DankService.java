package com.dave.enterprise.rest.jersey;
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
 
@Path("/dankservice")
public class DankService {
 
	  @GET
	  @Produces("application/json")
	  public Response dank() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
 
		jsonObject.put("Title", "Dank Memes Here!"); 
		jsonObject.put("Link","http://reddit.com/r/dankmemes");
 
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	  }

}