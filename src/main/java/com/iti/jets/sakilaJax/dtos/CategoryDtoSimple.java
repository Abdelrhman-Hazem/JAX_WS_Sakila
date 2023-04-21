package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Category;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Category} entity
 */
@XmlRootElement
public class CategoryDtoSimple implements Serializable {
    private final Short categoryId;
    private final String name;

    public CategoryDtoSimple(Short categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public Short getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDtoSimple entity = (CategoryDtoSimple) o;
        return Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "categoryId = " + categoryId + ", " +
                "name = " + name + ")";
    }
}