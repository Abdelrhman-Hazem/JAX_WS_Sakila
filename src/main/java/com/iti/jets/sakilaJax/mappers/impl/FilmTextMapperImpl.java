package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.persistence.entities.FilmText;
import com.iti.jets.sakilaJax.dtos.FilmTextDto;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmTextMapper;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:48+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class FilmTextMapperImpl implements FilmTextMapper {

    @Override
    public FilmText toEntity(FilmTextDto filmTextDto) {
        if ( filmTextDto == null ) {
            return null;
        }

        FilmText filmText = new FilmText();

        filmText.setFilmId( filmTextDto.getFilmId() );
        filmText.setTitle( filmTextDto.getTitle() );
        filmText.setDescription( filmTextDto.getDescription() );

        return filmText;
    }

    @Override
    public FilmTextDto toDto(FilmText filmText) {
        if ( filmText == null ) {
            return null;
        }

        short filmId = 0;
        String title = null;
        String description = null;

        filmId = filmText.getFilmId();
        title = filmText.getTitle();
        description = filmText.getDescription();

        FilmTextDto filmTextDto = new FilmTextDto( filmId, title, description );

        return filmTextDto;
    }

    @Override
    public FilmText partialUpdate(FilmTextDto filmTextDto, FilmText filmText) {
        if ( filmTextDto == null ) {
            return filmText;
        }

        filmText.setFilmId( filmTextDto.getFilmId() );
        if ( filmTextDto.getTitle() != null ) {
            filmText.setTitle( filmTextDto.getTitle() );
        }
        if ( filmTextDto.getDescription() != null ) {
            filmText.setDescription( filmTextDto.getDescription() );
        }

        return filmText;
    }
}
