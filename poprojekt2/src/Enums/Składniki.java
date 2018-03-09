/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Anka
 * Enum z składnikami
 */
public enum Składniki {
 MĄKA,MLEKO,JAJA,WODA,MIĘSO,WARZYWA,PRZYPRAWY,KURCZAK,RYŻ,OLEJ,SOS,SER,SOK,COLA,ALKOHOL;   
 /**
  * 
  * @return string 
  */
 @Override
      public String toString(){
        return super.toString().toLowerCase();
    }
}
