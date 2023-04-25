package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.StaffDtoSimple;
import com.iti.jets.sakilaJax.dtos.StoreDto;
import com.iti.jets.sakilaJax.services.AddressServices;
import com.iti.jets.sakilaJax.services.StaffServices;
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
@SOAPBinding(style = SOAPBinding.Style.RPC,
            use = SOAPBinding.Use.ENCODED ,
            parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class StoreController {

    public StoreDto[] getAllStores (int page){
        return StoreServices.findAllPaged(page*100-100,page*100).toArray(StoreDto[]::new);
    }

    public StoreDto getStoreById (Short id){
        StoreDto dto = StoreServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public StoreDto addNewStore(Short managerId, Short addressId){
        if(managerId==null || addressId ==null) throw new WrongParametersException("please enter firstName and lastName");

        if(StaffServices.findByid(managerId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StaffDtoSimple manager = new StaffDtoSimple(true,managerId,null,null);
        StoreDto dto = StoreServices.insert(new StoreDto(null,manager,addressDto, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public StoreDto updateStore(Short id, Short managerId, Short addressId){
        if(id==null) throw new WrongParametersException("please enter id");
        if(StoreServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");

        if(StaffServices.findByid(managerId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StaffDtoSimple manager = new StaffDtoSimple(true,managerId,null,null);
        StoreDto dto = StoreServices.update(new StoreDto(id,manager,addressDto, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public Boolean deleteStoreById (Short id){
        Boolean isDeleted = StoreServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
