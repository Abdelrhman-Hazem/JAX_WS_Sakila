package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.persistence.entities.*;
import com.iti.jets.sakilaJax.mappers.interfaces.AddressMapper;
import com.iti.jets.sakilaJax.mappers.interfaces.CustomerMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class CustomerMapperImpl implements CustomerMapper {

    @Inject
    private AddressMapper addressMapper;

    @Override
    public Customer toEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( customerDto.getCustomerId() );
        customer.setStore( storeDtoSimpleToStore( customerDto.getStore() ) );
        customer.setAddress( addressMapper.toEntity( customerDto.getAddress() ) );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setLastName( customerDto.getLastName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setActive( customerDto.getActive() );
        customer.setCreateDate( customerDto.getCreateDate() );
        customer.setLastUpdate( customerDto.getLastUpdate() );
        customer.setPayments( paymentDtoSetToPaymentSet( customerDto.getPayments() ) );
        customer.setRentals( rentalDtoSetToRentalSet( customerDto.getRentals() ) );

        linkPayments( customer );
        linkRentals( customer );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Set<PaymentDto> payments = null;
        Set<RentalDto> rentals = null;
        boolean active = false;
        Short customerId = null;
        StoreDtoSimple store = null;
        AddressDto address = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        Timestamp createDate = null;
        Timestamp lastUpdate = null;

        payments = paymentSetToPaymentDtoSet( customer.getPayments() );
        rentals = rentalSetToRentalDtoSet( customer.getRentals() );
        active = customer.isActive();
        customerId = customer.getCustomerId();
        store = storeToStoreDtoSimple( customer.getStore() );
        address = addressMapper.toDto( customer.getAddress() );
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        email = customer.getEmail();
        createDate = customer.getCreateDate();
        lastUpdate = customer.getLastUpdate();

        CustomerDto customerDto = new CustomerDto( active, customerId, store, address, firstName, lastName, email, createDate, lastUpdate, payments, rentals );

        return customerDto;
    }

    @Override
    public Customer partialUpdate(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return customer;
        }

        if ( customerDto.getCustomerId() != null ) {
            customer.setCustomerId( customerDto.getCustomerId() );
        }
        if ( customerDto.getStore() != null ) {
            if ( customer.getStore() == null ) {
                customer.setStore( new Store() );
            }
            storeDtoSimpleToStore1( customerDto.getStore(), customer.getStore() );
        }
        if ( customerDto.getAddress() != null ) {
            if ( customer.getAddress() == null ) {
                customer.setAddress( new Address() );
            }
            addressMapper.partialUpdate( customerDto.getAddress(), customer.getAddress() );
        }
        if ( customerDto.getFirstName() != null ) {
            customer.setFirstName( customerDto.getFirstName() );
        }
        if ( customerDto.getLastName() != null ) {
            customer.setLastName( customerDto.getLastName() );
        }
        if ( customerDto.getEmail() != null ) {
            customer.setEmail( customerDto.getEmail() );
        }
        customer.setActive( customerDto.getActive() );
        if ( customerDto.getCreateDate() != null ) {
            customer.setCreateDate( customerDto.getCreateDate() );
        }
        if ( customerDto.getLastUpdate() != null ) {
            customer.setLastUpdate( customerDto.getLastUpdate() );
        }
        if ( customer.getPayments() != null ) {
            Set<Payment> set = paymentDtoSetToPaymentSet( customerDto.getPayments() );
            if ( set != null ) {
                customer.getPayments().clear();
                customer.getPayments().addAll( set );
            }
        }
        else {
            Set<Payment> set = paymentDtoSetToPaymentSet( customerDto.getPayments() );
            if ( set != null ) {
                customer.setPayments( set );
            }
        }
        if ( customer.getRentals() != null ) {
            Set<Rental> set1 = rentalDtoSetToRentalSet( customerDto.getRentals() );
            if ( set1 != null ) {
                customer.getRentals().clear();
                customer.getRentals().addAll( set1 );
            }
        }
        else {
            Set<Rental> set1 = rentalDtoSetToRentalSet( customerDto.getRentals() );
            if ( set1 != null ) {
                customer.setRentals( set1 );
            }
        }

        linkPayments( customer );
        linkRentals( customer );

        return customer;
    }

    @Override
    public Customer toEntity1(CustomerDtoSimple customerDtoSimple) {
        if ( customerDtoSimple == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( customerDtoSimple.getCustomerId() );
        customer.setFirstName( customerDtoSimple.getFirstName() );
        customer.setLastName( customerDtoSimple.getLastName() );
        customer.setActive( customerDtoSimple.getActive() );

        linkPayments( customer );
        linkRentals( customer );

        return customer;
    }

    @Override
    public CustomerDtoSimple toDto1(Customer customer) {
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

    @Override
    public Customer partialUpdate1(CustomerDtoSimple customerDtoSimple, Customer customer) {
        if ( customerDtoSimple == null ) {
            return customer;
        }

        if ( customerDtoSimple.getCustomerId() != null ) {
            customer.setCustomerId( customerDtoSimple.getCustomerId() );
        }
        if ( customerDtoSimple.getFirstName() != null ) {
            customer.setFirstName( customerDtoSimple.getFirstName() );
        }
        if ( customerDtoSimple.getLastName() != null ) {
            customer.setLastName( customerDtoSimple.getLastName() );
        }
        customer.setActive( customerDtoSimple.getActive() );

        linkPayments( customer );
        linkRentals( customer );

        return customer;
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

    protected Payment paymentDtoToPayment(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDto.getPaymentId() );
        payment.setStaff( staffDtoSimpleToStaff( paymentDto.getStaff() ) );
        payment.setCustomer( toEntity1( paymentDto.getCustomer() ) );
        payment.setRental( rentalDtoSimpleToRental( paymentDto.getRental() ) );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );
        payment.setLastUpdate( paymentDto.getLastUpdate() );

        return payment;
    }

    protected Set<Payment> paymentDtoSetToPaymentSet(Set<PaymentDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Payment> set1 = new LinkedHashSet<Payment>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( PaymentDto paymentDto : set ) {
            set1.add( paymentDtoToPayment( paymentDto ) );
        }

        return set1;
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
            set1.add( rentalDtoSimpleToRental( rentalDtoSimple ) );
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

    protected Rental rentalDtoToRental(RentalDto rentalDto) {
        if ( rentalDto == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setRentalId( rentalDto.getRentalId() );
        rental.setStaff( staffDtoSimpleToStaff( rentalDto.getStaff() ) );
        rental.setCustomer( toEntity1( rentalDto.getCustomer() ) );
        rental.setInventory( inventoryDtoToInventory( rentalDto.getInventory() ) );
        rental.setRentalDate( rentalDto.getRentalDate() );
        rental.setReturnDate( rentalDto.getReturnDate() );
        rental.setLastUpdate( rentalDto.getLastUpdate() );
        rental.setPayments( paymentDtoSimpleSetToPaymentSet( rentalDto.getPayments() ) );

        return rental;
    }

    protected Set<Rental> rentalDtoSetToRentalSet(Set<RentalDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Rental> set1 = new LinkedHashSet<Rental>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RentalDto rentalDto : set ) {
            set1.add( rentalDtoToRental( rentalDto ) );
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

    protected PaymentDto paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        Short paymentId = null;
        StaffDtoSimple staff = null;
        CustomerDtoSimple customer = null;
        RentalDtoSimple rental = null;
        BigDecimal amount = null;
        Timestamp paymentDate = null;
        Timestamp lastUpdate = null;

        paymentId = payment.getPaymentId();
        staff = staffToStaffDtoSimple( payment.getStaff() );
        customer = toDto1( payment.getCustomer() );
        rental = rentalToRentalDtoSimple( payment.getRental() );
        amount = payment.getAmount();
        paymentDate = payment.getPaymentDate();
        lastUpdate = payment.getLastUpdate();

        PaymentDto paymentDto = new PaymentDto( paymentId, staff, customer, rental, amount, paymentDate, lastUpdate );

        return paymentDto;
    }

    protected Set<PaymentDto> paymentSetToPaymentDtoSet(Set<Payment> set) {
        if ( set == null ) {
            return null;
        }

        Set<PaymentDto> set1 = new LinkedHashSet<PaymentDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Payment payment : set ) {
            set1.add( paymentToPaymentDto( payment ) );
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

    protected RentalDto rentalToRentalDto(Rental rental) {
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
        customer = toDto1( rental.getCustomer() );
        inventory = inventoryToInventoryDto( rental.getInventory() );
        rentalDate = rental.getRentalDate();
        returnDate = rental.getReturnDate();
        lastUpdate = rental.getLastUpdate();

        RentalDto rentalDto = new RentalDto( rentalId, staff, customer, inventory, rentalDate, returnDate, lastUpdate, payments );

        return rentalDto;
    }

    protected Set<RentalDto> rentalSetToRentalDtoSet(Set<Rental> set) {
        if ( set == null ) {
            return null;
        }

        Set<RentalDto> set1 = new LinkedHashSet<RentalDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Rental rental : set ) {
            set1.add( rentalToRentalDto( rental ) );
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
