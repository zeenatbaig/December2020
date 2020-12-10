/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author zeenatbaig
 */
public class Capitals {
    public static void main(String[] args) {
        
        
        Map<String, String> stateCapitals = new HashMap<>();
        
        stateCapitals.put("California", "Sacramento");
        stateCapitals.put("New York", "Albany");
        stateCapitals.put("Texas", "Austan");
        stateCapitals.put("California", "Sacramento");
        stateCapitals.put("Illios", "Springfield");
        
        Set<String> states = stateCapitals.keySet();
        
        System.out.println("STATES: \n ========");
        for(String s: states){
            System.out.println(s);
        }
        
        Collection<String> capitals = stateCapitals.values();
        
        System.out.println("\n \n \n CAPITALS: \n ========");
        for(String c: capitals){
            System.out.println(c);
        }
        
         System.out.println("\n \n \n STATE/CAPITAL PAIRS: \n ====================");
        
        for(String s: states){
            System.out.println(s +" - "+ stateCapitals.get(s));
        }
        
        
    }

    @Override
    public String toString() {
        return "Capitals{" + '}';
    }
}
