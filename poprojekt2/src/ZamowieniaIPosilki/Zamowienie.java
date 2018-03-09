/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZamowieniaIPosilki;

import ZamowieniaIPosilki.Restauracja;
import Osoby.Klient;
import java.util.ArrayList;
import java.util.Random;



/**
 *
 * @author Anka
 */
public class Zamowienie {
    private ArrayList <Restauracja> zamowioneDania;
    private  int cena;
    private  int cenaDowozu;
    private  Klient klient;
    /**
     * Konstruktor zamowienia
     * @param skladajacy
     * @param menu 
     */
    public Zamowienie(Klient skladajacy,MenuPosilkow menu){
        this.zamowioneDania = new ArrayList<>();
    this.zamowioneDania=wylosujZamowienie(menu);
    this.klient=skladajacy;
    this.cena=sumaCen();
    this.cenaDowozu=obliczDowoz();
    }

    /**
     * Ustawia cene zamowienia
     * @param cena 
     */
    public void setCena(int cena){
       
        this.cena = cena;
}
/**
 * Ustawia cene dowozu
 * @param cenaDowozu 
 */
    public void setCenaDowozu(int cenaDowozu) {
        this.cenaDowozu = cenaDowozu;
    }

    /**
     * Ustawia klienta
     * @param klient 
     */
    public void setKlient(Klient klient) {
        this.klient = klient;
    }
/**
     * Metoda obliczajaca koszt dowozu
     * @return koszt dowozu
     */
    private int obliczDowoz() {
        int x=this.klient.getX();
        int y=this.klient.getY();
        double odl=Math.sqrt((Math.pow((x-189),2))+(Math.pow((y-189),2)));
        int kilometry=(int)(odl*0.5); //50 gr za kilometr
        return kilometry;
    }
    /**
     * Metoda prywatna losujaca zamowienie
     * @param mojeMenu
     * @return zamowienie
     */
    private ArrayList wylosujZamowienie(MenuPosilkow mojeMenu){
        ArrayList<Restauracja> zamowienie=new ArrayList<>();
        Random rozmiarZamowienia=new Random();
        if(mojeMenu.getMenu().size()>0){
        for (int x=0;x<rozmiarZamowienia.nextInt(mojeMenu.getMenu().size());x++){
            int nrDania=rozmiarZamowienia.nextInt(mojeMenu.getMenu().size());
            Restauracja danie=(Restauracja) mojeMenu.getMenu().get(nrDania);
            zamowienie.add(danie);
        }
        }
        return zamowienie;
    }
    /**
     * Metoda sumujaca cene dowozu i zamowienia
     * @return suma cen
     */
    private int sumaCen(){
        int kasa = 0;
        for(Restauracja r :zamowioneDania){
           kasa+=r.getCena();
        }
        return kasa;
    }
/**
 * Zwraca zamowione dania
 * @return zamowione dania
 */
    public ArrayList<Restauracja> getZamowioneDania() {
        return zamowioneDania;
    }
/**
 * Zwraca cene
 * @return cena
 */
    public int getCena() {
        return cena;
    }

/**
 * Zwraca cene dowozu
 * @return cena dowozu
 */
    public int getCenaDowozu() {
        return cenaDowozu;
    }
/**
 * Zwraca klienta 
 * @return klient
 */
    
    public Klient getKlient() {
        return klient;
    }
/**
 * Zwraca liste zamowionych dan
 * @param zamowioneDania 
 */
    public void setZamowioneDania(ArrayList<Restauracja> zamowioneDania) {
        this.zamowioneDania = zamowioneDania;
    }
    
}