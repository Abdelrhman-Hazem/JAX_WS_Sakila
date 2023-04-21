package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.persistence.entities.*;
import com.iti.jets.sakilaJax.mappers.interfaces.InventoryMapper;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:48+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class InventoryMapperImpl implements InventoryMapper {

    @Override
    public Inventory toEntity(InventoryDto inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setInventoryId( inventoryDto.getInventoryId() );
        inventory.setStore( storeDtoSimpleToStore( inventoryDto.getStore() ) );
        inventory.setFilm( filmDtoSimpleToFilm( inventoryDto.getFilm() ) );
        inventory.setLastUpdate( inventoryDto.getLastUpdate() );
        inventory.setRentals( rentalDtoSimpleSetToRentalSet( inventoryDto.getRentals() ) );

        return inventory;
    }

    @Override
    public InventoryDto toDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        Set<RentalDtoSimple> rentals = null;
        Integer inventoryId = null;
        StoreDtoSimple store = null;
        FilmDtoSimple film = null;
        Timestamp lastUpdate = null;

        rentals = rentalSetToRentalDtoSimpleSet( inventory.getRentals() );
        inventoryId = inventory.getInventoryId();
        store = storeToStoreDtoSimple( inventory.getStore() );
        film = filmToFilmDtoSimple( inventory.getFilm() );
        lastUpdate = inventory.getLastUpdate();

        InventoryDto inventoryDto = new InventoryDto( inventoryId, store, film, lastUpdate, rentals );

        return inventoryDto;
    }

    @Override
    public Inventory partialUpdate(InventoryDto inventoryDto, Inventory inventory) {
        if ( inventoryDto == null ) {
            return inventory;
        }

        if ( inventoryDto.getInventoryId() != null ) {
            inventory.setInventoryId( inventoryDto.getInventoryId() );
        }
        if ( inventoryDto.getStore() != null ) {
            if ( inventory.getStore() == null ) {
                inventory.setStore( new Store() );
            }
            storeDtoSimpleToStore1( inventoryDto.getStore(), inventory.getStore() );
        }
        if ( inventoryDto.getFilm() != null ) {
            if ( inventory.getFilm() == null ) {
                inventory.setFilm( new Film() );
            }
            filmDtoSimpleToFilm1( inventoryDto.getFilm(), inventory.getFilm() );
        }
        if ( inventoryDto.getLastUpdate() != null ) {
            inventory.setLastUpdate( inventoryDto.getLastUpdate() );
        }
        if ( inventory.getRentals() != null ) {
            Set<Rental> set = rentalDtoSimpleSetToRentalSet( inventoryDto.getRentals() );
            if ( set != null ) {
                inventory.getRentals().clear();
                inventory.getRentals().addAll( set );
            }
        }
        else {
            Set<Rental> set = rentalDtoSimpleSetToRentalSet( inventoryDto.getRentals() );
            if ( set != null ) {
                inventory.setRentals( set );
            }
        }

        return inventory;
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

    protected Address addressDtoToAddress(AddressDto addressDto) {
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

    protected Store storeDtoSimpleToStore(StoreDtoSimple storeDtoSimple) {
        if ( storeDtoSimple == null ) {
            return null;
        }

        Store store = new Store();

        store.setStoreId( storeDtoSimple.getStoreId() );
        store.setAddress( addressDtoToAddress( storeDtoSimple.getAddress() ) );

        return store;
    }

    protected Film filmDtoSimpleToFilm(FilmDtoSimple filmDtoSimple) {
        if ( filmDtoSimple == null ) {
            return null;
        }

        Film film = new Film();

        film.setFilmId( filmDtoSimple.getFilmId() );
        film.setTitle( filmDtoSimple.getTitle() );

        return film;
    }

    protected Rental rentalDtoSimpleToRental(RentalDtoSimple rentalDtoSimple) {
        if ( rentalDtoSimple == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setRentalId( rentalDtoSimple.getRentalId() );
        rental.setRentalDate( rentalDtoSimple.getRentalDate() );
        rental.setReturnDate( rentalDtoSimple.getReturnDate() );
        rental.setLastUpdate( rentalDtoSimple.getLastUpdate() );

        return rental;
    }

    protected Set<Rental> rentalDtoSimpleSetToRentalSet(Set<RentalDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentalDtoSimple rentalDtoSimple : set ) {
            set1.add( rentalDtoSimpleToRental( rentalDtoSimple ) );
        }

        return set1;
    }

    protected RentalDtoSimple rentalToRentalDtoSimple(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        Integer rentalId = null;
        Timestamp rentalDate = null;
        Timestamp returnDate = null;
        Timestamp lastUpdate = null;

        rentalId = rental.getRentalId();
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        lastUpdate = rental.getLastUpdate();

        RentalDtoSimple rentalDtoSimple = new RentalDtoSimple( rentalId, rentalDate, returnDate, lastUpdate );

        return rentalDtoSimple;
    }

    protected Set<RentalDtoSimple> rentalSetToRentalDtoSimpleSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentalDtoSimple> set1 = new LinkedHashSet<RentalDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( rentalToRentalDtoSimple( rental ) );
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

    protected AddressDto addressToAddressDto(Address address) {
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

    protected StoreDtoSimple storeToStoreDtoSimple(Store store) {
        if ( store == null ) {
            return null;
        }

        Short storeId = null;
        AddressDto address = null;

        storeId = store.getStoreId();
        address = addressToAddressDto( store.getAddress() );

        StoreDtoSimple storeDtoSimple = new StoreDtoSimple( storeId, address );

        return storeDtoSimple;
    }

    protected FilmDtoSimple filmToFilmDtoSimple(Film film) {
        if ( film == null ) {
            return null;
        }

        Short filmId = null;
        String title = null;

        filmId = film.getFilmId();
        title = film.getTitle();

        FilmDtoSimple filmDtoSimple = new FilmDtoSimple( filmId, title );

        return filmDtoSimple;
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

    protected void addressDtoToAddress1(AddressDto addressDto, Address mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        if ( addressDto.getAddressId() != null ) {
            mappingTarget.setAddressId( addressDto.getAddressId() );
        }
        if ( addressDto.getCity() != null ) {
            if ( mappingTarget.getCity() == null ) {
                mappingTarget.setCity( new City() );
            }
            cityDtoSimpleToCity1( addressDto.getCity(), mappingTarget.getCity() );
        }
        if ( addressDto.getAddress() != null ) {
            mappingTarget.setAddress( addressDto.getAddress() );
        }
        if ( addressDto.getAddress2() != null ) {
            mappingTarget.setAddress2( addressDto.getAddress2() );
        }
        if ( addressDto.getDistrict() != null ) {
            mappingTarget.setDistrict( addressDto.getDistrict() );
        }
        if ( addressDto.getPostalCode() != null ) {
            mappingTarget.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getPhone() != null ) {
            mappingTarget.setPhone( addressDto.getPhone() );
        }
        byte[] location = addressDto.getLocation();
        if ( location != null ) {
            mappingTarget.setLocation( Arrays.copyOf( location, location.length ) );
        }
        if ( addressDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( addressDto.getLastUpdate() );
        }
    }

    protected void storeDtoSimpleToStore1(StoreDtoSimple storeDtoSimple, Store mappingTarget) {
        if ( storeDtoSimple == null ) {
            return;
        }

        if ( storeDtoSimple.getStoreId() != null ) {
            mappingTarget.setStoreId( storeDtoSimple.getStoreId() );
        }
        if ( storeDtoSimple.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( storeDtoSimple.getAddress(), mappingTarget.getAddress() );
        }
    }

    protected void filmDtoSimpleToFilm1(FilmDtoSimple filmDtoSimple, Film mappingTarget) {
        if ( filmDtoSimple == null ) {
            return;
        }

        if ( filmDtoSimple.getFilmId() != null ) {
            mappingTarget.setFilmId( filmDtoSimple.getFilmId() );
        }
        if ( filmDtoSimple.getTitle() != null ) {
            mappingTarget.setTitle( filmDtoSimple.getTitle() );
        }
    }
}
