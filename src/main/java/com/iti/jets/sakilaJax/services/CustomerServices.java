package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.CustomerDto;
import com.iti.jets.sakilaJax.mappers.impl.CustomerMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Customer;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServices {
    private static final BasicCRUDS<Customer> repo = new BasicCRUDS<>(Customer.class);
    private static final CustomerMapperImpl mapper = new CustomerMapperImpl();
    public static CustomerDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<CustomerDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static CustomerDto update(CustomerDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getCustomerId()))));
    }
    public static CustomerDto insert(CustomerDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
