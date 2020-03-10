/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isis.adventureISISServer.adventureISISServer;

/**
 *
 * @author flaviebilhac
 */


import javax.servlet.http.HttpServletRequest;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("generic")

public class WebServices {

    Services services;

    public WebServices() {
        services = new Services();
    }

    @GET
    @Path("world")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getXml(@Context HttpServletRequest request) {
    String username = request.getHeader("X-user");
    return Response.ok(services.getWorld(username)).build();
    }

}
