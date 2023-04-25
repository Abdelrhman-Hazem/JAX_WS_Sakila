package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.LanguageDto;
import com.iti.jets.sakilaJax.services.LanguageServices;
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
public class LanguageController {

    public LanguageDto[] getAllLanguages (int page){
        return LanguageServices.findAllPaged(page*100-100,page*100).toArray(LanguageDto[]::new);
    }

    public LanguageDto getLanguageById (Short id){
        LanguageDto dto = LanguageServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public LanguageDto addNewLanguage(String language){
        if(language==null) throw new WrongParametersException("please enter language");
        LanguageDto dto = LanguageServices.insert(new LanguageDto(null,language, Timestamp.valueOf(LocalDateTime.now()),null,null));
        return dto;
    }

    public LanguageDto updateLanguage(Short id, String language){
        if(id==null) throw new WrongParametersException("please enter id");
        if(LanguageServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        LanguageDto dto = LanguageServices.update(new LanguageDto(id,language,Timestamp.valueOf(LocalDateTime.now()),null,null));
        return dto;
    }

    public Boolean deleteLanguageById (Short id){
        Boolean isDeleted = LanguageServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
