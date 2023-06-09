package com.iti.jets.sakilaJax.persistence.entities;
// Generated 29 Mar 2023, 11:12:20 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Staff generated by hbm2java
 */
@Entity
@Table(name="staff"
    ,catalog="sakila"
)
public class Staff  implements java.io.Serializable {


     private Short staffId;
     private Store store;
     private Address address;
     private String firstName;
     private String lastName;
     private byte[] picture;
     private String email;
     private boolean active;
     private String username;
     private String password;
     private Timestamp lastUpdate;
     private Set<Payment> payments  = new HashSet(0);
     private Set<Store> stores = new HashSet(0);
     private Set<Rental> rentals = new HashSet(0);

    public Staff() {
    }

	
    public Staff(Store store, Address address, String firstName, String lastName, boolean active, String username, Timestamp lastUpdate) {
        this.store = store;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
        this.username = username;
        this.lastUpdate = lastUpdate;
    }
    public Staff(Store store, Address address, String firstName, String lastName, byte[] picture, String email, boolean active, String username, String password, Timestamp lastUpdate, Set<Payment> payments , Set<Store> stores, Set<Rental> rentals) {
       this.store = store;
       this.address = address;
       this.firstName = firstName;
       this.lastName = lastName;
       this.picture = picture;
       this.email = email;
       this.active = active;
       this.username = username;
       this.password = password;
       this.lastUpdate = lastUpdate;
       this.payments = payments;
       this.stores = stores;
       this.rentals = rentals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="staff_id", unique=true, nullable=false)
    public Short getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(Short staffId) {
        this.staffId = staffId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="store_id", nullable=false)
    public Store getStore() {
        return this.store;
    }
    
    public void setStore(Store store) {
        this.store = store;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable=false)
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }

    
    @Column(name="first_name", nullable=false, length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false, length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="picture")
    public byte[] getPicture() {
        return this.picture;
    }
    
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    
    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="active", nullable=false)
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    
    @Column(name="username", nullable=false, length=16)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", length=40)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(Set<Payment> payments ) {
        this.payments = payments;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Store> getStores() {
        return this.stores;
    }
    
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Rental> getRentals() {
        return this.rentals;
    }
    
    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }




}


