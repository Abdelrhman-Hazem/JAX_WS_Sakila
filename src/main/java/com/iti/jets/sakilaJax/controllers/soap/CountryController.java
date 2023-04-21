package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.services.CountryServices;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED ,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CountryController {

    public Response getAllCountrys (int page){
        GenericEntity allList = new GenericEntity<List<CountryDto>>(CountryServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public Response getCountryById (Short id){
        CountryDto dto = CountryServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    public Response addNewCountry(String country){
        if(country==null) throw new WrongParametersException("please enter country");
        CountryDto dto = CountryServices.insert(new CountryDto(null,country, Timestamp.valueOf(LocalDateTime.now()),null));
        return Response.ok().entity(dto).build();
    }

    public Response UpdateCountry(Short id, String country){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CountryServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CountryDto dto = CountryServices.update(new CountryDto(id,country,Timestamp.valueOf(LocalDateTime.now()),null));
        return Response.ok().entity(dto).build();
    }

    public Response deleteCountryById (Short id){
        Boolean isDeleted = CountryServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
