package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.persistence.entities.*;
import com.iti.jets.sakilaJax.mappers.interfaces.AddressMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.PaymentMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.RentalMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.StaffMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.annotation.processing.Generated;
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
public class StaffMapperImpl implements StaffMapper {

    @Inject
    private AddressMapper addressMapper;
    @Inject
    private PaymentMapper paymentMapper;
    @Inject
    private RentalMapper rentalMapper;

    @Override
    public Staff toEntity(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStaffId( staffDto.getStaffId() );
        staff.setStore( storeDtoSimpleToStore( staffDto.getStore() ) );
        staff.setAddress( addressMapper.toEntity( staffDto.getAddress() ) );
        staff.setFirstName( staffDto.getFirstName() );
        staff.setLastName( staffDto.getLastName() );
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            staff.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        staff.setEmail( staffDto.getEmail() );
        staff.setActive( staffDto.getActive() );
        staff.setUsername( staffDto.getUsername() );
        staff.setPassword( staffDto.getPassword() );
        staff.setLastUpdate( staffDto.getLastUpdate() );
        staff.setPayments( paymentDtoSimpleSetToPaymentSet( staffDto.getPayments() ) );
        staff.setStores( storeDtoSimpleSetToStoreSet( staffDto.getStores() ) );
        staff.setRentals( rentalDtoSimpleSetToRentalSet( staffDto.getRentals() ) );

        linkPayments( staff );
        linkStores( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public StaffDto toDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        Set<PaymentDtoSimple> payments = null;
        Set<StoreDtoSimple> stores = null;
        Set<RentalDtoSimple> rentals = null;
        boolean active = false;
        Short staffId = null;
        StoreDtoSimple store = null;
        AddressDto address = null;
        String firstName = null;
        String lastName = null;
        byte[] picture = null;
        String email = null;
        String username = null;
        String password = null;
        Timestamp lastUpdate = null;

        payments = paymentSetToPaymentDtoSimpleSet( staff.getPayments() );
        stores = storeSetToStoreDtoSimpleSet( staff.getStores() );
        rentals = rentalSetToRentalDtoSimpleSet( staff.getRentals() );
        active = staff.isActive();
        staffId = staff.getStaffId();
        store = storeToStoreDtoSimple( staff.getStore() );
        address = addressMapper.toDto( staff.getAddress() );
        firstName = staff.getFirstName();
        lastName = staff.getLastName();
        byte[] picture1 = staff.getPicture();
        if ( picture1 != null ) {
            picture = Arrays.copyOf( picture1, picture1.length );
        }
        email = staff.getEmail();
        username = staff.getUsername();
        password = staff.getPassword();
        lastUpdate = staff.getLastUpdate();

        StaffDto staffDto = new StaffDto( active, staffId, store, address, firstName, lastName, picture, email, username, password, lastUpdate, payments, stores, rentals );

        return staffDto;
    }

    @Override
    public Staff partialUpdate(StaffDto staffDto, Staff staff) {
        if ( staffDto == null ) {
            return staff;
        }

        if ( staffDto.getStaffId() != null ) {
            staff.setStaffId( staffDto.getStaffId() );
        }
        if ( staffDto.getStore() != null ) {
            if ( staff.getStore() == null ) {
                staff.setStore( new Store() );
            }
            storeDtoSimpleToStore1( staffDto.getStore(), staff.getStore() );
        }
        if ( staffDto.getAddress() != null ) {
            if ( staff.getAddress() == null ) {
                staff.setAddress( new Address() );
            }
            addressMapper.partialUpdate( staffDto.getAddress(), staff.getAddress() );
        }
        if ( staffDto.getFirstName() != null ) {
            staff.setFirstName( staffDto.getFirstName() );
        }
        if ( staffDto.getLastName() != null ) {
            staff.setLastName( staffDto.getLastName() );
        }
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            staff.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        if ( staffDto.getEmail() != null ) {
            staff.setEmail( staffDto.getEmail() );
        }
        staff.setActive( staffDto.getActive() );
        if ( staffDto.getUsername() != null ) {
            staff.setUsername( staffDto.getUsername() );
        }
        if ( staffDto.getPassword() != null ) {
            staff.setPassword( staffDto.getPassword() );
        }
        if ( staffDto.getLastUpdate() != null ) {
            staff.setLastUpdate( staffDto.getLastUpdate() );
        }
        if ( staff.getPayments() != null ) {
            Set<Payment> set = paymentDtoSimpleSetToPaymentSet( staffDto.getPayments() );
            if ( set != null ) {
                staff.getPayments().clear();
                staff.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSimpleSetToPaymentSet( staffDto.getPayments() );
            if ( set != null ) {
                staff.setPayments( set );
            }
        }
        if ( staff.getStores() != null ) {
            Set<Store> set1 = storeDtoSimpleSetToStoreSet( staffDto.getStores() );
            if ( set1 != null ) {
                staff.getStores().clear();
                staff.getStores().addAll( set1 );
            }
        }
        else {
            Set<Store> set1 = storeDtoSimpleSetToStoreSet( staffDto.getStores() );
            if ( set1 != null ) {
                staff.setStores( set1 );
            }
        }
        if ( staff.getRentals() != null ) {
            Set<Rental> set2 = rentalDtoSimpleSetToRentalSet( staffDto.getRentals() );
            if ( set2 != null ) {
                staff.getRentals().clear();
                staff.getRentals().addAll( set2 );
            }
        }
        else {
            Set<Rental> set2 = rentalDtoSimpleSetToRentalSet( staffDto.getRentals() );
            if ( set2 != null ) {
                staff.setRentals( set2 );
            }
        }

        linkPayments( staff );
        linkStores( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public Staff toEntity1(StaffDtoSimple staffDtoSimple) {
        if ( staffDtoSimple == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setStaffId( staffDtoSimple.getStaffId() );
        staff.setFirstName( staffDtoSimple.getFirstName() );
        staff.setLastName( staffDtoSimple.getLastName() );
        staff.setActive( staffDtoSimple.getActive() );

        linkPayments( staff );
        linkStores( staff );
        linkRentals( staff );

        return staff;
    }

    @Override
    public StaffDtoSimple toDto1(Staff staff) {
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

    @Override
    public Staff partialUpdate1(StaffDtoSimple staffDtoSimple, Staff staff) {
        if ( staffDtoSimple == null ) {
            return staff;
        }

        if ( staffDtoSimple.getStaffId() != null ) {
            staff.setStaffId( staffDtoSimple.getStaffId() );
        }
        if ( staffDtoSimple.getFirstName() != null ) {
            staff.setFirstName( staffDtoSimple.getFirstName() );
        }
        if ( staffDtoSimple.getLastName() != null ) {
            staff.setLastName( staffDtoSimple.getLastName() );
        }
        staff.setActive( staffDtoSimple.getActive() );

        linkPayments( staff );
        linkStores( staff );
        linkRentals( staff );

        return staff;
    }

    protected Store storeDtoSimpleToStore(StoreDtoSimple storeDtoSimple) {
        if ( storeDtoSimple == null ) {
            return null;
        }

        Store store = new Store();

        store.setStoreId( storeDtoSimple.getStoreId() );
        store.setAddress( addressMapper.toEntity( storeDtoSimple.getAddress() ) );

        return store;
    }

    protected Set<Payment> paymentDtoSimpleSetToPaymentSet(Set<PaymentDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Payment> set1 = new LinkedHashSet<Payment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PaymentDtoSimple paymentDtoSimple : set ) {
            set1.add( paymentMapper.toEntity1( paymentDtoSimple ) );
        }

        return set1;
    }

    protected Set<Store> storeDtoSimpleSetToStoreSet(Set<StoreDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Store> set1 = new LinkedHashSet<Store>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StoreDtoSimple storeDtoSimple : set ) {
            set1.add( storeDtoSimpleToStore( storeDtoSimple ) );
        }

        return set1;
    }

    protected Set<Rental> rentalDtoSimpleSetToRentalSet(Set<RentalDtoSimple> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentalDtoSimple rentalDtoSimple : set ) {
            set1.add( rentalMapper.toEntity1( rentalDtoSimple ) );
        }

        return set1;
    }

    protected Set<PaymentDtoSimple> paymentSetToPaymentDtoSimpleSet(Set<Payment> set) {
        if ( set == null ) {
            return null;
        }

        Set<PaymentDtoSimple> set1 = new LinkedHashSet<PaymentDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Payment payment : set ) {
            set1.add( paymentMapper.toDto1( payment ) );
        }

        return set1;
    }

    protected StoreDtoSimple storeToStoreDtoSimple(Store store) {
        if ( store == null ) {
            return null;
        }

        Short storeId = null;
        AddressDto address = null;

        storeId = store.getStoreId();
        address = addressMapper.toDto( store.getAddress() );

        StoreDtoSimple storeDtoSimple = new StoreDtoSimple( storeId, address );

        return storeDtoSimple;
    }

    protected Set<StoreDtoSimple> storeSetToStoreDtoSimpleSet(Set<Store> set) {
        if ( set == null ) {
            return null;
        }

        Set<StoreDtoSimple> set1 = new LinkedHashSet<StoreDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Store store : set ) {
            set1.add( storeToStoreDtoSimple( store ) );
        }

        return set1;
    }

    protected Set<RentalDtoSimple> rentalSetToRentalDtoSimpleSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentalDtoSimple> set1 = new LinkedHashSet<RentalDtoSimple>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( rentalMapper.toDto1( rental ) );
        }

        return set1;
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
            addressMapper.partialUpdate( storeDtoSimple.getAddress(), mappingTarget.getAddress() );
        }
    }
}
