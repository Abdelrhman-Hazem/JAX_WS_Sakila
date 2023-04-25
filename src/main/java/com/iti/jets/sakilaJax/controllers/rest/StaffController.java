package com.iti.jets.sakilaJax.controllers.rest;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.services.AddressServices;
import com.iti.jets.sakilaJax.services.StaffServices;
import com.iti.jets.sakilaJax.services.StoreServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Path("staff")
public class StaffController {
    @GET
    @Produces({"application/xml", "application/json"})
    public Response getAllStaffs (@DefaultValue("1") @QueryParam("page")int page){
        GenericEntity allList = new GenericEntity<List<StaffDto>>(StaffServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getStaffById (@PathParam("id")Short id){
        StaffDto dto = StaffServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    public Response addNewStaff(@DefaultValue("true") @FormParam("active")Boolean active, @FormParam("storeId") Short storeId,
                                @FormParam("address") Short addressId, @FormParam("firstName") String firstName,
                                @FormParam("lastName") String lastName, @FormParam("picture") String picture,
                                @FormParam("email") String email, @FormParam("username") String username,
                                @FormParam("password") String password){
        if(active==null || storeId ==null || addressId==null ||
                firstName==null || lastName==null || username==null) throw new WrongParametersException("please enter firstName and lastName");

        if(StoreServices.findByid(storeId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StoreDtoSimple storeDto = new StoreDtoSimple(storeId, null);
        byte[] pictureBytes = Base64.getDecoder().decode(picture);
        StaffDto dto = StaffServices.insert(new StaffDto(active,null,storeDto,addressDto,firstName,lastName,pictureBytes, email,username,password, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Produces({"application/xml", "application/json"})
    public Response updateStaff(@FormParam("id") Short id, @FormParam("active")Boolean active, @FormParam("storeId") Short storeId,
                                @FormParam("address") Short addressId, @FormParam("firstName") String firstName,
                                @FormParam("lastName") String lastName, @FormParam("picture") String picture,
                                @FormParam("email") String email, @FormParam("username") String username,
                                @FormParam("password") String password){
        if(id==null) throw new WrongParametersException("please enter id");
        if(StaffServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");

        if(StoreServices.findByid(storeId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StoreDtoSimple storeDto = new StoreDtoSimple(storeId, null);
        byte[] pictureBytes = Base64.getDecoder().decode(picture);
        StaffDto dto = StaffServices.update(new StaffDto(active,id,storeDto,addressDto,firstName,lastName,pictureBytes, email,username,password, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return Response.ok().entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response deleteStaffById (@PathParam("id") Short id){
        Boolean isDeleted = StaffServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
