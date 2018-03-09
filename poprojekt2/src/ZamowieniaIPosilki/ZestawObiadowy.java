/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZamowieniaIPosilki;

import ZamowieniaIPosilki.Restauracja;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Anka
 */
public class ZestawObiadowy extends Restauracja {
    private ArrayList <Restauracja> posilki=new ArrayList<>();
    private int znizka=15;
    
/**
 * Konstruktor zestawu obiedowego
 * @param menu 
 */
    public ZestawObiadowy(MenuPosilkow menu) {
        setCena(przeliczCene());
        this.posilki=stworzZestaw(menu);
        
 
    }
    /**
     * Prywatna metoda tworzaca zestaw
     * @param menu
     * @return zestaw
     */
   private ArrayList<Restauracja> stworzZestaw(MenuPosilkow menu){
       ArrayList <Restauracja> lista=new ArrayList<>();
       for(int i=0;i<=1;i++){//dwa dania
          Random r=new Random(); 
          int a=r.nextInt(menu.getMenu().size());
          lista.add(menu.getMenu().get(a));
       }
       return lista;
   }
  /**
   * Metoda obliczajaca cene zestawu
   * @return cena 
   */
    private int przeliczCene()  {
        int wartosc=0;
        
        for(Restauracja z:posilki){ 
        wartosc+=z.getCena();
        }
        wartosc=wartosc/znizka;
        return wartosc;
        } 
/**
 * Zwraca liste posilkow
 * @return lista posilkow
 */
    public ArrayList<Restauracja> getPosilki() {
        return posilki;
    }
/**
 * Ustawia liste posilkow
 * @param posilki 
 */
    public void setPosilki(ArrayList<Restauracja> posilki) {
        this.posilki = posilki;
    }
/**
 * Zwraca znizke
 * @return znizka
 */
    public int getZnizka() {
        return znizka;
    }
/**
 * Ustawia znizke
 * @param znizka 
 */
    public void setZnizka(int znizka) {
        this.znizka = znizka;
    }
    
}

