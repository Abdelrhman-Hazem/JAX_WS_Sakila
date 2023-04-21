package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.mappers.interfaces.CategoryMapper;
import com.iti.jets.sakilaJax.persistence.entities.Category;
import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategory;
import com.iti.jets.sakilaJax.persistence.entities.FilmCategoryId;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( categoryDto.getCategoryId() );
        category.setName( categoryDto.getName() );
        category.setLastUpdate( categoryDto.getLastUpdate() );
        category.setFilmCategories( filmCategoryDtoSetToFilmCategorySet( categoryDto.getFilmCategories() ) );

        linkFilmCategories( category );

        return category;
    }

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Set<FilmCategoryDto> filmCategories = null;
        Short categoryId = null;
        String name = null;
        Timestamp lastUpdate = null;

        filmCategories = filmCategorySetToFilmCategoryDtoSet( category.getFilmCategories() );
        categoryId = category.getCategoryId();
        name = category.getName();
        lastUpdate = category.getLastUpdate();

        CategoryDto categoryDto = new CategoryDto( categoryId, name, lastUpdate, filmCategories );

        return categoryDto;
    }

    @Override
    public Category partialUpdate(CategoryDto categoryDto, Category category) {
        if ( categoryDto == null ) {
            return category;
        }

        if ( categoryDto.getCategoryId() != null ) {
            category.setCategoryId( categoryDto.getCategoryId() );
        }
        if ( categoryDto.getName() != null ) {
            category.setName( categoryDto.getName() );
        }
        if ( categoryDto.getLastUpdate() != null ) {
            category.setLastUpdate( categoryDto.getLastUpdate() );
        }
        if ( category.getFilmCategories() != null ) {
            Set<FilmCategory> set = filmCategoryDtoSetToFilmCategorySet( categoryDto.getFilmCategories() );
            if ( set != null ) {
                category.getFilmCategories().clear();
                category.getFilmCategories().addAll( set );
            }
        }
        else {
            Set<FilmCategory> set = filmCategoryDtoSetToFilmCategorySet( categoryDto.getFilmCategories() );
            if ( set != null ) {
                category.setFilmCategories( set );
            }
        }

        linkFilmCategories( category );

        return category;
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

        linkFilmCategories( category );

        return category;
    }

    protected FilmCategory filmCategoryDtoToFilmCategory(FilmCategoryDto filmCategoryDto) {
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

    protected Set<FilmCategory> filmCategoryDtoSetToFilmCategorySet(Set<FilmCategoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmCategory> set1 = new LinkedHashSet<FilmCategory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmCategoryDto filmCategoryDto : set ) {
            set1.add( filmCategoryDtoToFilmCategory( filmCategoryDto ) );
        }

        return set1;
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

    protected FilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory) {
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

    protected Set<FilmCategoryDto> filmCategorySetToFilmCategoryDtoSet(Set<FilmCategory> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmCategoryDto> set1 = new LinkedHashSet<FilmCategoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmCategory filmCategory : set ) {
            set1.add( filmCategoryToFilmCategoryDto( filmCategory ) );
        }

        return set1;
    }
}
