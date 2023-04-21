package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.ActorDto;
import com.iti.jets.sakilaJax.services.ActorServices;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED ,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ActorController {

    public Response getAllActors (int page){
        GenericEntity allList = new GenericEntity<List<ActorDto>>(ActorServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public ActorDto getActorById (Short id){
        ActorDto dto = ActorServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
//        return Response.ok().entity(dto).build();
    }


    public Response addNewActor(String firstName, String lastName){
        if(firstName==null || lastName ==null) throw new WrongParametersException("please enter firstName and lastName");
        ActorDto dto = ActorServices.insert(new ActorDto(null,firstName,lastName,null));
        return Response.ok().entity(dto).build();
    }


    public Response UpdateActor(Short id,String firstName,  String lastName){
        if(id==null) throw new WrongParametersException("please enter id");
        if(ActorServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        ActorDto dto = ActorServices.update(new ActorDto(id,firstName,lastName,null));
        return Response.ok().entity(dto).build();
    }


    public Response deleteActorById (Short id){
        Boolean isDeleted = ActorServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
