/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MoreStateCapitals;

/**
 *
 * @author zeenatbaig
 */
public class Capital {
    String name ;
    int population;
    Double squareMileage;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Double getSquareMileage() {
        return squareMileage;
    }

    public void setSquareMileage(Double squareMileage) {
        this.squareMileage = squareMileage;
    }

    @Override
    public String toString() {
        return "-"  + name + " | Pop:" + population + " | Area: " + squareMileage +"sq mi";
    }
}
