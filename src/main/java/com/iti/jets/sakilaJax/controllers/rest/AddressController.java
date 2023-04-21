package com.iti.jets.sakilaJax.controllers.rest;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.dtos.CityDtoSimple;
import com.iti.jets.sakilaJax.services.AddressServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Path("address")
public class AddressController {
    @GET
    @Produces({"application/xml", "application/json"})
    public Response getAllAddresss (@DefaultValue("1") @QueryParam("page")int page){
        GenericEntity allList = new GenericEntity<List<AddressDto>>(AddressServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getAddressById (@PathParam("id")Short id){
        AddressDto dto = AddressServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    public Response addNewAddress(@FormParam("cityId")Short cityId, @FormParam("address") String address,
                                  @FormParam("address2") String address2, @FormParam("district") String district,
                                  @FormParam("postalCode") String postalCode, @FormParam("phone") String phone,
                                  @FormParam("location") String location){
        if(cityId==null || address ==null || district==null ||
                postalCode==null || phone==null || location==null) throw new WrongParametersException("please enter firstName and lastName");
        CityDtoSimple cityDto = new CityDtoSimple(cityId,null);
        byte[] locationBytes = Base64.getDecoder().decode(location);
        AddressDto dto = AddressServices.insert(new AddressDto(null,cityDto,address,address2,district,postalCode,phone,locationBytes, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Produces({"application/xml", "application/json"})
    public Response UpdateAddress(@FormParam("addressId")Short id, @FormParam("cityId")Short cityId, @FormParam("address") String address,
                                  @FormParam("address2") String address2, @FormParam("district") String district,
                                  @FormParam("postalCode") String postalCode, @FormParam("phone") String phone,
                                  @FormParam("location") String location){
        if(id==null) throw new WrongParametersException("please enter id");
        if(AddressServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CityDtoSimple cityDto = new CityDtoSimple(cityId,null);
        byte[] locationBytes = Base64.getDecoder().decode(location);
        AddressDto dto = AddressServices.update(new AddressDto(id,cityDto,address,address2,district,postalCode,phone,locationBytes, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response deleteAddressById (@PathParam("id")Short id){
        Boolean isDeleted = AddressServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
