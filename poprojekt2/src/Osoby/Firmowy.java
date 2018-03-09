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
public class Firmowy extends Klient {
    private int[] kontoBankowe=new int[11];
    private int REGON;
 /**
  * Konstruktor klienta firmowego
  * @param nr
  * @param wspolx
  * @param wspoly
  * @param menu 
  */
  public Firmowy(int nr,int wspolx,int wspoly,Obsluga menu){
      super(nr,wspolx,wspoly,menu);
      Random r=new Random();
      this.REGON=r.nextInt(899999999)+100000000;
      for (int x=0;x<=kontoBankowe.length;x++)
      this.kontoBankowe[x]=r.nextInt(8)+1;
  }
/**
 * Zwraca numer konta bankowego
 * @return numer konta bankowego
 */
    public int[] getKontoBankowe() {
        return kontoBankowe;
    }
/**
 * ustawia numer konta bankowego
 * @param kontoBankowe 
 */
    public void setKontoBankowe(int[] kontoBankowe) {
        this.kontoBankowe = kontoBankowe;
    }
/**
 * Zwraca REGON
 * @return REGON
 */
    public int getREGON() {
        return REGON;
    }
/**
 * ustawia REGON
 * @param REGON 
 */
    public void setREGON(int REGON) {
        this.REGON = REGON;
    }
  
}
