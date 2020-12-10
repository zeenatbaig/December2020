/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreStateCapitals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author zeenatbaig
 */
public class StateCapitalApp {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Capital> stateCapitals = new HashMap<>();
        Scanner scUser = new Scanner(System.in);
        Scanner sc = new Scanner(
                new BufferedReader(new FileReader("MoreStateCapitals.txt")));
// go through the file line by line

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            String[] capitalArray = currentLine.split("::");

            Capital capitalFromTxt = new Capital();
            capitalFromTxt.setName(capitalArray[1]);
            int population = Integer.parseInt(capitalArray[2]);
            capitalFromTxt.setPopulation(population);
            capitalFromTxt.setSquareMileage(Double.parseDouble(capitalArray[3]));

            stateCapitals.put(capitalArray[0], capitalFromTxt);
        }

        Set<String> states = stateCapitals.keySet();

        for (String s : states) {
            System.out.println(s + stateCapitals.get(s));
        }

        System.out.println("Please enter the lower limit for capital city population");
        int lowerLimit = scUser.nextInt();

      
        for (String s : states) {
            Capital c = stateCapitals.get(s);
            if (c.population > lowerLimit) {
                System.out.println(s + stateCapitals.get(s));
            }
        }
        
        
        System.out.println("Please enter the upper limit for the capital city sq mileage");
        int upperLimit = scUser.nextInt();

      
        for (String s : states) {
            Capital c = stateCapitals.get(s);
            if (c.squareMileage < upperLimit) {
                System.out.println(s + stateCapitals.get(s));
            }
        }

    }

}
