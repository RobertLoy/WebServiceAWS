package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

// PATH [ElasticBeanStalk]/test/ftoc
@Path("ftoc")
public class FtoC {
	@GET
	@Produces("application/json")
	public Response convertftoc() throws JSONException {
		JSONObject json = new JSONObject();
		double f = 98.4;
		double c;
		c  = (f-32) * 5/9;
		
		json.put("F", f);
		json.put("C",c);
		
		String result = "@Prdocues(\"application/json\") Output: \n\n F to C Conversion: \n\n " + json;
		return Response.status(200).entity(result).build();
	}
	
	// PATH [ElasticBeanStalk]/test/ftoc/32.0
	@Path("{f}")
	@GET
	@Produces("application/json")
	public Response convertftocinput(@PathParam("f") float f) throws JSONException {
		JSONObject json = new JSONObject();
		double c;
		c  = (f-32) * 5/9;
		
		json.put("F", f);
		json.put("C",c);
		
		String result = "@Prdocues(\"application/json\") Output: \n\n F to C Conversion: \n\n " + json;
		return Response.status(200).entity(result).build();
	}
	
}
