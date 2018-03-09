/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;

import Enums.Nazwiska;
import Enums.Adresy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
//import projektpo2.Dostawca;
import poprojekt2.Obsluga;
import ZamowieniaIPosilki.Zamowienie;

/**
 *
 * @author Anka
 */

public class Klient extends Thread  {
    private String nazwa;
    private int nrKlienta;
    private int nrTel;
    private String adresDostawy;
    private int x;
    private int y; //wspolrzedne na mapie
    private Obsluga obsluga;
    private ImageView obrazek;
    private Thread watek;
/**
 * Zwraca watek klienta
 * @return watek
 */
    public Thread getWatek() {
        return watek;
    }
/**
 * Ustawia watek klienta
 * @param watek 
 */
    public void setWatek(Thread watek) {
        this.watek = watek;
    }
/**
 * Konstruktor losowy klienta
 * @param nr
 * @param wspolx
 * @param wspoly
 * @param m 
 */
    
public Klient(int nr,int wspolx,int wspoly,Obsluga m){
    this.adresDostawy=wylosujAdres();
    this.nazwa=wylosujNazwe();
    this.nrKlienta=nr;
    this.nrTel=wylosujNrTel();
    this.x=wspolx;
    this.y=wspoly;
    this.obsluga=m;
}
/**
 * Prywatna metoda losujaca adres klienta
 * @return adres
 */
private String wylosujAdres(){
       String adres="";
     Random r=new Random();
    ArrayList <Adresy> tab=new ArrayList();
    tab.addAll(Arrays.asList(Adresy.values()));
        int wylosowana=r.nextInt(tab.size());
        adres+=tab.get(wylosowana).toString();
        adres+=" ";
      int nr=r.nextInt(30)+1;
      adres+=nr;
     return adres;  }
/**
 * Metoda prywatna losujaca numer telefonu klienta
 * @return numer telefonu
 */
private int wylosujNrTel(){
    Random r=new Random();
    int nr=r.nextInt(899999999)+100000000;
    return nr;
}
/**
 * Prywatna metoda losujaca nazwe klienta
 * @return nazwa 
 */
private String wylosujNazwe(){
      String na="";
     Random r=new Random();
    ArrayList <Nazwiska> tab=new ArrayList();
    tab.addAll(Arrays.asList(Nazwiska.values()));
        int wylosowana=r.nextInt(tab.size());
        na+=tab.get(wylosowana).toString(); 
     return na; 
 }
/**
 * Zwraca nazwe
 * @return nazwa
 */
    public String getNazwa() {
        return nazwa;
    }
/**
 * ustawia nazwe
 * @param nazwa 
 */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
/**
 * Zwraca numer klienta
 * @return numer klienta
 */
    public int getNrKlienta() {
        return nrKlienta;
    }
/**
 * Ustawia numer klienta
 * @param nrKlienta 
 */
    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }
/**
 * Zwraca numer telefonu klienta
 * @return numer telefonu
 */
    public int getNrTel() {
        return nrTel;
    }
/**
 * Zwraca adres dostawy
 * @return adres
 */
    public String getAdresDostawy() {
        return adresDostawy;
    }
/**
 * Zwraca pole x
 * @return x
 */
   
    public int getX() {
        return x;
    }
/**
 * Zwracaa pole y
     * @return y
    */
    public int getY() {
        return y;
    }
/**
 * Zwraca ikone klienta
 * @return ikona
 */
    public ImageView getObrazek() {
        return obrazek;
    }
    /**
     * Metoda rysujaca klienta na mapie
     * @param mapa 
     */
public void rysujNaMapie(AnchorPane mapa){
    this.obrazek=new ImageView();
    if(Files.notExists(Paths.get("src/Obrazki/klient.png"))){
        System.out.println("Plik nie istneieje");
    }
    obrazek.setImage(new Image("file:src/Obrazki/klient.png"));
    obrazek.setLayoutX(this.x);
    obrazek.setLayoutY(this.y);
    obrazek.setUserData(this);
    mapa.getChildren().add(obrazek);
}

    /**
     * Przyslonieta metoda
     *Zmienia punkty lojalnosciowe dla klienta stalego
     * @param wartosc
     */
    public void zmianaPkt(int wartosc){
    
    }

    /**
     *Przyslonieta metoda
     * Zwraca punkty lojalnosciowe kleinta stalego
     * @return pkt lojalnosciowe
     */
    public int getPktLojalnosciowe() {
      return 0;  
    }

    /**
     *Przyslonieta metoda 
     * Zwraca znizke klienta stalego
     * @return znizka
     */
    public int getZnizka() {
        return 1;
    }
    /**
     * Metoda przyslonieta
     * Ustawia punkty lojalnosciowe
     * @param pktLojalnosciowe 
     */
    public void setPktLojalnosciowe(int pktLojalnosciowe) {
       
    }
    /**
     * Watek kleinta cyklicznie skladajacy zamowienia 
     */
    @Override
    public void run() {
 while(!Thread.currentThread().isInterrupted()){
     try{

  Zamowienie zamowienie=new Zamowienie(this,this.obsluga.getMenu());
        if(this instanceof Staly){
       this.zmianaPkt(5);
       if(this.getPktLojalnosciowe()>100){
         zamowienie.setCena(zamowienie.getCena()*this.getZnizka());
           this.setPktLojalnosciowe(0);
       }
         }
        
     obsluga.noweZamowienie(zamowienie);
                Thread.sleep(5000);
           } catch (InterruptedException ex) {
               Thread.currentThread().interrupt();
 }
 
}
 }
/**
 * Zwraca obsluge
 * @return osbluga
 */
    public Obsluga getObsluga() {
        return obsluga;
    }
/**
 * ustawia obsluge
 * @param obsluga 
 */
    public void setObsluga(Obsluga obsluga) {
        this.obsluga = obsluga;
    }
    
    }