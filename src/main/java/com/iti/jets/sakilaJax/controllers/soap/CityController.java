package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.services.CityServices;
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
@SOAPBinding(style = SOAPBinding.Style.RPC,
            use = SOAPBinding.Use.ENCODED ,
            parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CityController {

    public CityDto[] getAllCitys (int page){
        return CityServices.findAllPaged(page*100-100,page*100).toArray(CityDto[]::new);
    }

    public CityDto getCityById (Short id){
        CityDto dto = CityServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public CityDto addNewCity(String city, Short countryId){
        if(city==null || countryId==null) throw new WrongParametersException("please enter country");
        CountryDto countryDto = CountryServices.findByid(countryId);

        if(countryDto==null) throw new NoSuchEntryException("No Such Country");

        CityDto dto = CityServices.insert(new CityDto(null,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return dto;
    }

    public CityDto updateCity(Short id, String city, Short countryId){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CityServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CountryDto countryDto = CountryServices.findByid(countryId);

        if(countryDto==null) throw new NoSuchEntryException("No Such Country");

        CityDto dto = CityServices.update(new CityDto(id,countryDto,city, Timestamp.valueOf(LocalDateTime.now())));
        return dto;
    }

    public Boolean deleteCityById (Short id){
        Boolean isDeleted = CityServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
