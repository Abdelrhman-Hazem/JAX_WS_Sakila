package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.Country;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Country} entity
 */
@XmlRootElement
public class CountryDto implements Serializable {
    private final Short countryId;
    private final String country;
    private final Timestamp lastUpdate;
    private final Set<CityDtoSimple> cities;

    public CountryDto(Short countryId, String country, Timestamp lastUpdate, Set<CityDtoSimple> cities) {
        this.countryId = countryId;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.cities = cities;
    }

    public Short getCountryId() {
        return countryId;
    }

    public String getCountry() {
        return country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public Set<CityDtoSimple> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto entity = (CountryDto) o;
        return Objects.equals(this.countryId, entity.countryId) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate) &&
                Objects.equals(this.cities, entity.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, country, lastUpdate, cities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "countryId = " + countryId + ", " +
                "country = " + country + ", " +
                "lastUpdate = " + lastUpdate + ", " +
                "cities = " + cities + ")";
    }
}