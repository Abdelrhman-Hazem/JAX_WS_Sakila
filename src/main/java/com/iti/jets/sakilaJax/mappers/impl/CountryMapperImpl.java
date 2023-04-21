package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.CityDtoSimple;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.mappers.interfaces.CountryMapper;
import com.iti.jets.sakilaJax.persistence.entities.City;
import com.iti.jets.sakilaJax.persistence.entities.Country;
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
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setCountryId( countryDto.getCountryId() );
        country.setCountry( countryDto.getCountry() );
        country.setLastUpdate( countryDto.getLastUpdate() );
        country.setCities( cityDtoSimpleSetToCitySet( countryDto.getCities() ) );

        return country;
    }

    @Override
    public CountryDto toDto(Country country) {
        if ( country == null ) {
            return null;
        }

        Set<CityDtoSimple> cities = null;
        Short countryId = null;
        String country1 = null;
        Timestamp lastUpdate = null;

        cities = citySetToCityDtoSimpleSet( country.getCities() );
        countryId = country.getCountryId();
        country1 = country.getCountry();
        lastUpdate = country.getLastUpdate();

        CountryDto countryDto = new CountryDto( countryId, country1, lastUpdate, cities );

        return countryDto;
    }

    @Override
    public Country partialUpdate(CountryDto countryDto, Country country) {
        if ( countryDto == null ) {
            return country;
        }

        if ( countryDto.getCountryId() != null ) {
            country.setCountryId( countryDto.getCountryId() );
        }
        if ( countryDto.getCountry() != null ) {
            country.setCountry( countryDto.getCountry() );
        }
        if ( countryDto.getLastUpdate() != null ) {
            country.setLastUpdate( countryDto.getLastUpdate() );
        }
        if ( country.getCities() != null ) {
            Set<City> set = cityDtoSimpleSetToCitySet( countryDto.getCities() );
            if ( set != null ) {
                country.getCities().clear();
                country.getCities().addAll( set );
            }
        }
        else {
            Set<City> set = cityDtoSimpleSetToCitySet( countryDto.getCities() );
            if ( set != null ) {
                country.setCities( set );
            }
        }

        return country;
    }

    protected City cityDtoSimpleToCity(CityDtoSimple cityDtoSimple) {
        if ( cityDtoSimple == null ) {
            return null;
        }

        City city = new City();

        city.setCityId( cityDtoSimple.getCityId() );
        city.setCity( cityDtoSimple.getCity() );

        return city;
    }

    protected Set<City> cityDtoSimpleSetToCitySet(Set<CityDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<City> set1 = new LinkedHashSet<City>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CityDtoSimple cityDtoSimple : set ) {
            set1.add( cityDtoSimpleToCity( cityDtoSimple ) );
        }

        return set1;
    }

    protected CityDtoSimple cityToCityDtoSimple(City city) {
        if ( city == null ) {
            return null;
        }

        Short cityId = null;
        String city1 = null;

        cityId = city.getCityId();
        city1 = city.getCity();

        CityDtoSimple cityDtoSimple = new CityDtoSimple( cityId, city1 );

        return cityDtoSimple;
    }

    protected Set<CityDtoSimple> citySetToCityDtoSimpleSet(Set<City> set) {
        if ( set == null ) {
            return null;
        }

        Set<CityDtoSimple> set1 = new LinkedHashSet<CityDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( City city : set ) {
            set1.add( cityToCityDtoSimple( city ) );
        }

        return set1;
    }
}
