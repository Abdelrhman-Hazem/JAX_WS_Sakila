package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.mappers.impl.CityMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.City;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class CityServices {
    private static final BasicCRUDS<City> repo = new BasicCRUDS<>(City.class);
    private static final CityMapperImpl mapper = new CityMapperImpl();
    public static CityDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<CityDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static CityDto update(CityDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getCityId()))));
    }
    public static CityDto insert(CityDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
