package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.ActorDtoSimple;
import com.iti.jets.sakilaJax.dtos.FilmActorDto;
import com.iti.jets.sakilaJax.dtos.FilmActorIdDto;
import com.iti.jets.sakilaJax.dtos.FilmDtoSimple;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmActorMapper;
import com.iti.jets.sakilaJax.persistence.entities.Actor;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.entities.FilmActor;
import com.iti.jets.sakilaJax.persistence.entities.FilmActorId;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class FilmActorMapperImpl implements FilmActorMapper {

    @Override
    public FilmActor toEntity(FilmActorDto filmActorDto) {
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

    @Override
    public FilmActorDto toDto(FilmActor filmActor) {
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

    @Override
    public FilmActor partialUpdate(FilmActorDto filmActorDto, FilmActor filmActor) {
        if ( filmActorDto == null ) {
            return filmActor;
        }

        if ( filmActorDto.getId() != null ) {
            if ( filmActor.getId() == null ) {
                filmActor.setId( new FilmActorId() );
            }
            filmActorIdDtoToFilmActorId1( filmActorDto.getId(), filmActor.getId() );
        }
        if ( filmActorDto.getFilm() != null ) {
            if ( filmActor.getFilm() == null ) {
                filmActor.setFilm( new Film() );
            }
            filmDtoSimpleToFilm1( filmActorDto.getFilm(), filmActor.getFilm() );
        }
        if ( filmActorDto.getActor() != null ) {
            if ( filmActor.getActor() == null ) {
                filmActor.setActor( new Actor() );
            }
            actorDtoSimpleToActor1( filmActorDto.getActor(), filmActor.getActor() );
        }
        if ( filmActorDto.getLastUpdate() != null ) {
            filmActor.setLastUpdate( filmActorDto.getLastUpdate() );
        }

        return filmActor;
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

        return actor;
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

    protected void filmActorIdDtoToFilmActorId1(FilmActorIdDto filmActorIdDto, FilmActorId mappingTarget) {
        if ( filmActorIdDto == null ) {
            return;
        }

        mappingTarget.setActorId( filmActorIdDto.getActorId() );
        mappingTarget.setFilmId( filmActorIdDto.getFilmId() );
    }

    protected void filmDtoSimpleToFilm1(FilmDtoSimple filmDtoSimple, Film mappingTarget) {
        if ( filmDtoSimple == null ) {
            return;
        }

        if ( filmDtoSimple.getFilmId() != null ) {
            mappingTarget.setFilmId( filmDtoSimple.getFilmId() );
        }
        if ( filmDtoSimple.getTitle() != null ) {
            mappingTarget.setTitle( filmDtoSimple.getTitle() );
        }
    }

    protected void actorDtoSimpleToActor1(ActorDtoSimple actorDtoSimple, Actor mappingTarget) {
        if ( actorDtoSimple == null ) {
            return;
        }

        if ( actorDtoSimple.getActorId() != null ) {
            mappingTarget.setActorId( actorDtoSimple.getActorId() );
        }
        if ( actorDtoSimple.getFirstName() != null ) {
            mappingTarget.setFirstName( actorDtoSimple.getFirstName() );
        }
        if ( actorDtoSimple.getLastName() != null ) {
            mappingTarget.setLastName( actorDtoSimple.getLastName() );
        }
    }
}
