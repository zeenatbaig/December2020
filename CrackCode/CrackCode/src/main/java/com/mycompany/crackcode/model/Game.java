/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crackcode.model;

/**
 *
 * @author zeenatbaig
 */
public class Game {
   int idGame;
   int answer;
   String status;
   
   public int getIdGame(){
       return idGame;
   }
   
   public void setIdGame(int idGame){
       this.idGame = idGame;
   }
   
      public int getAnswer(){
       return answer;
   }
   
   public void setAnswer(int answer){
       this.answer = answer;
   }
      public String getStatus(){
       return status;
   }
   
   public void setStatus(String status){
       this.status  = status;
   }
}
