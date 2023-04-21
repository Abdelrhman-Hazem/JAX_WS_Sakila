package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.FilmTextDto;
import com.iti.jets.sakilaJax.mappers.impl.FilmTextMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.FilmText;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class FilmTextServices {
    private static final BasicCRUDS<FilmText> repo = new BasicCRUDS<>(FilmText.class);
    private static final FilmTextMapperImpl mapper = new FilmTextMapperImpl();
    public static FilmTextDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<FilmTextDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static FilmTextDto update(FilmTextDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getFilmId()))));
    }
    public static FilmTextDto insert(FilmTextDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
