package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.StaffDto;
import com.iti.jets.sakilaJax.dtos.StoreDtoSimple;
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
import java.util.Base64;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC,
            use = SOAPBinding.Use.ENCODED ,
            parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class StaffController {

    public StaffDto[] getAllStaffs (int page){
        return StaffServices.findAllPaged(page*100-100,page*100).toArray(StaffDto[]::new);
    }

    public StaffDto getStaffById (Short id){
        StaffDto dto = StaffServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return dto;
    }

    public StaffDto addNewStaff(Boolean active, Short storeId,
                                Short addressId, String firstName,
                                String lastName, String picture,
                                String email, String username,
                                String password){
        if(active==null || storeId ==null || addressId==null ||
                firstName==null || lastName==null || username==null) throw new WrongParametersException("please enter firstName and lastName");

        if(StoreServices.findByid(storeId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StoreDtoSimple storeDto = new StoreDtoSimple(storeId, null);
        byte[] pictureBytes = Base64.getDecoder().decode(picture);
        StaffDto dto = StaffServices.insert(new StaffDto(active,null,storeDto,addressDto,firstName,lastName,pictureBytes, email,username,password, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public StaffDto updateStaff(Short id, Boolean active, Short storeId,
                                Short addressId, String firstName,
                                String lastName, String picture,
                                String email, String username,
                                String password){
        if(id==null) throw new WrongParametersException("please enter id");
        if(StaffServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");

        if(StoreServices.findByid(storeId) == null) throw new NoSuchEntryException("No Such Store");
        AddressDto addressDto = AddressServices.findByid(addressId);
        if(addressDto ==null) throw new NoSuchEntryException("No Such Address");

        StoreDtoSimple storeDto = new StoreDtoSimple(storeId, null);
        byte[] pictureBytes = Base64.getDecoder().decode(picture);
        StaffDto dto = StaffServices.update(new StaffDto(active,id,storeDto,addressDto,firstName,lastName,pictureBytes, email,username,password, Timestamp.valueOf(LocalDateTime.now()),null,null,null));
        return dto;
    }

    public Boolean deleteStaffById (Short id){
        Boolean isDeleted = StaffServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return true;
    }
}
