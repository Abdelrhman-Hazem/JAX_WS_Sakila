package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.CategoryDto;
import com.iti.jets.sakilaJax.persistence.entities.Category;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);

    @AfterMapping
    default void linkFilmCategories(@MappingTarget Category category) {
        if(category.getFilmCategories()!=null)
            category.getFilmCategories().forEach(filmCategory -> filmCategory.setCategory(category));
    }
}