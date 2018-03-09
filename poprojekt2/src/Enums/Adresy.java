/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 * @author Anka
 * Enum z nazwami ulic 
 */
public enum Adresy {
    Długa,Krótka,Kolejowa,Dworcowa,Czarna,Biała,Zakładowa,Polna,Przemysłowa,Zielona,Akacjowa,Leśna,Stroma,Wąska;

    /**
     *
     * @return String
     */
    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }
}
