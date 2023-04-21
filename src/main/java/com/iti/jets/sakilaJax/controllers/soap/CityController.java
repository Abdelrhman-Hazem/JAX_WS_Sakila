package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.services.CityServices;
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
public class CityController {

    public Response getAllCitys (int page){
        GenericEntity allList = new GenericEntity<List<CityDto>>(CityServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public Response getCityById (Short id){
        CityDto dto = CityServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    public Response addNewCity(String city, Short countryId){
        if(city==null || countryId==null) throw new WrongParametersException("please enter country");
        CountryDto countryDto = new CountryDto(countryId,null,null,null);
        CityDto dto = CityServices.insert(new CityDto(null,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    public Response UpdateCity(Short id, String city, Short countryId){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CityServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CountryDto countryDto = new CountryDto(countryId,null,null,null);
        CityDto dto = CityServices.update(new CityDto(id,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    public Response deleteCityById (Short id){
        Boolean isDeleted = CityServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
