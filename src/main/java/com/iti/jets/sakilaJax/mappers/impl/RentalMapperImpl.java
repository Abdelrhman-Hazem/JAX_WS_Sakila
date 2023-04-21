package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.persistence.entities.*;
import com.iti.jets.sakilaJax.mappers.interfaces.RentalMapper;
import jakarta.enterprise.context.ApplicationScoped;
import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class RentalMapperImpl implements RentalMapper {

    @Override
    public Rental toEntity(RentalDto rentalDto) {
        if ( rentalDto == null ) {
            return null;
        }

        Rental rental = new Rental();
        rental.setRentalId( rentalDto.getRentalId() );
        rental.setStaff( staffDtoSimpleToStaff( rentalDto.getStaff() ) );
        rental.setCustomer( customerDtoSimpleToCustomer( rentalDto.getCustomer() ) );
        rental.setInventory( inventoryDtoToInventory( rentalDto.getInventory() ) );
        rental.setRentalDate( rentalDto.getRentalDate() );
        rental.setReturnDate( rentalDto.getReturnDate() );
        rental.setLastUpdate( rentalDto.getLastUpdate() );
        rental.setPayments( paymentDtoSimpleSetToPaymentSet( rentalDto.getPayments() ) );

        return rental;
    }

    @Override
    public RentalDto toDto(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        Set<PaymentDtoSimple> payments = null;
        Integer rentalId = null;
        StaffDtoSimple staff = null;
        CustomerDtoSimple customer = null;
        InventoryDto inventory = null;
        Timestamp rentalDate = null;
        Timestamp returnDate = null;
        Timestamp lastUpdate = null;

        payments = paymentSetToPaymentDtoSimpleSet( rental.getPayments() );
        rentalId = rental.getRentalId();
        staff = staffToStaffDtoSimple( rental.getStaff() );
        customer = customerToCustomerDtoSimple( rental.getCustomer() );
        inventory = inventoryToInventoryDto( rental.getInventory() );
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        lastUpdate = rental.getLastUpdate();

        RentalDto rentalDto = new RentalDto( rentalId, staff, customer, inventory, rentalDate, returnDate, lastUpdate, payments );

        return rentalDto;
    }

    @Override
    public Rental partialUpdate(RentalDto rentalDto, Rental rental) {
        if ( rentalDto == null ) {
            return rental;
        }

        if ( rentalDto.getRentalId() != null ) {
            rental.setRentalId( rentalDto.getRentalId() );
        }
        if ( rentalDto.getStaff() != null ) {
            if ( rental.getStaff() == null ) {
                rental.setStaff( new Staff() );
            }
            staffDtoSimpleToStaff1( rentalDto.getStaff(), rental.getStaff() );
        }
        if ( rentalDto.getCustomer() != null ) {
            if ( rental.getCustomer() == null ) {
                rental.setCustomer( new Customer() );
            }
            customerDtoSimpleToCustomer1( rentalDto.getCustomer(), rental.getCustomer() );
        }
        if ( rentalDto.getInventory() != null ) {
            if ( rental.getInventory() == null ) {
                rental.setInventory( new Inventory() );
            }
            inventoryDtoToInventory1( rentalDto.getInventory(), rental.getInventory() );
        }
        if ( rentalDto.getRentalDate() != null ) {
            rental.setRentalDate( rentalDto.getRentalDate() );
        }
        if ( rentalDto.getReturnDate() != null ) {
            rental.setReturnDate( rentalDto.getReturnDate() );
        }
        if ( rentalDto.getLastUpdate() != null ) {
            rental.setLastUpdate( rentalDto.getLastUpdate() );
        }
        if ( rental.getPayments() != null ) {
            Set<Payment> set = paymentDtoSimpleSetToPaymentSet( rentalDto.getPayments() );
            if ( set != null ) {
                rental.getPayments().clear();
                rental.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSimpleSetToPaymentSet( rentalDto.getPayments() );
            if ( set != null ) {
                rental.setPayments( set );
            }
        }

        return rental;
    }

    @Override
    public Rental toEntity1(RentalDtoSimple rentalDtoSimple) {
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

    @Override
    public RentalDtoSimple toDto1(Rental rental) {
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

    @Override
    public Rental partialUpdate1(RentalDtoSimple rentalDtoSimple, Rental rental) {
        if ( rentalDtoSimple == null ) {
            return rental;
        }

        if ( rentalDtoSimple.getRentalId() != null ) {
            rental.setRentalId( rentalDtoSimple.getRentalId() );
        }
        if ( rentalDtoSimple.getRentalDate() != null ) {
            rental.setRentalDate( rentalDtoSimple.getRentalDate() );
        }
        if ( rentalDtoSimple.getReturnDate() != null ) {
            rental.setReturnDate( rentalDtoSimple.getReturnDate() );
        }
        if ( rentalDtoSimple.getLastUpdate() != null ) {
            rental.setLastUpdate( rentalDtoSimple.getLastUpdate() );
        }

        return rental;
    }

    protected Staff staffDtoSimpleToStaff(StaffDtoSimple staffDtoSimple) {
        if ( staffDtoSimple == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStaffId( staffDtoSimple.getStaffId() );
        staff.setFirstName( staffDtoSimple.getFirstName() );
        staff.setLastName( staffDtoSimple.getLastName() );
        staff.setActive( staffDtoSimple.getActive() );

        return staff;
    }

    protected Customer customerDtoSimpleToCustomer(CustomerDtoSimple customerDtoSimple) {
        if ( customerDtoSimple == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( customerDtoSimple.getCustomerId() );
        customer.setFirstName( customerDtoSimple.getFirstName() );
        customer.setLastName( customerDtoSimple.getLastName() );
        customer.setActive( customerDtoSimple.getActive() );

        return customer;
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

    protected Set<Rental> rentalDtoSimpleSetToRentalSet(Set<RentalDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentalDtoSimple rentalDtoSimple : set ) {
            set1.add( toEntity1( rentalDtoSimple ) );
        }

        return set1;
    }

    protected Inventory inventoryDtoToInventory(InventoryDto inventoryDto) {
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

    protected Payment paymentDtoSimpleToPayment(PaymentDtoSimple paymentDtoSimple) {
        if ( paymentDtoSimple == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDtoSimple.getPaymentId() );
        payment.setAmount( paymentDtoSimple.getAmount() );
        payment.setPaymentDate( paymentDtoSimple.getPaymentDate() );
        payment.setLastUpdate( paymentDtoSimple.getLastUpdate() );

        return payment;
    }

    protected Set<Payment> paymentDtoSimpleSetToPaymentSet(Set<PaymentDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Payment> set1 = new LinkedHashSet<Payment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PaymentDtoSimple paymentDtoSimple : set ) {
            set1.add( paymentDtoSimpleToPayment( paymentDtoSimple ) );
        }

        return set1;
    }

    protected PaymentDtoSimple paymentToPaymentDtoSimple(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        Short paymentId = null;
        BigDecimal amount = null;
        Timestamp paymentDate = null;
        Timestamp lastUpdate = null;

        paymentId = payment.getPaymentId();
        amount = payment.getAmount();
        paymentDate = payment.getPaymentDate();
        lastUpdate = payment.getLastUpdate();

        PaymentDtoSimple paymentDtoSimple = new PaymentDtoSimple( paymentId, amount, paymentDate, lastUpdate );

        return paymentDtoSimple;
    }

    protected Set<PaymentDtoSimple> paymentSetToPaymentDtoSimpleSet(Set<Payment> set) {
        if ( set == null ) {
            return null;
        }

        Set<PaymentDtoSimple> set1 = new LinkedHashSet<PaymentDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Payment payment : set ) {
            set1.add( paymentToPaymentDtoSimple( payment ) );
        }

        return set1;
    }

    protected StaffDtoSimple staffToStaffDtoSimple(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        boolean active = false;
        Short staffId = null;
        String firstName = null;
        String lastName = null;

        active = staff.isActive();
        staffId = staff.getStaffId();
        firstName = staff.getFirstName();
        lastName = staff.getLastName();

        StaffDtoSimple staffDtoSimple = new StaffDtoSimple( active, staffId, firstName, lastName );

        return staffDtoSimple;
    }

    protected CustomerDtoSimple customerToCustomerDtoSimple(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        boolean active = false;
        Short customerId = null;
        String firstName = null;
        String lastName = null;

        active = customer.isActive();
        customerId = customer.getCustomerId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();

        CustomerDtoSimple customerDtoSimple = new CustomerDtoSimple( active, customerId, firstName, lastName );

        return customerDtoSimple;
    }

    protected Set<RentalDtoSimple> rentalSetToRentalDtoSimpleSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentalDtoSimple> set1 = new LinkedHashSet<RentalDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( toDto1( rental ) );
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

    protected InventoryDto inventoryToInventoryDto(Inventory inventory) {
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

    protected void staffDtoSimpleToStaff1(StaffDtoSimple staffDtoSimple, Staff mappingTarget) {
        if ( staffDtoSimple == null ) {
            return;
        }

        if ( staffDtoSimple.getStaffId() != null ) {
            mappingTarget.setStaffId( staffDtoSimple.getStaffId() );
        }
        if ( staffDtoSimple.getFirstName() != null ) {
            mappingTarget.setFirstName( staffDtoSimple.getFirstName() );
        }
        if ( staffDtoSimple.getLastName() != null ) {
            mappingTarget.setLastName( staffDtoSimple.getLastName() );
        }
        mappingTarget.setActive( staffDtoSimple.getActive() );
    }

    protected void customerDtoSimpleToCustomer1(CustomerDtoSimple customerDtoSimple, Customer mappingTarget) {
        if ( customerDtoSimple == null ) {
            return;
        }

        if ( customerDtoSimple.getCustomerId() != null ) {
            mappingTarget.setCustomerId( customerDtoSimple.getCustomerId() );
        }
        if ( customerDtoSimple.getFirstName() != null ) {
            mappingTarget.setFirstName( customerDtoSimple.getFirstName() );
        }
        if ( customerDtoSimple.getLastName() != null ) {
            mappingTarget.setLastName( customerDtoSimple.getLastName() );
        }
        mappingTarget.setActive( customerDtoSimple.getActive() );
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

    protected void inventoryDtoToInventory1(InventoryDto inventoryDto, Inventory mappingTarget) {
        if ( inventoryDto == null ) {
            return;
        }

        if ( inventoryDto.getInventoryId() != null ) {
            mappingTarget.setInventoryId( inventoryDto.getInventoryId() );
        }
        if ( inventoryDto.getStore() != null ) {
            if ( mappingTarget.getStore() == null ) {
                mappingTarget.setStore( new Store() );
            }
            storeDtoSimpleToStore1( inventoryDto.getStore(), mappingTarget.getStore() );
        }
        if ( inventoryDto.getFilm() != null ) {
            if ( mappingTarget.getFilm() == null ) {
                mappingTarget.setFilm( new Film() );
            }
            filmDtoSimpleToFilm1( inventoryDto.getFilm(), mappingTarget.getFilm() );
        }
        if ( inventoryDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( inventoryDto.getLastUpdate() );
        }
        if ( mappingTarget.getRentals() != null ) {
            Set<Rental> set = rentalDtoSimpleSetToRentalSet( inventoryDto.getRentals() );
            if ( set != null ) {
                mappingTarget.getRentals().clear();
                mappingTarget.getRentals().addAll( set );
            }
        }
        else {
            Set<Rental> set = rentalDtoSimpleSetToRentalSet( inventoryDto.getRentals() );
            if ( set != null ) {
                mappingTarget.setRentals( set );
            }
        }
    }
}
