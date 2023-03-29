// default package
package com.myJax.persistence.entities;
// Generated 29 Mar 2023, 11:12:20 by Hibernate Tools 6.1.7.Final


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * CustomerListId generated by hbm2java
 */
@Embeddable
public class CustomerListId  implements java.io.Serializable {


     private String address;
     private String city;
     private String country;
     private short id;
     private String name;
     private String notes;
     private String phone;
     private byte sid;
     private String zipCode;

    public CustomerListId() {
    }

	
    public CustomerListId(String address, String city, String country, short id, String notes, String phone, byte sid) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.id = id;
        this.notes = notes;
        this.phone = phone;
        this.sid = sid;
    }
    public CustomerListId(String address, String city, String country, short id, String name, String notes, String phone, byte sid, String zipCode) {
       this.address = address;
       this.city = city;
       this.country = country;
       this.id = id;
       this.name = name;
       this.notes = notes;
       this.phone = phone;
       this.sid = sid;
       this.zipCode = zipCode;
    }
   


    @Column(name="address", nullable=false, length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }


    @Column(name="city", nullable=false, length=50)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }


    @Column(name="country", nullable=false, length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }


    @Column(name="ID", nullable=false)
    public short getId() {
        return this.id;
    }
    
    public void setId(short id) {
        this.id = id;
    }


    @Column(name="name", length=91)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="notes", nullable=false, length=6)
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }


    @Column(name="phone", nullable=false, length=20)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name="SID", nullable=false)
    public byte getSid() {
        return this.sid;
    }
    
    public void setSid(byte sid) {
        this.sid = sid;
    }


    @Column(name="zip code", length=10)
    public String getZipCode() {
        return this.zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CustomerListId) ) return false;
		 CustomerListId castOther = ( CustomerListId ) other; 
         
		 return ( (this.getAddress()==castOther.getAddress()) || ( this.getAddress()!=null && castOther.getAddress()!=null && this.getAddress().equals(castOther.getAddress()) ) )
 && ( (this.getCity()==castOther.getCity()) || ( this.getCity()!=null && castOther.getCity()!=null && this.getCity().equals(castOther.getCity()) ) )
 && ( (this.getCountry()==castOther.getCountry()) || ( this.getCountry()!=null && castOther.getCountry()!=null && this.getCountry().equals(castOther.getCountry()) ) )
 && (this.getId()==castOther.getId())
 && ( (this.getName()==castOther.getName()) || ( this.getName()!=null && castOther.getName()!=null && this.getName().equals(castOther.getName()) ) )
 && ( (this.getNotes()==castOther.getNotes()) || ( this.getNotes()!=null && castOther.getNotes()!=null && this.getNotes().equals(castOther.getNotes()) ) )
 && ( (this.getPhone()==castOther.getPhone()) || ( this.getPhone()!=null && castOther.getPhone()!=null && this.getPhone().equals(castOther.getPhone()) ) )
 && (this.getSid()==castOther.getSid())
 && ( (this.getZipCode()==castOther.getZipCode()) || ( this.getZipCode()!=null && castOther.getZipCode()!=null && this.getZipCode().equals(castOther.getZipCode()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getAddress() == null ? 0 : this.getAddress().hashCode() );
         result = 37 * result + ( getCity() == null ? 0 : this.getCity().hashCode() );
         result = 37 * result + ( getCountry() == null ? 0 : this.getCountry().hashCode() );
         result = 37 * result + this.getId();
         result = 37 * result + ( getName() == null ? 0 : this.getName().hashCode() );
         result = 37 * result + ( getNotes() == null ? 0 : this.getNotes().hashCode() );
         result = 37 * result + ( getPhone() == null ? 0 : this.getPhone().hashCode() );
         result = 37 * result + this.getSid();
         result = 37 * result + ( getZipCode() == null ? 0 : this.getZipCode().hashCode() );
         return result;
   }   


}


