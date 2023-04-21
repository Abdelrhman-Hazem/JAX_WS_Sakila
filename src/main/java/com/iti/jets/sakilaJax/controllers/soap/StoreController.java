package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.StaffDtoSimple;
import com.iti.jets.sakilaJax.dtos.StoreDto;
import com.iti.jets.sakilaJax.services.StoreServices;
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
public class StoreController {

    public Response getAllStores (int page){
        GenericEntity allList = new GenericEntity<List<StoreDto>>(StoreServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public Response getStoreById (Short id){
        StoreDto dto = StoreServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    public Response addNewStore(Short managerId, Short addressId){
        if(managerId==null || addressId ==null) throw new WrongParametersException("please enter firstName and lastName");
        StaffDtoSimple manager = new StaffDtoSimple(true,managerId,null,null);
        AddressDto addressDto = new AddressDto(addressId,null,null,null,null,null,null,null,null);
        StoreDto dto = StoreServices.insert(new StoreDto(null,manager,addressDto, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return Response.ok().entity(dto).build();
    }

    public Response UpdateStore(Short id,Short managerId, Short addressId){
        if(id==null) throw new WrongParametersException("please enter id");
        if(StoreServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        StaffDtoSimple manager = new StaffDtoSimple(true,managerId,null,null);
        AddressDto addressDto = new AddressDto(addressId,null,null,null,null,null,null,null,null);
        StoreDto dto = StoreServices.update(new StoreDto(id,manager,addressDto, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return Response.ok().entity(dto).build();
    }

    public Response deleteStoreById (Short id){
        Boolean isDeleted = StoreServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
