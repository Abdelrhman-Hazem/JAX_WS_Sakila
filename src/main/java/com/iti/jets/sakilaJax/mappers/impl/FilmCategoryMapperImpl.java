package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.CategoryDtoSimple;
import com.iti.jets.sakilaJax.dtos.FilmCategoryDto;
import com.iti.jets.sakilaJax.dtos.FilmCategoryIdDto;
import com.iti.jets.sakilaJax.dtos.FilmDtoSimple;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmCategoryMapper;
import com.iti.jets.sakilaJax.persistence.entities.Category;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategory;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategoryId;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:48+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class FilmCategoryMapperImpl implements FilmCategoryMapper {

    @Override
    public FilmCategory toEntity(FilmCategoryDto filmCategoryDto) {
        if ( filmCategoryDto == null ) {
            return null;
        }

        FilmCategory filmCategory = new FilmCategory();

        filmCategory.setId( filmCategoryIdDtoToFilmCategoryId( filmCategoryDto.getId() ) );
        filmCategory.setFilm( filmDtoSimpleToFilm( filmCategoryDto.getFilm() ) );
        filmCategory.setCategory( categoryDtoSimpleToCategory( filmCategoryDto.getCategory() ) );
        filmCategory.setLastUpdate( filmCategoryDto.getLastUpdate() );

        return filmCategory;
    }

    @Override
    public FilmCategoryDto toDto(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return null;
        }

        FilmCategoryIdDto id = null;
        FilmDtoSimple film = null;
        CategoryDtoSimple category = null;
        Timestamp lastUpdate = null;

        id = filmCategoryIdToFilmCategoryIdDto( filmCategory.getId() );
        film = filmToFilmDtoSimple( filmCategory.getFilm() );
        category = categoryToCategoryDtoSimple( filmCategory.getCategory() );
        lastUpdate = filmCategory.getLastUpdate();

        FilmCategoryDto filmCategoryDto = new FilmCategoryDto( id, film, category, lastUpdate );

        return filmCategoryDto;
    }

    @Override
    public FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, FilmCategory filmCategory) {
        if ( filmCategoryDto == null ) {
            return filmCategory;
        }

        if ( filmCategoryDto.getId() != null ) {
            if ( filmCategory.getId() == null ) {
                filmCategory.setId( new FilmCategoryId() );
            }
            filmCategoryIdDtoToFilmCategoryId1( filmCategoryDto.getId(), filmCategory.getId() );
        }
        if ( filmCategoryDto.getFilm() != null ) {
            if ( filmCategory.getFilm() == null ) {
                filmCategory.setFilm( new Film() );
            }
            filmDtoSimpleToFilm1( filmCategoryDto.getFilm(), filmCategory.getFilm() );
        }
        if ( filmCategoryDto.getCategory() != null ) {
            if ( filmCategory.getCategory() == null ) {
                filmCategory.setCategory( new Category() );
            }
            categoryDtoSimpleToCategory1( filmCategoryDto.getCategory(), filmCategory.getCategory() );
        }
        if ( filmCategoryDto.getLastUpdate() != null ) {
            filmCategory.setLastUpdate( filmCategoryDto.getLastUpdate() );
        }

        return filmCategory;
    }

    protected FilmCategoryId filmCategoryIdDtoToFilmCategoryId(FilmCategoryIdDto filmCategoryIdDto) {
        if ( filmCategoryIdDto == null ) {
            return null;
        }

        FilmCategoryId filmCategoryId = new FilmCategoryId();

        filmCategoryId.setCategoryId( filmCategoryIdDto.getCategoryId() );
        filmCategoryId.setFilmId( filmCategoryIdDto.getFilmId() );

        return filmCategoryId;
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

    protected Category categoryDtoSimpleToCategory(CategoryDtoSimple categoryDtoSimple) {
        if ( categoryDtoSimple == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDtoSimple.getCategoryId() );
        category.setName( categoryDtoSimple.getName() );

        return category;
    }

    protected FilmCategoryIdDto filmCategoryIdToFilmCategoryIdDto(FilmCategoryId filmCategoryId) {
        if ( filmCategoryId == null ) {
            return null;
        }

        short categoryId = 0;
        short filmId = 0;

        categoryId = filmCategoryId.getCategoryId();
        filmId = filmCategoryId.getFilmId();

        FilmCategoryIdDto filmCategoryIdDto = new FilmCategoryIdDto( categoryId, filmId );

        return filmCategoryIdDto;
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

    protected CategoryDtoSimple categoryToCategoryDtoSimple(Category category) {
        if ( category == null ) {
            return null;
        }

        Short categoryId = null;
        String name = null;

        categoryId = category.getCategoryId();
        name = category.getName();

        CategoryDtoSimple categoryDtoSimple = new CategoryDtoSimple( categoryId, name );

        return categoryDtoSimple;
    }

    protected void filmCategoryIdDtoToFilmCategoryId1(FilmCategoryIdDto filmCategoryIdDto, FilmCategoryId mappingTarget) {
        if ( filmCategoryIdDto == null ) {
            return;
        }

        mappingTarget.setCategoryId( filmCategoryIdDto.getCategoryId() );
        mappingTarget.setFilmId( filmCategoryIdDto.getFilmId() );
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

    protected void categoryDtoSimpleToCategory1(CategoryDtoSimple categoryDtoSimple, Category mappingTarget) {
        if ( categoryDtoSimple == null ) {
            return;
        }

        if ( categoryDtoSimple.getCategoryId() != null ) {
            mappingTarget.setCategoryId( categoryDtoSimple.getCategoryId() );
        }
        if ( categoryDtoSimple.getName() != null ) {
            mappingTarget.setName( categoryDtoSimple.getName() );
        }
    }
}
