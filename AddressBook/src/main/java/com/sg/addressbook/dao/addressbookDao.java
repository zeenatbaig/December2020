/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author zeenatbaig
 */
public interface addressbookDao {
   
    Address addAddress(int referenceNum, Address  address);
    
    Address getAddress(int referenceNum);
    
    List<Address> getAllAddresses();
    
    Address removeAddress(int referenceNum);
    
    Address editAddress(int referenceNum, Address address );
    
    List<Integer> getRefNumFromLastName(String lastname);
    
    int generateNewRef();
    
    int getAdressCount();
    
    
}