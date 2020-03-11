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


import com.google.gson.Gson;
import generated.PallierType;
import generated.ProductType;
import javax.servlet.http.HttpServletRequest;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.PUT;
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
    
    @PUT
    @Path("product")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editProduct(String data){
        ProductType product = new Gson().fromJson(data, ProductType.class);
        return Response.ok(services.updateProduct(data, product)).build();
    }
            
    @PUT
    @Path("manager")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editManager(String data){
        PallierType manager = new Gson().fromJson(data, PallierType.class);
        return Response.ok(services.updateManager(data, manager)).build();
    }
    

}
