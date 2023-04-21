package com.iti.jets.sakilaJax.controllers.soap;

import com.iti.jets.sakilaJax.controllers.exceptions.DeleteFailedException;
import com.iti.jets.sakilaJax.controllers.exceptions.NoSuchEntryException;
import com.iti.jets.sakilaJax.controllers.exceptions.WrongParametersException;
import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.CityDtoSimple;
import com.iti.jets.sakilaJax.services.AddressServices;
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
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.ENCODED ,parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class AddressController {

    public Response getAllAddresss (int page){
        GenericEntity allList = new GenericEntity<List<AddressDto>>(AddressServices.findAllPaged(page*100-100,page*100)){};
        return Response.ok(allList).build();
    }

    public Response getAddressById (Short id){
        AddressDto dto = AddressServices.findByid(id);
        if(dto==null)throw new NoSuchEntryException("No such Entry Found");
        return Response.ok().entity(dto).build();
    }

    public Response addNewAddress(Short cityId, String address,
                                  String address2, String district,
                                  String postalCode, String phone,
                                  String location){
        if(cityId==null || address ==null || district==null ||
                postalCode==null || phone==null || location==null) throw new WrongParametersException("please enter firstName and lastName");
        CityDtoSimple cityDto = new CityDtoSimple(cityId,null);
        byte[] locationBytes = Base64.getDecoder().decode(location);
        AddressDto dto = AddressServices.insert(new AddressDto(null,cityDto,address,address2,district,postalCode,phone,locationBytes, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    public Response UpdateAddress(Short id,Short cityId, String address,
                                  String address2, String district,
                                  String postalCode, String phone,
                                  String location){
        if(id==null) throw new WrongParametersException("please enter id");
        if(AddressServices.findByid(id)==null) throw new NoSuchEntryException("No such Entry Found");
        CityDtoSimple cityDto = new CityDtoSimple(cityId,null);
        byte[] locationBytes = Base64.getDecoder().decode(location);
        AddressDto dto = AddressServices.update(new AddressDto(id,cityDto,address,address2,district,postalCode,phone,locationBytes, Timestamp.valueOf(LocalDateTime.now())));
        return Response.ok().entity(dto).build();
    }

    public Response deleteAddressById (Short id){
        Boolean isDeleted = AddressServices.deleteById(id);
        if(isDeleted==false)throw new DeleteFailedException("Unable to delete\n please check if id exists and delete dependents first");
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
