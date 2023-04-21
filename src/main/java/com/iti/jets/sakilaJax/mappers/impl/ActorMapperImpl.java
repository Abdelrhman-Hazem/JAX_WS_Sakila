package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.mappers.interfaces.ActorMapper;
import com.iti.jets.sakilaJax.persistence.entities.Actor;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.entities.FilmActor;
import com.iti.jets.sakilaJax.persistence.entities.FilmActorId;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class ActorMapperImpl implements ActorMapper {

    @Override
    public Actor toEntity(ActorDto actorDto) {
        if ( actorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setActorId( actorDto.getActorId() );
        actor.setFirstName( actorDto.getFirstName() );
        actor.setLastName( actorDto.getLastName() );
        actor.setFilmActors( filmActorDtoSetToFilmActorSet( actorDto.getFilmActors() ) );

        linkFilmActors( actor );

        return actor;
    }

    @Override
    public ActorDto toDto(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        Set<FilmActorDto> filmActors = null;
        Short actorId = null;
        String firstName = null;
        String lastName = null;

        filmActors = filmActorSetToFilmActorDtoSet( actor.getFilmActors() );
        actorId = actor.getActorId();
        firstName = actor.getFirstName();
        lastName = actor.getLastName();

        ActorDto actorDto = new ActorDto( actorId, firstName, lastName, filmActors );

        return actorDto;
    }

    @Override
    public Actor partialUpdate(ActorDto actorDto, Actor actor) {
        if ( actorDto == null ) {
            return actor;
        }

        if ( actorDto.getActorId() != null ) {
            actor.setActorId( actorDto.getActorId() );
        }
        if ( actorDto.getFirstName() != null ) {
            actor.setFirstName( actorDto.getFirstName() );
        }
        if ( actorDto.getLastName() != null ) {
            actor.setLastName( actorDto.getLastName() );
        }
        if ( actor.getFilmActors() != null ) {
            Set<FilmActor> set = filmActorDtoSetToFilmActorSet( actorDto.getFilmActors() );
            if ( set != null ) {
                actor.getFilmActors().clear();
                actor.getFilmActors().addAll( set );
            }
        }
        else {
            Set<FilmActor> set = filmActorDtoSetToFilmActorSet( actorDto.getFilmActors() );
            if ( set != null ) {
                actor.setFilmActors( set );
            }
        }

        linkFilmActors( actor );

        return actor;
    }

    protected FilmActorId filmActorIdDtoToFilmActorId(FilmActorIdDto filmActorIdDto) {
        if ( filmActorIdDto == null ) {
            return null;
        }

        FilmActorId filmActorId = new FilmActorId();

        filmActorId.setActorId( filmActorIdDto.getActorId() );
        filmActorId.setFilmId( filmActorIdDto.getFilmId() );

        return filmActorId;
    }

    protected Film filmDtoSimpleToFilm(FilmDtoSimple filmDtoSimple) {
        if ( filmDtoSimple == null ) {
            return null;
        }

        Film film = new Film();

        film.setFilmId( filmDtoSimple.getFilmId() );
        film.setTitle( filmDtoSimple.getTitle() );

        return film;
    }

    protected Actor actorDtoSimpleToActor(ActorDtoSimple actorDtoSimple) {
        if ( actorDtoSimple == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setActorId( actorDtoSimple.getActorId() );
        actor.setFirstName( actorDtoSimple.getFirstName() );
        actor.setLastName( actorDtoSimple.getLastName() );

        linkFilmActors( actor );

        return actor;
    }

    protected FilmActor filmActorDtoToFilmActor(FilmActorDto filmActorDto) {
        if ( filmActorDto == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        filmActor.setId( filmActorIdDtoToFilmActorId( filmActorDto.getId() ) );
        filmActor.setFilm( filmDtoSimpleToFilm( filmActorDto.getFilm() ) );
        filmActor.setActor( actorDtoSimpleToActor( filmActorDto.getActor() ) );
        filmActor.setLastUpdate( filmActorDto.getLastUpdate() );

        return filmActor;
    }

    protected Set<FilmActor> filmActorDtoSetToFilmActorSet(Set<FilmActorDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActor> set1 = new LinkedHashSet<FilmActor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActorDto filmActorDto : set ) {
            set1.add( filmActorDtoToFilmActor( filmActorDto ) );
        }

        return set1;
    }

    protected FilmActorIdDto filmActorIdToFilmActorIdDto(FilmActorId filmActorId) {
        if ( filmActorId == null ) {
            return null;
        }

        short actorId = 0;
        short filmId = 0;

        actorId = filmActorId.getActorId();
        filmId = filmActorId.getFilmId();

        FilmActorIdDto filmActorIdDto = new FilmActorIdDto( actorId, filmId );

        return filmActorIdDto;
    }

    protected FilmDtoSimple filmToFilmDtoSimple(Film film) {
        if ( film == null ) {
            return null;
        }

        Short filmId = null;
        String title = null;

        filmId = film.getFilmId();
        title = film.getTitle();

        FilmDtoSimple filmDtoSimple = new FilmDtoSimple( filmId, title );

        return filmDtoSimple;
    }

    protected ActorDtoSimple actorToActorDtoSimple(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        Short actorId = null;
        String firstName = null;
        String lastName = null;

        actorId = actor.getActorId();
        firstName = actor.getFirstName();
        lastName = actor.getLastName();

        ActorDtoSimple actorDtoSimple = new ActorDtoSimple( actorId, firstName, lastName );

        return actorDtoSimple;
    }

    protected FilmActorDto filmActorToFilmActorDto(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }

        FilmActorIdDto id = null;
        FilmDtoSimple film = null;
        ActorDtoSimple actor = null;
        Timestamp lastUpdate = null;

        id = filmActorIdToFilmActorIdDto( filmActor.getId() );
        film = filmToFilmDtoSimple( filmActor.getFilm() );
        actor = actorToActorDtoSimple( filmActor.getActor() );
        lastUpdate = filmActor.getLastUpdate();

        FilmActorDto filmActorDto = new FilmActorDto( id, film, actor, lastUpdate );

        return filmActorDto;
    }

    protected Set<FilmActorDto> filmActorSetToFilmActorDtoSet(Set<FilmActor> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActorDto> set1 = new LinkedHashSet<FilmActorDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActor filmActor : set ) {
            set1.add( filmActorToFilmActorDto( filmActor ) );
        }

        return set1;
    }
}
