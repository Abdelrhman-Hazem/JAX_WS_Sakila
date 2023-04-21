package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.City;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link City} entity
 */
@XmlRootElement
public class CityDtoSimple implements Serializable {
    private final Short cityId;
    private final String city;

    public CityDtoSimple(Short cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }

    public Short getCityId() {
        return cityId;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDtoSimple entity = (CityDtoSimple) o;
        return Objects.equals(this.cityId, entity.cityId) &&
                Objects.equals(this.city, entity.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, city);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "cityId = " + cityId + ", " +
                "city = " + city + ")";
    }
}