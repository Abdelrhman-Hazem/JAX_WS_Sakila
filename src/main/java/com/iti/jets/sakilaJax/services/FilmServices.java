package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.FilmDto;
import com.iti.jets.sakilaJax.mappers.impl.FilmMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class FilmServices {
    private static final BasicCRUDS<Film> repo = new BasicCRUDS<>(Film.class);
    private static final FilmMapperImpl mapper = new FilmMapperImpl();
    public static FilmDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<FilmDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static FilmDto update(FilmDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getFilmId()))));
    }
    public static FilmDto insert(FilmDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
