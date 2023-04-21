package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.RentalDto;
import com.iti.jets.sakilaJax.mappers.impl.RentalMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Rental;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class RentalServices {
    private static final BasicCRUDS<Rental> repo = new BasicCRUDS<>(Rental.class);
    private static final RentalMapperImpl mapper = new RentalMapperImpl();
    public static RentalDto findByid(Integer id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<RentalDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static RentalDto update(RentalDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getRentalId()))));
    }
    public static RentalDto insert(RentalDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Integer id){
        return repo.deleteEntityById(id);
    }
}
