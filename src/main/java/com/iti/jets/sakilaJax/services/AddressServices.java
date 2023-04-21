package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.mappers.impl.AddressMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Address;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class AddressServices {
    private static final BasicCRUDS<Address> repo = new BasicCRUDS<>(Address.class);
    private static final AddressMapperImpl mapper = new AddressMapperImpl();
    public static AddressDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<AddressDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static AddressDto update(AddressDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getAddressId()))));
    }
    public static AddressDto insert(AddressDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
