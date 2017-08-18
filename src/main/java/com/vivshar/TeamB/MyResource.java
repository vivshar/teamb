package com.vivshar.TeamB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/1")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    //	System.out.println(daoImpl.fun());
        return "Hello, Heroku!";
    }
    @GET
    @Path("/2")
    @Produces(MediaType.TEXT_HTML)
    public String second() {
    	DAOImpl daoImpl = new DAOImpl();
    	return "<h1>"+daoImpl.fun()+"<h1>";
    }
    
    @GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}
    
}
