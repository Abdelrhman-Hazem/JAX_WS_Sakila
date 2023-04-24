package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmActorMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmCategoryMapper;
import com.iti.jets.sakilaJax.persistence.entities.*;
import com.iti.jets.sakilaJax.mappers.interfaces.FilmMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.InventoryMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class FilmMapperImpl implements FilmMapper {

//    @Inject
    private InventoryMapper inventoryMapper= new InventoryMapperImpl();
//    @Inject
    private FilmActorMapper filmActorMapper = new FilmActorMapperImpl();
//    @Inject
    private FilmCategoryMapper filmCategoryMapper = new FilmCategoryMapperImpl();

    @Override
    public Film toEntity(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setFilmId( filmDto.getFilmId() );
        film.setLanguageByLanguageId( languageDtoToLanguage( filmDto.getLanguageByLanguageId() ) );
        film.setLanguageByOriginalLanguageId( languageDtoToLanguage( filmDto.getLanguageByOriginalLanguageId() ) );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        film.setLastUpdate( filmDto.getLastUpdate() );
        film.setInventories( inventoryDtoSetToInventorySet( filmDto.getInventories() ) );
        film.setFilmActors( filmActorDtoSetToFilmActorSet( filmDto.getFilmActors() ) );
        film.setFilmCategories( filmCategoryDtoSetToFilmCategorySet( filmDto.getFilmCategories() ) );

        linkInventories( film );
        linkFilmActors( film );
        linkFilmCategories( film );

        return film;
    }

    @Override
    public FilmDto toDto(Film film) {
        if ( film == null ) {
            return null;
        }

        Set<InventoryDto> inventories = null;
        Set<FilmActorDto> filmActors = null;
        Set<FilmCategoryDto> filmCategories = null;
        Short filmId = null;
        LanguageDto languageByLanguageId = null;
        LanguageDto languageByOriginalLanguageId = null;
        String title = null;
        String description = null;
        Date releaseYear = null;
        byte rentalDuration = 0;
        BigDecimal rentalRate = null;
        Short length = null;
        BigDecimal replacementCost = null;
        String rating = null;
        String specialFeatures = null;
        Timestamp lastUpdate = null;

        inventories = inventorySetToInventoryDtoSet( film.getInventories() );
        filmActors = filmActorSetToFilmActorDtoSet( film.getFilmActors() );
        filmCategories = filmCategorySetToFilmCategoryDtoSet( film.getFilmCategories() );
        filmId = film.getFilmId();
        languageByLanguageId = languageToLanguageDto( film.getLanguageByLanguageId() );
        languageByOriginalLanguageId = languageToLanguageDto( film.getLanguageByOriginalLanguageId() );
        title = film.getTitle();
        description = film.getDescription();
        releaseYear = film.getReleaseYear();
        rentalDuration = film.getRentalDuration();
        rentalRate = film.getRentalRate();
        length = film.getLength();
        replacementCost = film.getReplacementCost();
        rating = film.getRating();
        specialFeatures = film.getSpecialFeatures();
        lastUpdate = film.getLastUpdate();

        FilmDto filmDto = new FilmDto( filmId, languageByLanguageId, languageByOriginalLanguageId, title, description, releaseYear, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate, inventories, filmActors, filmCategories );

        return filmDto;
    }

    @Override
    public Film partialUpdate(FilmDto filmDto, Film film) {
        if ( filmDto == null ) {
            return film;
        }

        if ( filmDto.getFilmId() != null ) {
            film.setFilmId( filmDto.getFilmId() );
        }
        if ( filmDto.getLanguageByLanguageId() != null ) {
            if ( film.getLanguageByLanguageId() == null ) {
                film.setLanguageByLanguageId( new Language() );
            }
            languageDtoToLanguage1( filmDto.getLanguageByLanguageId(), film.getLanguageByLanguageId() );
        }
        if ( filmDto.getLanguageByOriginalLanguageId() != null ) {
            if ( film.getLanguageByOriginalLanguageId() == null ) {
                film.setLanguageByOriginalLanguageId( new Language() );
            }
            languageDtoToLanguage1( filmDto.getLanguageByOriginalLanguageId(), film.getLanguageByOriginalLanguageId() );
        }
        if ( filmDto.getTitle() != null ) {
            film.setTitle( filmDto.getTitle() );
        }
        if ( filmDto.getDescription() != null ) {
            film.setDescription( filmDto.getDescription() );
        }
        if ( filmDto.getReleaseYear() != null ) {
            film.setReleaseYear( filmDto.getReleaseYear() );
        }
        film.setRentalDuration( filmDto.getRentalDuration() );
        if ( filmDto.getRentalRate() != null ) {
            film.setRentalRate( filmDto.getRentalRate() );
        }
        if ( filmDto.getLength() != null ) {
            film.setLength( filmDto.getLength() );
        }
        if ( filmDto.getReplacementCost() != null ) {
            film.setReplacementCost( filmDto.getReplacementCost() );
        }
        if ( filmDto.getRating() != null ) {
            film.setRating( filmDto.getRating() );
        }
        if ( filmDto.getSpecialFeatures() != null ) {
            film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        }
        if ( filmDto.getLastUpdate() != null ) {
            film.setLastUpdate( filmDto.getLastUpdate() );
        }
        if ( film.getInventories() != null ) {
            Set<Inventory> set = inventoryDtoSetToInventorySet( filmDto.getInventories() );
            if ( set != null ) {
                film.getInventories().clear();
                film.getInventories().addAll( set );
            }
        }
        else {
            Set<Inventory> set = inventoryDtoSetToInventorySet( filmDto.getInventories() );
            if ( set != null ) {
                film.setInventories( set );
            }
        }
        if ( film.getFilmActors() != null ) {
            Set<FilmActor> set1 = filmActorDtoSetToFilmActorSet( filmDto.getFilmActors() );
            if ( set1 != null ) {
                film.getFilmActors().clear();
                film.getFilmActors().addAll( set1 );
            }
        }
        else {
            Set<FilmActor> set1 = filmActorDtoSetToFilmActorSet( filmDto.getFilmActors() );
            if ( set1 != null ) {
                film.setFilmActors( set1 );
            }
        }
        if ( film.getFilmCategories() != null ) {
            Set<FilmCategory> set2 = filmCategoryDtoSetToFilmCategorySet( filmDto.getFilmCategories() );
            if ( set2 != null ) {
                film.getFilmCategories().clear();
                film.getFilmCategories().addAll( set2 );
            }
        }
        else {
            Set<FilmCategory> set2 = filmCategoryDtoSetToFilmCategorySet( filmDto.getFilmCategories() );
            if ( set2 != null ) {
                film.setFilmCategories( set2 );
            }
        }

        linkInventories( film );
        linkFilmActors( film );
        linkFilmCategories( film );

        return film;
    }

    protected Film filmDtoSimpleToFilm(FilmDtoSimple filmDtoSimple) {
        if ( filmDtoSimple == null ) {
            return null;
        }

        Film film = new Film();

        film.setFilmId( filmDtoSimple.getFilmId() );
        film.setTitle( filmDtoSimple.getTitle() );

        linkInventories( film );
        linkFilmActors( film );
        linkFilmCategories( film );

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

    protected Language languageDtoToLanguage(LanguageDto languageDto) {
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

    protected Set<Inventory> inventoryDtoSetToInventorySet(Set<InventoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Inventory> set1 = new LinkedHashSet<Inventory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( InventoryDto inventoryDto : set ) {
            set1.add( inventoryMapper.toEntity( inventoryDto ) );
        }

        return set1;
    }

    protected Set<FilmActor> filmActorDtoSetToFilmActorSet(Set<FilmActorDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActor> set1 = new LinkedHashSet<FilmActor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActorDto filmActorDto : set ) {
            set1.add( filmActorMapper.toEntity( filmActorDto ) );
        }

        return set1;
    }

    protected Set<FilmCategory> filmCategoryDtoSetToFilmCategorySet(Set<FilmCategoryDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmCategory> set1 = new LinkedHashSet<FilmCategory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmCategoryDto filmCategoryDto : set ) {
            set1.add( filmCategoryMapper.toEntity( filmCategoryDto ) );
        }

        return set1;
    }

    protected Set<InventoryDto> inventorySetToInventoryDtoSet(Set<Inventory> set) {
        if ( set == null ) {
            return null;
        }

        Set<InventoryDto> set1 = new LinkedHashSet<InventoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Inventory inventory : set ) {
            set1.add( inventoryMapper.toDto( inventory ) );
        }

        return set1;
    }

    protected Set<FilmActorDto> filmActorSetToFilmActorDtoSet(Set<FilmActor> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmActorDto> set1 = new LinkedHashSet<FilmActorDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmActor filmActor : set ) {
            set1.add( filmActorMapper.toDto( filmActor ) );
        }

        return set1;
    }

    protected Set<FilmCategoryDto> filmCategorySetToFilmCategoryDtoSet(Set<FilmCategory> set) {
        if ( set == null ) {
            return null;
        }

        Set<FilmCategoryDto> set1 = new LinkedHashSet<FilmCategoryDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( FilmCategory filmCategory : set ) {
            set1.add( filmCategoryMapper.toDto( filmCategory ) );
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

    protected LanguageDto languageToLanguageDto(Language language) {
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

    protected void languageDtoToLanguage1(LanguageDto languageDto, Language mappingTarget) {
        if ( languageDto == null ) {
            return;
        }

        if ( languageDto.getLanguageId() != null ) {
            mappingTarget.setLanguageId( languageDto.getLanguageId() );
        }
        if ( languageDto.getName() != null ) {
            mappingTarget.setName( languageDto.getName() );
        }
        if ( languageDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( languageDto.getLastUpdate() );
        }
        if ( mappingTarget.getFilmsForLanguageId() != null ) {
            Set<Film> set = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForLanguageId() );
            if ( set != null ) {
                mappingTarget.getFilmsForLanguageId().clear();
                mappingTarget.getFilmsForLanguageId().addAll( set );
            }
        }
        else {
            Set<Film> set = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForLanguageId() );
            if ( set != null ) {
                mappingTarget.setFilmsForLanguageId( set );
            }
        }
        if ( mappingTarget.getFilmsForOriginalLanguageId() != null ) {
            Set<Film> set1 = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForOriginalLanguageId() );
            if ( set1 != null ) {
                mappingTarget.getFilmsForOriginalLanguageId().clear();
                mappingTarget.getFilmsForOriginalLanguageId().addAll( set1 );
            }
        }
        else {
            Set<Film> set1 = filmDtoSimpleSetToFilmSet( languageDto.getFilmsForOriginalLanguageId() );
            if ( set1 != null ) {
                mappingTarget.setFilmsForOriginalLanguageId( set1 );
            }
        }
    }
}
