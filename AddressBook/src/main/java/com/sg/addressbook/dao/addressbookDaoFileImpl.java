/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author zeenatbaig
 */
public class addressbookDaoFileImpl implements addressbookDao {

    private final Map<Integer, Address> Addressbook = new HashMap<>();
    
    List<Integer> referenceNums = new ArrayList<>();
    
   private final Map<Integer, String> LastNames = new HashMap<>();
    
    @Override
    public Address addAddress(int referenceNum, Address address) {
        Address prevAddress = Addressbook.put(referenceNum, address);
        return address;
    }

    @Override
    public Address getAddress(int referenceNum) {
        return Addressbook.get(referenceNum);
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<Address>(Addressbook.values());
    }

    @Override
    public Address removeAddress(int referenceNum) {
        Address removedAddress = Addressbook.remove(referenceNum);
        return removedAddress;
        
    }

    @Override
    public Address editAddress(int referenceNum, Address address) {
        Address prevAddress = Addressbook.put(referenceNum,address);
        return prevAddress;
    }

    @Override
    public List<Integer> getRefNumFromLastName(String lastname) {
        List<Integer> RefNums = new ArrayList<>();
        
        Set<Integer> keys = LastNames.keySet();
        
        for (Integer k : keys){
            if(lastname.equals(LastNames.get(k))){
                RefNums.add(k);
            }
        }
        return RefNums;
        
    }

    @Override
    public int generateNewRef() {
           //random generator 
        Random rand = new Random();
        
       
        int n= 1;
        int number = 0;
        
        //finds one number that is not in our list of reference numbers 
        for(int i = 0; i<n; i++){
           
        do number = rand.nextInt(5000);
        while (referenceNums.contains(number));
        
        
        }
        referenceNums.add(number);
        return number;
    }

    @Override
    public int getAdressCount() {
       return Addressbook.size();
    }
    
}
