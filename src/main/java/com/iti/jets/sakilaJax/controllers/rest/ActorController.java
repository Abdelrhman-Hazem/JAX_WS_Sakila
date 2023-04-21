package com.iti.jets.sakilaJax.controllers.rest;

import com.iti.jets.sakilaJax.dtos.ActorDto;
import com.iti.jets.sakilaJax.services.ActorServices;
import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("actor")
public class ActorController {
    @GET
    @Produces({"application/xml", "application/json"})
    public Response getAllActors (@DefaultValue("1") @QueryParam("page")int page){
        GenericEntity allList = new GenericEntity<List<ActorDto>>(ActorServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getActorById (@PathParam("id")Short id){
        ActorDto dto = ActorServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    public Response addNewActor(@FormParam("firstName")String firstName, @FormParam("lastName") String lastName){
        if(firstName==null || lastName ==null) throw new WrongParametersException("please enter firstName and lastName");
        ActorDto dto = ActorServices.insert(new ActorDto(null,firstName,lastName,null));
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Produces({"application/xml", "application/json"})
    public Response UpdateActor(@FormParam("id")Short id,@FormParam("firstName")String firstName, @FormParam("lastName") String lastName){
        if(id==null) throw new WrongParametersException("please enter id");
        if(ActorServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        ActorDto dto = ActorServices.update(new ActorDto(id,firstName,lastName,null));
        return Response.ok().entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response deleteActorById (@PathParam("id")Short id){
        Boolean isDeleted = ActorServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
