/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZamowieniaIPosilki;

import ZamowieniaIPosilki.Restauracja;
import java.util.ArrayList;

/**
 *
 * @author Anka
 */
public class MenuPosilkow  {
    private ArrayList <Restauracja> menu;
    /**
     * Konstruktor menu posilkow
     */
    public MenuPosilkow(){
        this.menu=new ArrayList();
    }
   /**
    * Metoda wyswietlajaca menu
    * @return menu
    */
    public String wyswietlMenu(){
        String mojeM =" ";
        for (int i = 0; i < menu.size(); i++) {
            mojeM+=(menu.get(i)).getNazwaPosilku();
            mojeM+='\n';
        }  
    return mojeM;
    }
    /**
     * Metoda dodajca nowy posilke do menu
     * @param nowy 
     */
    public void dodajPosilek(Restauracja nowy){
        menu.add(nowy);
    }
    /**
     * Metoda usuwajaca posilek z menu
     * @param usunposilek
     */
    public void usunPosilek(Restauracja usunposilek){
        menu.remove(usunposilek);
    }
/**
 * Metoda zwracajaca menu
 * @return menu
 */
    public ArrayList<Restauracja> getMenu() {
        return menu;
    }
/**
 * ustawia menu
 * @param menu 
 */
    public void setMenu(ArrayList<Restauracja> menu) {
        this.menu = menu;
    }
    
}