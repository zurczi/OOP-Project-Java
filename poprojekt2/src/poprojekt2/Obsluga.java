/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poprojekt2;

import Pojazd.Pojazd;
import ZamowieniaIPosilki.MenuPosilkow;
import ZamowieniaIPosilki.Zamowienie;
import Osoby.Dostawca;
import Osoby.Klient;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author Anka
 */
public class Obsluga  {
    private ArrayList <Klient> listaKlientow;
    private ArrayList <Dostawca> listaDostawcow;
    private volatile ArrayList <Zamowienie> aktualneZamowienia;
    private MenuPosilkow menu;
    private volatile ArrayList <Integer> zajetePolaX;
    private volatile ArrayList <Integer> zajetePolaY;
    private Klient ostatniAktywnyKlient;
    private Dostawca ostatniAktywnyDostawca;
    private boolean zajete[][]; 
    /**
     * Zwraca ostatnio kliknietego dostawce
     * @return dostawca
     */
    public Dostawca getOstatniAktywnyDostawca() {
        return ostatniAktywnyDostawca;
    }
/**
 * ustawia ostatniego kliknietego dostawce
 * @param ostatniAktywnyDostawca 
 */
    public void setOstatniAktywnyDostawca(Dostawca ostatniAktywnyDostawca) {
        this.ostatniAktywnyDostawca = ostatniAktywnyDostawca;
    }
/**
 * Zwraca ostatniego kliknietego klienta
 * @return klient
 */
    public Klient getOstatniAktywnyKlient() {
        return ostatniAktywnyKlient;
    }
/**
 * Ustawia ostatnio kliknietego klienta
 * @param ostatniAktywnyKlient 
 */
    public void setOstatniAktywnyKlient(Klient ostatniAktywnyKlient) {
        this.ostatniAktywnyKlient = ostatniAktywnyKlient;
    }
/**
 * Konstruktor obslugi
 */
    public Obsluga(){
        this.zajete = new boolean [400][400];
        this.aktualneZamowienia=new ArrayList();
        this.listaDostawcow=new ArrayList();
        this.listaKlientow=new ArrayList();
        this.menu=new MenuPosilkow();
        this.zajetePolaX=new ArrayList<>();
        this.zajetePolaY=new ArrayList<>();
    }
    /**
     * Metoda dodajaca pole do pol zajetych przez klientow
     * @param x
     * @param y 
     */
   public void dodajPole(int x,int y){
       this.zajetePolaX.add(x);
       this.zajetePolaY.add(y);
   }
/**
 * Metoda zwracajaca tablice pol zajetych przez dostawcow
 * @return pola zajete
 */
    public boolean[][] getZajete() {
        return zajete;
    }
/**
 * Metoda ustawiajaca pole dostawcy jako zajete 
 * @param a
 * @param b 
 */
    public void setZajete(int a,int b) {
        this.zajete[a][b]=true;
    }
    /**
     * Metoda zwalniajaca pole przez dostawce
     * @param a
     * @param b 
     */
     public void zwolnij(int a,int b) {
        this.zajete[a][b]=false;
    }
     /**
      * Metoda sprawdzajaca czy pole jest zajete przez jakiegos dostawce
      * @param a
      * @param b
      * @return 
      */
     public boolean czyzajete(int a ,int b){
         return zajete[a][b];
     }

  /**
   * Metoda czyszczaca liste zamowien
   * @return lista zamowien
   */
    public synchronized ArrayList <Zamowienie> czyscZamowienia(){
    this.aktualneZamowienia.clear();
    return this.aktualneZamowienia;
}
/**
 * Zwraca liste zajetych pol x przez klientow
 * @return lista zajetych x
 */
    public ArrayList<Integer> getZajetePolaX() {
        return zajetePolaX;
    }
/**
 * Zwraca liste zajetych pol y przez klientow
 * @return lista zjaetych y
 */
    public ArrayList<Integer> getZajetePolaY() {
        return zajetePolaY;
    }
 /**
  * Metoda dodajaca zamowienie do listy aktualnych zamowien
  * @param x 
  */
    public void noweZamowienie(Zamowienie x){
    aktualneZamowienia.add(x);
}
/**
 * Zwraca menu
 * @return menu
 */
    public MenuPosilkow getMenu() {
        return menu;
    }
    /**
     * Dodaje nowego klienta do listy klientow
     * @param x 
     */
    public void nowyKlient(Klient x){
    listaKlientow.add(x);
}
    /**
     * Usuwa klienta z listy klientow
     * @param nr 
     */
    public void usunKlienta(int nr){
        for(int i=0;i<listaKlientow.size();i++){
            Klient x=listaKlientow.get(i);
            if(x.getNrKlienta()==nr) {
            listaKlientow.remove(x);
            }
             }
    }
    /**
     * Dodaje nowego dostawce do listy dostawcow
     * @param x 
     */
    public void nowyDostawca(Dostawca x){
        listaDostawcow.add(x);
    }
    /**
     * Usuwa dostawce z listy dostawcow
     * @param nazwisko 
     */
    public void usunDostawce(String nazwisko){
        for(Dostawca c:listaDostawcow){
            if((c.getNazwisko()).equals(nazwisko)){
                listaDostawcow.remove(c);
            }
        }
    }
/**
 * Zwraca liste klientow
 * @return lista klientow
 */

    public ArrayList<Klient> getListaKlientow() {
        return listaKlientow;
    }
/**
 * Zwraca liste dostawcow
 * @return lista dostawcow
 */
    public ArrayList<Dostawca> getListaDostawcow() {
        return listaDostawcow;
    }

   /**
    * Zwraca liste aktualnych zamowien
    * @return lista aktualnych zamowien
    */

    public synchronized ArrayList<Zamowienie> getAktualneZamowienia() {
        return aktualneZamowienia;
    }
    
}