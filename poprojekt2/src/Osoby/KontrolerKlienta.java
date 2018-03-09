/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;


import Osoby.Klient;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import poprojekt2.Obsluga;

/**
 *
 * @author Anka
 */
public class KontrolerKlienta implements EventHandler<MouseEvent> {
    private TextArea poleTesktowe;
    private Obsluga obsluga;
    /**
     * Konstruktor kontrolera klienta
     * @param p
     * @param o 
     */
    public KontrolerKlienta(TextArea p,Obsluga o){
        this.poleTesktowe=p;
        this.obsluga=o;
    }
    /**
     * Metoda odpowiedzialna za klikniecie na ikone klienta
     * @param event 
     */
    @Override
    public void handle(MouseEvent event) {
        if(((Node)event.getSource()).getUserData() instanceof Klient){
            Klient klient=(Klient)(((Node)event.getSource()).getUserData());
            this.poleTesktowe.clear();
           this.poleTesktowe.appendText(klient.getNazwa()+"\n"+klient.getAdresDostawy()+"\n"+klient.getNrTel()+"\n");
           this.obsluga.setOstatniAktywnyKlient(klient);
        }else
            System.out.println("Nie znaleziono klienta");
    }
    
}
