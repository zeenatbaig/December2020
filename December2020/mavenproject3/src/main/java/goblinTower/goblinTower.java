/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goblinTower;

import static java.lang.System.console;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zeenatbaig
 */
public class goblinTower {

    public static void main(String[] args) {
        
        int step;
        
        Random randomizer = new Random();
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Welcome to Goblin Tower!!!"
                + "\n =============================");

        System.out.println("\n \n \n Lets start with your chracter");

        hero character = new hero();
        int startAttackPower = character.startAttackPower();
        int startDefencePower = character.startDefencePower();
        int startHealth = character.startHealth();
        int[] startPotions = character.startPotions();

        character.setGold(0);

        character.setHeath(startHealth);
        character.setPotions(startPotions);
        character.setRandomAttack(startAttackPower);
        character.setRandomDefence(startDefencePower);

        System.out.println(character);
        
        System.out.println("");
        
        
      Scanner console = new Scanner(System.in);
         System.out.println("Please press enter to take a step");
         console.nextLine();
    }

}
