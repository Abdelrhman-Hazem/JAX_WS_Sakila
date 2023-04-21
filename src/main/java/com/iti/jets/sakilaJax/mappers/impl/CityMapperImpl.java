package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.CityDto;
import com.iti.jets.sakilaJax.dtos.CityDtoSimple;
import com.iti.jets.sakilaJax.dtos.CountryDto;
import com.iti.jets.sakilaJax.mappers.interfaces.CityMapper;
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
public class CityMapperImpl implements CityMapper {

    @Override
    public City toEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City city = new City();

        city.setCityId( cityDto.getCityId() );
        city.setCountry( countryDtoToCountry( cityDto.getCountry() ) );
        city.setCity( cityDto.getCity() );
        city.setLastUpdate( cityDto.getLastUpdate() );

        return city;
    }

    @Override
    public CityDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        Short cityId = null;
        CountryDto country = null;
        String city1 = null;
        Timestamp lastUpdate = null;

        cityId = city.getCityId();
        country = countryToCountryDto( city.getCountry() );
        city1 = city.getCity();
        lastUpdate = city.getLastUpdate();

        CityDto cityDto = new CityDto( cityId, country, city1, lastUpdate );

        return cityDto;
    }

    @Override
    public City partialUpdate(CityDto cityDto, City city) {
        if ( cityDto == null ) {
            return city;
        }

        if ( cityDto.getCityId() != null ) {
            city.setCityId( cityDto.getCityId() );
        }
        if ( cityDto.getCountry() != null ) {
            if ( city.getCountry() == null ) {
                city.setCountry( new Country() );
            }
            countryDtoToCountry1( cityDto.getCountry(), city.getCountry() );
        }
        if ( cityDto.getCity() != null ) {
            city.setCity( cityDto.getCity() );
        }
        if ( cityDto.getLastUpdate() != null ) {
            city.setLastUpdate( cityDto.getLastUpdate() );
        }

        return city;
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

    protected Country countryDtoToCountry(CountryDto countryDto) {
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

    protected CountryDto countryToCountryDto(Country country) {
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

    protected void countryDtoToCountry1(CountryDto countryDto, Country mappingTarget) {
        if ( countryDto == null ) {
            return;
        }

        if ( countryDto.getCountryId() != null ) {
            mappingTarget.setCountryId( countryDto.getCountryId() );
        }
        if ( countryDto.getCountry() != null ) {
            mappingTarget.setCountry( countryDto.getCountry() );
        }
        if ( countryDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( countryDto.getLastUpdate() );
        }
        if ( mappingTarget.getCities() != null ) {
            Set<City> set = cityDtoSimpleSetToCitySet( countryDto.getCities() );
            if ( set != null ) {
                mappingTarget.getCities().clear();
                mappingTarget.getCities().addAll( set );
            }
        }
        else {
            Set<City> set = cityDtoSimpleSetToCitySet( countryDto.getCities() );
            if ( set != null ) {
                mappingTarget.setCities( set );
            }
        }
    }
}
