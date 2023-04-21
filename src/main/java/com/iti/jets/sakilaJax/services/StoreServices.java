package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.StoreDto;
import com.iti.jets.sakilaJax.mappers.impl.StoreMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Store;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class StoreServices {
    private static final BasicCRUDS<Store> repo = new BasicCRUDS<>(Store.class);
    private static final StoreMapperImpl mapper = new StoreMapperImpl();
    public static StoreDto findByid(Short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<StoreDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static StoreDto update(StoreDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getStoreId()))));
    }
    public static StoreDto insert(StoreDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Short id){
        return repo.deleteEntityById(id);
    }
}
