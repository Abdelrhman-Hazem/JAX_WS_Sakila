package com.iti.jets.sakilaJax.mappers.impl;

import com.iti.jets.sakilaJax.dtos.*;
import com.iti.jets.sakilaJax.mappers.interfaces.PaymentMapper;
import com.iti.jets.sakilaJax.persistence.entities.Customer;
import com.iti.jets.sakilaJax.persistence.entities.Payment;
import com.iti.jets.sakilaJax.persistence.entities.Rental;
import com.iti.jets.sakilaJax.persistence.entities.Staff;
import jakarta.enterprise.context.ApplicationScoped;

import javax.annotation.processing.Generated;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-19T17:30:49+0200",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public Payment toEntity(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setPaymentId( paymentDto.getPaymentId() );
        payment.setStaff( staffDtoSimpleToStaff( paymentDto.getStaff() ) );
        payment.setCustomer( customerDtoSimpleToCustomer( paymentDto.getCustomer() ) );
        payment.setRental( rentalDtoSimpleToRental( paymentDto.getRental() ) );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );
        payment.setLastUpdate( paymentDto.getLastUpdate() );

        return payment;
    }

    @Override
    public PaymentDto toDto(Payment payment) {
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
        customer = customerToCustomerDtoSimple( payment.getCustomer() );
        rental = rentalToRentalDtoSimple( payment.getRental() );
        amount = payment.getAmount();
        paymentDate = payment.getPaymentDate();
        lastUpdate = payment.getLastUpdate();

        PaymentDto paymentDto = new PaymentDto( paymentId, staff, customer, rental, amount, paymentDate, lastUpdate );

        return paymentDto;
    }

    @Override
    public Payment partialUpdate(PaymentDto paymentDto, Payment payment) {
        if ( paymentDto == null ) {
            return payment;
        }

        if ( paymentDto.getPaymentId() != null ) {
            payment.setPaymentId( paymentDto.getPaymentId() );
        }
        if ( paymentDto.getStaff() != null ) {
            if ( payment.getStaff() == null ) {
                payment.setStaff( new Staff() );
            }
            staffDtoSimpleToStaff1( paymentDto.getStaff(), payment.getStaff() );
        }
        if ( paymentDto.getCustomer() != null ) {
            if ( payment.getCustomer() == null ) {
                payment.setCustomer( new Customer() );
            }
            customerDtoSimpleToCustomer1( paymentDto.getCustomer(), payment.getCustomer() );
        }
        if ( paymentDto.getRental() != null ) {
            if ( payment.getRental() == null ) {
                payment.setRental( new Rental() );
            }
            rentalDtoSimpleToRental1( paymentDto.getRental(), payment.getRental() );
        }
        if ( paymentDto.getAmount() != null ) {
            payment.setAmount( paymentDto.getAmount() );
        }
        if ( paymentDto.getPaymentDate() != null ) {
            payment.setPaymentDate( paymentDto.getPaymentDate() );
        }
        if ( paymentDto.getLastUpdate() != null ) {
            payment.setLastUpdate( paymentDto.getLastUpdate() );
        }

        return payment;
    }

    @Override
    public Payment toEntity1(PaymentDtoSimple paymentDtoSimple) {
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

    @Override
    public PaymentDtoSimple toDto1(Payment payment) {
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

    @Override
    public Payment partialUpdate1(PaymentDtoSimple paymentDtoSimple, Payment payment) {
        if ( paymentDtoSimple == null ) {
            return payment;
        }

        if ( paymentDtoSimple.getPaymentId() != null ) {
            payment.setPaymentId( paymentDtoSimple.getPaymentId() );
        }
        if ( paymentDtoSimple.getAmount() != null ) {
            payment.setAmount( paymentDtoSimple.getAmount() );
        }
        if ( paymentDtoSimple.getPaymentDate() != null ) {
            payment.setPaymentDate( paymentDtoSimple.getPaymentDate() );
        }
        if ( paymentDtoSimple.getLastUpdate() != null ) {
            payment.setLastUpdate( paymentDtoSimple.getLastUpdate() );
        }

        return payment;
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

    protected void rentalDtoSimpleToRental1(RentalDtoSimple rentalDtoSimple, Rental mappingTarget) {
        if ( rentalDtoSimple == null ) {
            return;
        }

        if ( rentalDtoSimple.getRentalId() != null ) {
            mappingTarget.setRentalId( rentalDtoSimple.getRentalId() );
        }
        if ( rentalDtoSimple.getRentalDate() != null ) {
            mappingTarget.setRentalDate( rentalDtoSimple.getRentalDate() );
        }
        if ( rentalDtoSimple.getReturnDate() != null ) {
            mappingTarget.setReturnDate( rentalDtoSimple.getReturnDate() );
        }
        if ( rentalDtoSimple.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( rentalDtoSimple.getLastUpdate() );
        }
    }
}
