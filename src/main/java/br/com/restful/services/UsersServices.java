package br.com.restful.services;

import jakarta.ws.rs.*;

import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsersServices {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello users";
    }

}
