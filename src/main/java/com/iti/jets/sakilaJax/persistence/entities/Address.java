// default package
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
 * Address generated by hbm2java
 */
@Entity
@Table(name="address"
    ,catalog="sakila"
)
public class Address  implements java.io.Serializable {


     private Short addressId;
     private City city;
     private String address;
     private String address2;
     private String district;
     private String postalCode;
     private String phone;
     private byte[] location;
     private Timestamp lastUpdate;
     private Set <Staff> staffs = new HashSet(0);
     private Set<Customer> customers = new HashSet(0);
     private Set<Store> stores = new HashSet(0);

    public Address() {
    }

	
    public Address(City city, String address, String district, String phone, byte[] location, Timestamp lastUpdate) {
        this.city = city;
        this.address = address;
        this.district = district;
        this.phone = phone;
        this.location = location;
        this.lastUpdate = lastUpdate;
    }
    public Address(City city, String address, String address2, String district, String postalCode, String phone, byte[] location, Timestamp lastUpdate, Set <Staff> staffs, Set<Customer> customers, Set<Store> stores) {
       this.city = city;
       this.address = address;
       this.address2 = address2;
       this.district = district;
       this.postalCode = postalCode;
       this.phone = phone;
       this.location = location;
       this.lastUpdate = lastUpdate;
       this.staffs = staffs;
       this.customers = customers;
       this.stores = stores;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="address_id", unique=true, nullable=false)
    public Short getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="city_id", nullable=false)
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }

    
    @Column(name="address", nullable=false, length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="address2", length=50)
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    
    @Column(name="district", nullable=false, length=20)
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }

    
    @Column(name="postal_code", length=10)
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    
    @Column(name="phone", nullable=false, length=20)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="location", nullable=false)
    public byte[] getLocation() {
        return this.location;
    }
    
    public void setLocation(byte[] location) {
        this.location = location;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=19)
    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }
    
    public void setStaffs(Set <Staff> staffs) {
        this.staffs = staffs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public Set<Customer> getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="address")
    public Set<Store> getStores() {
        return this.stores;
    }
    
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }




}

