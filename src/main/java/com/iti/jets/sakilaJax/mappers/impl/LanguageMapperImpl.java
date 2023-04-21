package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.FilmDtoSimple;
import com.iti.jets.sakilaJax.dtos.LanguageDto;
import com.iti.jets.sakilaJax.mappers.interfaces.LanguageMapper;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.entities.Language;
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
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public Language toEntity(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setLanguageId( languageDto.getLanguageId() );
        language.setName( languageDto.getName() );
        language.setLastUpdate( languageDto.getLastUpdate() );
        language.setFilmsForLanguageId( filmDtoSimpleSetToFilmSet( languageDto.getFilmsForLanguageId() ) );
        language.setFilmsForOriginalLanguageId( filmDtoSimpleSetToFilmSet( languageDto.getFilmsForOriginalLanguageId() ) );

        return language;
    }

    @Override
    public LanguageDto toDto(Language language) {
        if ( language == null ) {
            return null;
        }

        Set<FilmDtoSimple> filmsForLanguageId = null;
        Set<FilmDtoSimple> filmsForOriginalLanguageId = null;
        Short languageId = null;
        String name = null;
        Timestamp lastUpdate = null;

        filmsForLanguageId = filmSetToFilmDtoSimpleSet( language.getFilmsForLanguageId() );
        filmsForOriginalLanguageId = filmSetToFilmDtoSimpleSet( language.getFilmsForOriginalLanguageId() );
        languageId = language.getLanguageId();
        name = language.getName();
        lastUpdate = language.getLastUpdate();

        LanguageDto languageDto = new LanguageDto( languageId, name, lastUpdate, filmsForLanguageId, filmsForOriginalLanguageId );

        return languageDto;
    }

    @Override
    public Language partialUpdate(LanguageDto languageDto, Language language) {
        if ( languageDto == null ) {
            return language;
        }

        if ( languageDto.getLanguageId() != null ) {
            language.setLanguageId( languageDto.getLanguageId() );
        }
        if ( languageDto.getName() != null ) {
            language.setName( languageDto.getName() );
        }
        if ( languageDto.getLastUpdate() != null ) {
            language.setLastUpdate( languageDto.getLastUpdate() );
        }
        if ( language.getFilmsForLanguageId() != null ) {
            Set<Film> set = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForLanguageId() );
            if ( set != null ) {
                language.getFilmsForLanguageId().clear();
                language.getFilmsForLanguageId().addAll( set );
            }
        }
        else {
            Set<Film> set = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForLanguageId() );
            if ( set != null ) {
                language.setFilmsForLanguageId( set );
            }
        }
        if ( language.getFilmsForOriginalLanguageId() != null ) {
            Set<Film> set1 = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForOriginalLanguageId() );
            if ( set1 != null ) {
                language.getFilmsForOriginalLanguageId().clear();
                language.getFilmsForOriginalLanguageId().addAll( set1 );
            }
        }
        else {
            Set<Film> set1 = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForOriginalLanguageId() );
            if ( set1 != null ) {
                language.setFilmsForOriginalLanguageId( set1 );
            }
        }

        return language;
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

    protected Set<Film> filmDtoSimpleSetToFilmSet(Set<FilmDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Film> set1 = new LinkedHashSet<Film>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmDtoSimple filmDtoSimple : set ) {
            set1.add( filmDtoSimpleToFilm( filmDtoSimple ) );
        }

        return set1;
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

    protected Set<FilmDtoSimple> filmSetToFilmDtoSimpleSet(Set<Film> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmDtoSimple> set1 = new LinkedHashSet<FilmDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Film film : set ) {
            set1.add( filmToFilmDtoSimple( film ) );
        }

        return set1;
    }
}
