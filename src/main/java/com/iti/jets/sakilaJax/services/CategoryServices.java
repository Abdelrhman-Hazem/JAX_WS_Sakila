package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.CategoryDto;
import com.iti.jets.sakilaJax.mappers.impl.CategoryMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Category;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServices {
    private static final BasicCRUDS<Category> repo = new BasicCRUDS<>(Category.class);
    private static final CategoryMapperImpl mapper = new CategoryMapperImpl();
    public static CategoryDto findByid(Short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<CategoryDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static CategoryDto update(CategoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getCategoryId()))));
    }

    public static CategoryDto insert(CategoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(Short id){
        return repo.deleteEntityById(id);
    }
}
