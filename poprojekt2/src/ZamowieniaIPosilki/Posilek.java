/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZamowieniaIPosilki;

import ZamowieniaIPosilki.Restauracja;
import Enums.Składniki;
import Enums.Kategorie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Anka
 */
public class Posilek extends Restauracja  {
    private String skladniki;
    private String kategoria;

/**
 * Konstruktor losowy posilku 
 */
    public Posilek() {
        super();
        String kat=wylosujKategorie();
        this.kategoria=kat;
        this.skladniki=wylosujSklad(kat);
    }
    /**
     * Prywatna metoda losujaca kateogorie
     * @return kategoria
     */
    private String wylosujKategorie(){
    String kat="";
    Random r=new Random();
    ArrayList <Kategorie> tab=new ArrayList();
    tab.addAll(Arrays.asList(Kategorie.values()));
        int x=r.nextInt(tab.size());
        kat+=tab.get(x).toString();
        return kat;
    }
    /**
     * Zwraca skladniki
     * @return skladniki
     */
    public String getSkladniki() {
        return skladniki;
    }
/**
 * Zwraca kategorie
 * @return kategoria
 */
    public String getKategoria() {
        return kategoria;
    }
/**
 * Metoda losujaca sklad posilku
 * @param kategoria
 * @return sklad
 */
    private String wylosujSklad(String kategoria) {
       String skład="";
       int x;
       ArrayList <Składniki> tab=new ArrayList();
       tab.addAll(Arrays.asList(Składniki.values()));
        if(kategoria.equalsIgnoreCase("zupy")){
            for(x=3;x<=5;x++){
                 skład+=tab.get(x).toString();
                   skład+=" ";}
       }else if(kategoria.equalsIgnoreCase("desery")){
           for(x=0;x<=2;x++){
               skład+=tab.get(x).toString();
                    skład+=" ";}
       }else if(kategoria.equalsIgnoreCase("obiady")){
           for(x=6;x<=8;x++){
               skład+=tab.get(x).toString();
                skład+=" ";}
          }else if(kategoria.equalsIgnoreCase("pizze")){
            for(x=9;x<=11;x++){
               skład+=tab.get(x).toString();
                     skład+=" ";}
                }else if(kategoria.equalsIgnoreCase("napoje")){
                    for (x=12;x<=14;x++){
                        skład+=tab.get(x).toString();
                        skład+=" ";
                    }
                }
        return skład;
}
/**
 * Ustawia skladniki
 * @param skladniki 
 */
    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }
/**
 * Ustawia kategorie
 * @param kategoria 
 */
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }


}