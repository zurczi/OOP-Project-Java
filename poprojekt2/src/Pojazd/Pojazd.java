/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojazd;
/**
 *
 * @author Anka
 */
public abstract class Pojazd  {
    private  int ladownosc;
    private  int predkosc;
    private int nrRjestracyjny;
    private  double pojemnoscBaku;
    /**
     * Konstruktor pojazdu
     * @param lad
     * @param pred
     * @param nr
     * @param pojem 
     */
    public Pojazd(int lad,int pred,int nr,double pojem){
        this.ladownosc=lad;
        this.predkosc=pred;
        this.nrRjestracyjny=nr;
        this.pojemnoscBaku=pojem;
  
    }
/**
 * ustawia ladownosc
 * @param ladownosc 
 */
    public void setLadownosc(int ladownosc) {
        this.ladownosc = ladownosc;
    }
/**
 * Ustawia predkosc
 * @param predkosc 
 */
    public void setPredkosc(int predkosc) {
        this.predkosc = predkosc;
    }
/**
 * ustawia numer rejestracyjny
 * @param nrRjestracyjny 
 */
    public void setNrRjestracyjny(int nrRjestracyjny) {
        this.nrRjestracyjny = nrRjestracyjny;
    }
    
/**
 * Ustawia pojemnosc baku
 * @param pojemnoscBaku 
 */
    public void setPojemnoscBaku(double pojemnoscBaku) {
        this.pojemnoscBaku = pojemnoscBaku;
    }
/**
 * Zwraca ladownosc pojazdu
 * @return ladownosc
 */
    public int getLadownosc() {
        return ladownosc;
    }
/**
 * Zwraca predkosc
 * @return predkosc
 */
    public int getPredkosc() {
        return predkosc;
    }
/**
 * Zwraca numer rejestracyjny
 * @return numer rejestracyjny
 */
    public int getNrRjestracyjny() {
        return nrRjestracyjny;
    }
/**
 * Zwraca pojemnosc baku
 * @return pojemnosc baku
 */
    public double getPojemnoscBaku() {
        return pojemnoscBaku;
    }


    
}