package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.StaffDto;
import com.iti.jets.sakilaJax.mappers.impl.StaffMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Staff;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class StaffServices {
    private static final BasicCRUDS<Staff> repo = new BasicCRUDS<>(Staff.class);
    private static final StaffMapperImpl mapper = new StaffMapperImpl();
    public static StaffDto findByid(Short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<StaffDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static StaffDto update(StaffDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getStaffId()))));
    }
    public static StaffDto insert(StaffDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Short id){
        return repo.deleteEntityById(id);
    }
}
