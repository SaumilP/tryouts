package org.saumil.resources;

import com.google.inject.Inject;
import org.saumil.infrastructure.MessageConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

/**
 * Created by saumil on 2014/04/25.
 */
@Path("/welcome")
public class WelcomeResource {
    private final MessageConfiguration config;

    @Inject
    public WelcomeResource(final MessageConfiguration config){
        this.config = config;
    }

    @GET
    public String greet(){
        return config.getWelcome();
    }

    @POST
    @Path("/{id}")
    public String parameterTestMethod(String body,
            @PathParam("id") long id,
            @QueryParam("foo") String foo,
            @HeaderParam("X-Auth-Token") String token,
            @Context HttpServletRequest request ){
        String response;

        response = "id = " + id + "\n";
        response += "body = " + body + "\n";
        response += "foo = " + foo + "\n";
        response += "token = " + token + "\n";
        response += "ip= " + request.getRemoteAddr() + "\n";

        return response;
    }
}
