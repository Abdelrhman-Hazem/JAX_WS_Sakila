package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Category;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Category} entity
 */
@XmlRootElement
public class CategoryDto implements Serializable {
    private final Short categoryId;
    private final String name;
    private final Timestamp lastUpdate;
    private final Set<FilmCategoryDto> filmCategories;

    public CategoryDto(Short categoryId, String name, Timestamp lastUpdate, Set<FilmCategoryDto> filmCategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategories = filmCategories;
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<FilmCategoryDto> getFilmCategories() {
        return filmCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.filmCategories, entity.filmCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name, lastUpdate, filmCategories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryId = " + categoryId + ", " +
                "name = " + name + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "filmCategories = " + filmCategories + ")";
    }
}