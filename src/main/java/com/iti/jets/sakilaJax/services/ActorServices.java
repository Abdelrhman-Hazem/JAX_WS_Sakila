package com.iti.jets.sakilaJax.services;

import com.iti.jets.sakilaJax.dtos.ActorDto;
import com.iti.jets.sakilaJax.mappers.impl.ActorMapperImpl;
import com.iti.jets.sakilaJax.persistence.entities.Actor;
import com.iti.jets.sakilaJax.persistence.repositories.BasicCRUDS;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ActorServices {
    private static final BasicCRUDS<Actor> repo = new BasicCRUDS<>(Actor.class);
    private static final ActorMapperImpl mapper = new ActorMapperImpl();
    public static ActorDto findByid(short id){
        return mapper.toDto(repo.findById(id));
    }
    public static List<ActorDto> findAllPaged(int offset, int limit){
        return repo.findAllPaged(offset,limit)
                .stream().map(a->mapper.toDto(a))
                .collect(Collectors.toList());
    }
    public static ActorDto update(ActorDto dto){
        Actor entity = mapper.partialUpdate(dto,repo.findById(dto.getActorId()));
        entity.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
        return mapper.toDto(repo.updateOrInsertEntityById(entity));
    }
    public static ActorDto insert(ActorDto dto){
        Actor entity = mapper.toEntity(dto);
        entity.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
        return mapper.toDto(repo.updateOrInsertEntityById(entity));
    }
    public static Boolean deleteById(short id){
        return repo.deleteEntityById(id);
    }
}
