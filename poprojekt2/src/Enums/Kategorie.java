/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Anka
 * Enum z kategoriami posiłków
 */
public enum Kategorie {
    ZUPY,DESERY,PIZZE,NAPOJE,OBIADY;
    /**
     * 
     * @return String
     */
    @Override
       public String toString(){
        return super.toString().toLowerCase();
    }
}
