/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dto;

import java.util.Objects;

/**
 *
 * @author zeenatbaig
 */
public class Address {
    int referenceNum;
    String firstName, lastName, streetAddress;

    public Address(int referenceNum){
        this.referenceNum = referenceNum;
    }
    public int getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(int referenceNum) {
        this.referenceNum = referenceNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.referenceNum;
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.streetAddress);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.referenceNum != other.referenceNum) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "referenceNum=" + referenceNum + ", firstName=" + firstName + ", lastName=" + lastName + ", streetAddress=" + streetAddress + '}';
    }
    
    
}
