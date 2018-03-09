/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZamowieniaIPosilki;

import java.util.Random;

/**
 *
 * @author Anka
 */

public abstract class Restauracja {
    private String nazwaPosilku;
    private String rozmiarPorcji;//dziecieca mala duza
    private int czasPrzygotowania;
    private int cena;
    private final String[] nazwy={"Wściekły Pies","Szybki Bolek","Zezowate szczęście","Śmietnik leśniczego","Kurcze blade","Mamałyga","Litość kucharza","Pomyja","Dzika plaża"};
    /**
     * Konstruktor restauracji
     */
    public Restauracja(){
        Random r=new Random();
        int w=r.nextInt(3);
        if(w==0){
        this.rozmiarPorcji="Mała";
        this.czasPrzygotowania=r.nextInt(20)+5;}
        else if(w==1){
            this.rozmiarPorcji="Duża";
            this.czasPrzygotowania=r.nextInt(20)+10;
        }
        else if(w==2){
            this.rozmiarPorcji="Dziecięca";
            this.czasPrzygotowania=r.nextInt(15)+10;
        }
        
        this.cena=r.nextInt(50)+10;
        int n=r.nextInt(nazwy.length);
        this.nazwaPosilku=nazwy[n];
    }
    /**
     * Zwraca nazwe 
     * @return nazwa
     */
    public String getNazwaPosilku() {
        return nazwaPosilku;
    }
/**
 * Zwraca cene 
 * @return cena
 */
    public int getCena() {
        return cena;
    }

  
/**
 * Zwraca rozmiar porcji
 * @return rozmiar 
 */
    public String getRozmiarPorcji() {
        return rozmiarPorcji;
    }


/**
 * Zwraca czas przygotowania
 * @return czas przygotowania
 */
    public int getCzasPrzygotowania() {
        return czasPrzygotowania;
    }
/**
 * ustawia cene
 * @param cena 
 */
    public void setCena(int cena) {
        this.cena = cena;
    }
/**
 * Zwraca nazwy posilkow
 * @return nazwy
 */
    public String[] getNazwy() {
        return nazwy;
    }
/**
 * Ustawia nazwe posilku
 * @param nazwaPosilku 
 */
    public void setNazwaPosilku(String nazwaPosilku) {
        this.nazwaPosilku = nazwaPosilku;
    }
/**
 * Ustawia rozmiar porcji
 * @param rozmiarPorcji 
 */
    public void setRozmiarPorcji(String rozmiarPorcji) {
        this.rozmiarPorcji = rozmiarPorcji;
    }
/**
 * Ustawia czas przygotowania
 * @param czasPrzygotowania 
 */
    public void setCzasPrzygotowania(int czasPrzygotowania) {
        this.czasPrzygotowania = czasPrzygotowania;
    }

  
   
}
