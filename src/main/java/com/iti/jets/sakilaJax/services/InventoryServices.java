package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.InventoryDto;
import com.iti.jets.sakilaJax.mappers.impl.InventoryMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Inventory;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryServices {
    private static final BasicCRUDS<Inventory> repo = new BasicCRUDS<>(Inventory.class);
    private static final InventoryMapperImpl mapper = new InventoryMapperImpl();
    public static InventoryDto findByid(Integer id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<InventoryDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static InventoryDto update(InventoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getInventoryId()))));
    }
    public static InventoryDto insert(InventoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Integer id){
        return repo.deleteEntityById(id);
    }
}
