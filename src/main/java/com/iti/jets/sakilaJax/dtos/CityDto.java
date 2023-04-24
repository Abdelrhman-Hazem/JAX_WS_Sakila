package com.iti.jets.sakilaJax.dtos;

import com.iti.jets.sakilaJax.persistence.entities.City;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * A DTO for the {@link City} entity
 */
@XmlRootElement
public class CityDto implements Serializable {
    private Short cityId;
    private CountryDto country;
    private String city;
    private Timestamp lastUpdate;

    public CityDto() {
    }

    public CityDto(Short cityId, CountryDto country, String city, Timestamp lastUpdate) {
        this.cityId = cityId;
        this.country = country;
        this.city = city;
        this.lastUpdate = lastUpdate;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Short getCityId() {
        return cityId;
    }

    public CountryDto getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto entity = (CityDto) o;
        return Objects.equals(this.cityId, entity.cityId) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.lastUpdate, entity.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, country, city, lastUpdate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "cityId = " + cityId + ", " +
                "country = " + country + ", " +
                "city = " + city + ", " +
                "lastUpdate = " + lastUpdate + ")";
    }
}