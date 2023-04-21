package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.FilmCategoryDto;
import com.iti.jets.sakilaJax.dtos.FilmCategoryIdDto;
import com.iti.jets.sakilaJax.mappers.impl.FilmCategoryMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategory;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategoryId;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class FilmCategoryServices {
    private static final BasicCRUDS<FilmCategory> repo = new BasicCRUDS<>(FilmCategory.class);
    private static final FilmCategoryMapperImpl mapper = new FilmCategoryMapperImpl();
    public static FilmCategoryDto findByid(FilmCategoryIdDto idDto){
        FilmCategoryId id = new FilmCategoryId(idDto.getCategoryId(), idDto.getFilmId());
        return mapper.toDto(repo.findById(id));
    }
    public static List<FilmCategoryDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static FilmCategoryDto update(FilmCategoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getId()))));
    }
    public static FilmCategoryDto insert(FilmCategoryDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(FilmCategoryIdDto idDto){
        FilmCategoryId id = new FilmCategoryId(idDto.getCategoryId(), idDto.getFilmId());
        return repo.deleteEntityById(id);
    }
}
