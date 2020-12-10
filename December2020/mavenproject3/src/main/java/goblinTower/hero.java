/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goblinTower;

import java.util.Random;

/**
 *
 * @author zeenatbaig
 */
public class hero {
     int heath, randomAttack,randomDefence, gold;
     int[] potions;
     Random randomizer = new Random();
     
     
    public int[] getPotions() {
        return potions;
    }

    public void setPotions(int[] potions) {
        this.potions = potions;
    }
     
     
     
    public int getHeath() {
        return heath;
    }

    public void setHeath(int heath) {
        this.heath = heath;
    }

    public int getRandomAttack() {
        return randomAttack;
    }

    public void setRandomAttack(int randomAttack) {
        this.randomAttack = randomAttack;
    }

    public int getRandomDefence() {
        return randomDefence;
    }

    public void setRandomDefence(int randomDefence) {
        this.randomDefence = randomDefence;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    public int startHealth(){
        return randomizer.nextInt(30-20) + 20;
    }
     
     public int startAttackPower(){
        return randomizer.nextInt(3-1) + 1;
    }
     
       public int startDefencePower(){
        return randomizer.nextInt(3-1) + 1;
    }
    
        public int[] startPotions() {
        int[] startPotion = {2,2,2,2,2};
        return startPotion;
    }
        
        

    @Override
    public String toString() {
        return "You're Character Starts with " + "\nheath: " + heath + "\nrandomAttack: " + randomAttack + "\nrandomDefence: " + randomDefence + "\ngold: " + gold + "\npotions: 5"   ;
    }
        
        
     
}
