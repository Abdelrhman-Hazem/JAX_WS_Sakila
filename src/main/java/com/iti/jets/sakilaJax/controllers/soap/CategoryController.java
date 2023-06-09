package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.CategoryDto;
import com.iti.jets.sakilaJax.services.CategoryServices;
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
public class CategoryController {

    public CategoryDto[] getAllCategorys (int page){
        return CategoryServices.findAllPaged(page*100-100,page*100).toArray(CategoryDto[]::new);
    }

    public CategoryDto getCategoryById (Short id){
        CategoryDto dto = CategoryServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public CategoryDto addNewCategory(String name){
        if(name==null) throw new WrongParametersException("please enter name");
        CategoryDto dto = CategoryServices.insert(new CategoryDto(null,name, Timestamp.valueOf(LocalDateTime.now()),null));
        return dto;
    }

    public CategoryDto updateCategory(Short id, String name){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CategoryServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CategoryDto dto = CategoryServices.update(new CategoryDto(id,name,Timestamp.valueOf(LocalDateTime.now()),null));
        return dto;
    }

    public Boolean deleteCategoryById (Short id){
        Boolean isDeleted = CategoryServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
