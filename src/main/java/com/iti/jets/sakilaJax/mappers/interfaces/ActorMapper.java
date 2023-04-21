package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.dtos.ActorDto;
import com.iti.jets.sakilaJax.persistence.entities.Actor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI)
public interface ActorMapper {
    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);

    @AfterMapping
    default void linkFilmActors(@MappingTarget Actor actor) {
        if(actor.getFilmActors()!=null)
            actor.getFilmActors().forEach(filmActor -> filmActor.setActor(actor));
    }
}