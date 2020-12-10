/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.ui;

import com.sg.addressbook.dao.addressbookDao;
import com.sg.addressbook.dao.addressbookDaoFileImpl;
import com.sg.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author zeenatbaig
 */
public class AddressBookView {

    private UserIO io;
    private addressbookDao dao = new addressbookDaoFileImpl();

    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Please Select the Operation you wish to perform ");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Adresses");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices ", 1, 6);
    }

    public Address getNewAddress() {
        String firstName = io.readString("Please Enter First Name:");

        String lastName = io.readString("Please Enter Last Name:");

        String address = io.readString("Please Enter Street Address");

        int referenceNum = dao.generateNewRef();

        Address currentAddress = new Address(referenceNum);

        currentAddress.setFirstName(firstName);
        currentAddress.setLastName(lastName);
        currentAddress.setReferenceNum(referenceNum);
        currentAddress.setStreetAddress(address);

        return currentAddress;

    }

    public void displayDVDList(List<Address> AddressBook) {
        for (Address currentAddress : AddressBook) {
            String adressInfo = String.format("%s %s %s",
                    currentAddress.getFirstName(),
                    currentAddress.getLastName(),
                    currentAddress.getStreetAddress());
            io.print(adressInfo);
        }

        io.readString("Please hit enter to continue");

    }

    public void displayAllBanner() {
        io.print("List Address Menu");
    }

    public void displayCountBanner() {
        io.print("List Address Count Menu");
    }
    
      public void displayFindBanner() {
        io.print("Find Address Menu");
    }
     
       public void displayDeleteBanner() {
        io.print("Delete Address Menu");
    }

}
