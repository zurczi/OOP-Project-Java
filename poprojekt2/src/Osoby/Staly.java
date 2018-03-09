/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;

import Osoby.Klient;
import poprojekt2.Obsluga;

/**
 *
 * @author Anka
 */
public class Staly extends Klient {
    private int znizka;
    private int pktLojalnosciowe;
/**
 * Konstruktor klienta stalego
 * @param nr
 * @param znizka
 * @param wspolx
 * @param wspoly
 * @param menu 
 */
    public Staly( int nr,int znizka,int wspolx,int wspoly,Obsluga menu) {
        super( nr,wspolx,wspoly,menu);
        this.znizka=znizka;
        this.pktLojalnosciowe=0;
    }
    /**
     * Metoda zmieniajace wartosc punktow lojalnosciowych
     * @param wartosc 
     */
    @Override
    public void zmianaPkt(int wartosc){
        this.pktLojalnosciowe+=wartosc;
    }
/**
 * Zwraca znizke
 * @return znizka
 */
    public int getZnizka() {
        return znizka;
    }
/**
 * ustawia znizke
 * @param znizka 
 */
    public void setZnizka(int znizka) {
        this.znizka = znizka;
    }
/**
 * Zwraca punkty lojalnosciowe
 * @return pkt lojalnosciowe
 */
   
/**
 * ustawia punkty lojalnosciowe
 * @param pktLojalnosciowe 
 */
    public void setPktLojalnosciowe(int pktLojalnosciowe) {
        this.pktLojalnosciowe = pktLojalnosciowe;
    }
    
}