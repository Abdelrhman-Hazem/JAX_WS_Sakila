package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.AddressDto;
import com.iti.jets.sakilaJax.dtos.CityDtoSimple;
import com.iti.jets.sakilaJax.mappers.interfaces.AddressMapper;
import com.iti.jets.sakilaJax.persistence.entities.Address;
import com.iti.jets.sakilaJax.persistence.entities.City;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;
import java.util.Arrays;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:48+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setAddressId( addressDto.getAddressId() );
        address.setCity( cityDtoSimpleToCity( addressDto.getCity() ) );
        address.setAddress( addressDto.getAddress() );
        address.setAddress2( addressDto.getAddress2() );
        address.setDistrict( addressDto.getDistrict() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );
        byte[] location = addressDto.getLocation();
        if ( location != null ) {
            address.setLocation( Arrays.copyOf( location, location.length ) );
        }
        address.setLastUpdate( addressDto.getLastUpdate() );

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        Short addressId = null;
        CityDtoSimple city = null;
        String address1 = null;
        String address2 = null;
        String district = null;
        String postalCode = null;
        String phone = null;
        byte[] location = null;
        Timestamp lastUpdate = null;

        addressId = address.getAddressId();
        city = cityToCityDtoSimple( address.getCity() );
        address1 = address.getAddress();
        address2 = address.getAddress2();
        district = address.getDistrict();
        postalCode = address.getPostalCode();
        phone = address.getPhone();
        byte[] location1 = address.getLocation();
        if ( location1 != null ) {
            location = Arrays.copyOf( location1, location1.length );
        }
        lastUpdate = address.getLastUpdate();

        AddressDto addressDto = new AddressDto( addressId, city, address1, address2, district, postalCode, phone, location, lastUpdate );

        return addressDto;
    }

    @Override
    public Address partialUpdate(AddressDto addressDto, Address address) {
        if ( addressDto == null ) {
            return address;
        }

        if ( addressDto.getAddressId() != null ) {
            address.setAddressId( addressDto.getAddressId() );
        }
        if ( addressDto.getCity() != null ) {
            if ( address.getCity() == null ) {
                address.setCity( new City() );
            }
            cityDtoSimpleToCity1( addressDto.getCity(), address.getCity() );
        }
        if ( addressDto.getAddress() != null ) {
            address.setAddress( addressDto.getAddress() );
        }
        if ( addressDto.getAddress2() != null ) {
            address.setAddress2( addressDto.getAddress2() );
        }
        if ( addressDto.getDistrict() != null ) {
            address.setDistrict( addressDto.getDistrict() );
        }
        if ( addressDto.getPostalCode() != null ) {
            address.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getPhone() != null ) {
            address.setPhone( addressDto.getPhone() );
        }
        byte[] location = addressDto.getLocation();
        if ( location != null ) {
            address.setLocation( Arrays.copyOf( location, location.length ) );
        }
        if ( addressDto.getLastUpdate() != null ) {
            address.setLastUpdate( addressDto.getLastUpdate() );
        }

        return address;
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

    protected void cityDtoSimpleToCity1(CityDtoSimple cityDtoSimple, City mappingTarget) {
        if ( cityDtoSimple == null ) {
            return;
        }

        if ( cityDtoSimple.getCityId() != null ) {
            mappingTarget.setCityId( cityDtoSimple.getCityId() );
        }
        if ( cityDtoSimple.getCity() != null ) {
            mappingTarget.setCity( cityDtoSimple.getCity() );
        }
    }
}
