package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.mappers.impl.CountryMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Country;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class CountryServices {
    private static final BasicCRUDS<Country> repo = new BasicCRUDS<>(Country.class);
    private static final CountryMapperImpl mapper = new CountryMapperImpl();
    public static CountryDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<CountryDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static CountryDto update(CountryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getCountryId()))));
    }
    public static CountryDto insert(CountryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
