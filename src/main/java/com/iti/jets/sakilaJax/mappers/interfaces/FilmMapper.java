package com.iti.jets.sakilaJax.mappers.interfaces;

import com.iti.jets.sakilaJax.persistence.entities.Film;
import com.iti.jets.sakilaJax.dtos.FilmDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.CDI, uses = {InventoryMapper.class, FilmActorMapper.class, FilmCategoryMapper.class})
public interface FilmMapper {
    Film toEntity(FilmDto filmDto);

    FilmDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);

    @AfterMapping
    default void linkInventories(@MappingTarget Film film) {
        film.getInventories().forEach(inventory -> inventory.setFilm(film));
    }

    @AfterMapping
    default void linkFilmActors(@MappingTarget Film film) {
        film.getFilmActors().forEach(filmActor -> filmActor.setFilm(film));
    }

    @AfterMapping
    default void linkFilmCategories(@MappingTarget Film film) {
        film.getFilmCategories().forEach(filmCategory -> filmCategory.setFilm(film));
    }
}