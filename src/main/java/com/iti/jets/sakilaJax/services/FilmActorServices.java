package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.FilmActorDto;
import com.iti.jets.sakilaJax.dtos.FilmActorIdDto;
import com.iti.jets.sakilaJax.mappers.impl.FilmActorMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.FilmActor;
import com.iti.jets.sakilaJax.persistence.entities.FilmActorId;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.util.List;
import java.util.stream.Collectors;

public class FilmActorServices {
    private static final BasicCRUDS<FilmActor> repo = new BasicCRUDS<>(FilmActor.class);
    private static final FilmActorMapperImpl mapper = new FilmActorMapperImpl();
    public static FilmActorDto findByid(FilmActorIdDto idDto){
        FilmActorId id = new FilmActorId(idDto.getActorId(), idDto.getFilmId());
        return mapper.toDto(repo.findById(id));
    }
    public static List<FilmActorDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static FilmActorDto update(FilmActorDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.partialUpdate(dto,repo.findById(dto.getId()))));
    }
    public static FilmActorDto insert(FilmActorDto dto){
        return mapper.toDto(repo.updateOrInsertEntityById(mapper.toEntity(dto)));
    }
    public static Boolean deleteById(FilmActorIdDto idDto){
        FilmActorId id = new FilmActorId(idDto.getActorId(), idDto.getFilmId());
        return repo.deleteEntityById(id);
    }
}
