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
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED ,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CategoryController {

    public Response getAllCategorys (int page){
        GenericEntity allList = new GenericEntity<List<CategoryDto>>(CategoryServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public Response getCategoryById (Short id){
        CategoryDto dto = CategoryServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    public Response addNewCategory(String name){
        if(name==null) throw new WrongParametersException("please enter name");
        CategoryDto dto = CategoryServices.insert(new CategoryDto(null,name, Timestamp.valueOf(LocalDateTime.now()),null));
        return Response.ok().entity(dto).build();
    }

    public Response UpdateCategory(Short id, String name){
        if(id==null) throw new WrongParametersException("please enter id");
        if(CategoryServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CategoryDto dto = CategoryServices.update(new CategoryDto(id,name,Timestamp.valueOf(LocalDateTime.now()),null));
        return Response.ok().entity(dto).build();
    }

    public Response deleteCategoryById (Short id){
        Boolean isDeleted = CategoryServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
