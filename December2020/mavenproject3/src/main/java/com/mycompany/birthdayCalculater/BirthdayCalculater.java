/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.birthdayCalculater;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author zeenatbaig
 */
public class BirthdayCalculater {
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
       String birthday;
       LocalDate readDate, present, today;
       String DayPast, DayPresent, daysUntil,DayToday, todayString, year;
       int age, yearInt;
       
       DateTimeFormatter fullformatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        
       today = LocalDate.now();
       
     
        todayString = today.format(fullformatter);
       
       System.out.println("Welcome to the 100% Scientifically Accurate Birthday Calculator! \n \n"+
               "\n What's your birthday? in the format mm-dd-yyyy");
     birthday = sc.nextLine();
       // birthday = "03-01-1997";
      
       
       readDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
       
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
       DayPast = readDate.format(formatter);
       
       
       DateTimeFormatter yearformatter = DateTimeFormatter.ofPattern("uuuu");
        year = readDate.format(yearformatter);
        
        yearInt = Integer. parseInt(year);
        
        age = 2020 - yearInt;
       
      
       DateTimeFormatter formatterPresent = DateTimeFormatter.ofPattern("MM-dd-2020");
       DayToday = readDate.format(formatterPresent);
       
        
       present = LocalDate.parse(DayToday, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
       DayPresent = present.format(formatter);
       
       Period diff = today.until(present);
        int days = diff.getDays();
       
       System.out.println("That means you were born on a " + DayPast+"!"+ "\n  This year it falls on a " + DayPresent 
               + "\n And since today is " + todayString + " there's only more "+ days + " days until the next one when you turn " +age+ " !");
        
        
    }
}
