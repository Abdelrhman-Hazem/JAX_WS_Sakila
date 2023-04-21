package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Language;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Language} entity
 */
@XmlRootElement
public class LanguageDto implements Serializable {
    private final Short languageId;
    private final String name;
    private final Timestamp lastUpdate;
    private final Set<FilmDtoSimple> filmsForLanguageId;
    private final Set<FilmDtoSimple> filmsForOriginalLanguageId;

    public LanguageDto(Short languageId, String name, Timestamp lastUpdate, Set<FilmDtoSimple> filmsForLanguageId, Set<FilmDtoSimple> filmsForOriginalLanguageId) {
        this.languageId = languageId;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.filmsForLanguageId = filmsForLanguageId;
        this.filmsForOriginalLanguageId = filmsForOriginalLanguageId;
    }

    public Short getLanguageId() {
        return languageId;
    }

    public String getName() {
        return name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<FilmDtoSimple> getFilmsForLanguageId() {
        return filmsForLanguageId;
    }

    public Set<FilmDtoSimple> getFilmsForOriginalLanguageId() {
        return filmsForOriginalLanguageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageDto entity = (LanguageDto) o;
        return Objects.equals(this.languageId, entity.languageId) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.filmsForLanguageId, entity.filmsForLanguageId) &&
                Objects.equals(this.filmsForOriginalLanguageId, entity.filmsForOriginalLanguageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageId, name, lastUpdate, filmsForLanguageId, filmsForOriginalLanguageId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "languageId = " + languageId + ", " +
                "name = " + name + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "filmsForLanguageId = " + filmsForLanguageId + ", " +
                "filmsForOriginalLanguageId = " + filmsForOriginalLanguageId + ")";
    }
}