/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

import java.util.Random;


/**
 * @author Anka
 *  Enum z dniami tygodnia
 */
public enum DniTygodnia {
    PONIEDZIAŁEK,WTOREK,ŚRODA,CZWARTEK,PIĄTEK;
    
    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }}
    
  