/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;

import Osoby.Klient;
import java.util.Random;
import poprojekt2.Obsluga;

/**
 *
 * @author Anka
 */
public class Okazjonalny extends Klient {
    private int hZamowienia;
    /**
     * Konstruktor klienta okazjonalnego
     * @param nr
     * @param wspolx
     * @param wspoly
     * @param menu 
     */
 public Okazjonalny(int nr,int wspolx,int wspoly,Obsluga menu){
      super(nr,wspolx,wspoly,menu);
      Random r=new Random();
      this.hZamowienia=r.nextInt(14)+8;
}
/**
 * Zwraca godzine zamowienia
 * @return godzina zamowienia
 */
    public int gethZamowienia() {
        return hZamowienia;
    }
/**
 * Ustawia godzine zamowienia
 * @param hZamowienia 
 */
    public void sethZamowienia(int hZamowienia) {
        this.hZamowienia = hZamowienia;
    }


}
