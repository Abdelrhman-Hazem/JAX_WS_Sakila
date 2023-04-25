package com.iti.jets.sakilaJax.controllers.rest;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.services.CityServices;
import com.iti.jets.sakilaJax.services.CountryServices;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Path("city")
public class CityController {
    @GET
    @Produces({"application/xml", "application/json"})
    public Response getAllCitys (@DefaultValue("1") @QueryParam("page")int page){
        GenericEntity allList = new GenericEntity<List<CityDto>>(CityServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response getCityById (@PathParam("id")Short id){
        CityDto dto = CityServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    @POST
    @Produces({"application/xml", "application/json"})
    public Response addNewCity(@FormParam("city")String city, @FormParam("countryId")Short countryId){
        if(city==null || countryId==null) throw new WrongParametersException("please enter country");
        CountryDto countryDto = CountryServices.findByid(countryId);

        if(countryDto==null) throw new NoSuchEntryException("No Such Country");

        CityDto dto = CityServices.insert(new CityDto(null,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    @PUT
    @Produces({"application/xml", "application/json"})
    public Response updateCity(@FormParam("id")Short id,@FormParam("city")String city, @FormParam("countryId")Short countryId){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CityServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CountryDto countryDto = CountryServices.findByid(countryId);

        if(countryDto==null) throw new NoSuchEntryException("No Such Country");

        CityDto dto = CityServices.update(new CityDto(id,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    @DELETE
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Response deleteCityById (@PathParam("id")Short id){
        Boolean isDeleted = CityServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
