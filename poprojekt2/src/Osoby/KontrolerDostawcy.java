/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;

import Osoby.Dostawca;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import poprojekt2.Obsluga;

/**
 *
 * @author Anka
 */
public class KontrolerDostawcy implements EventHandler<MouseEvent> {
private TextArea poleTekstowe;
private Obsluga obsluga;
/**
 * Konstrukotr kontrolera dostawcy
 * @param p
 * @param o 
 */
public KontrolerDostawcy(TextArea p,Obsluga o){
    this.poleTekstowe=p;
    this.obsluga=o;
}
/**
 * Metoda odpowiedzialna za kliknięcie w pole dostawcy
 * @param event 
 */
    @Override
    public void handle(MouseEvent event) {
       
        if(((Node)event.getSource()).getUserData() instanceof Dostawca){
            Dostawca dostawca=(Dostawca)(((Node)event.getSource()).getUserData());
          this.poleTekstowe.clear();
             this.poleTekstowe.appendText(dostawca.getNazwisko()+"\n"+dostawca.getImie()+"\n"+dostawca.getKatPrawaJazdy()+"\n"+dostawca.getPojazdDosatwcy().getPojemnoscBaku()+"\n");
             this.obsluga.setOstatniAktywnyDostawca(dostawca);
        }else
            System.out.println("Błąd");
    }
    
}
    
