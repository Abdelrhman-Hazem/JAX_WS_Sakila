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
    private Short categoryId;
    private String name;
    private Timestamp lastUpdate;
    private Set<FilmCategoryDto> filmCategories;

    public CategoryDto() {
    }

    public CategoryDto(Short categoryId, String name, Timestamp lastUpdate, Set<FilmCategoryDto> filmCategories) {
        this.categoryId = categoryId;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmCategories = filmCategories;
    }

    public void setCategoryId(Short categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setFilmCategories(Set<FilmCategoryDto> filmCategories) {
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