/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poprojekt2;


import ZamowieniaIPosilki.Zamowienie;
import ZamowieniaIPosilki.Posilek;
import ZamowieniaIPosilki.Restauracja;
import Osoby.Staly;
import Osoby.KontrolerDostawcy;
import Osoby.KontrolerKlienta;
import Osoby.Okazjonalny;
import Osoby.Firmowy;
import Osoby.Dostawca;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import Osoby.Klient;
import ZamowieniaIPosilki.ZestawObiadowy;
/**
 *
 * @author Anka
 */
public class FXMLDocumentController implements Initializable {
  private Obsluga obsluga;
  @FXML
  private ImageView ikonaRestauracji;
    @FXML
    private Button dodajKlienta;
    @FXML
    private AnchorPane mapa;
    @FXML
    private Button dodajDostawce;
    @FXML
    private Button dodajPosilek;
    @FXML 
    private TextArea poleTekstowe;
    @FXML 
    private Button dodajZamowienie;
    @FXML
    private Button usunKlienta;
    @FXML 
    private Button usunDostawce;
    @FXML
    private Button powrotDostawcy;
    
    
    
    
    @FXML
    private void handlePowrotDostawcy(ActionEvent event){
        if(!(obsluga.getOstatniAktywnyDostawca()==null)){
           poleTekstowe.clear();
        Dostawca doPowrotu=obsluga.getOstatniAktywnyDostawca();
        doPowrotu.setWroc(true);}
    }
    
    @FXML
    private void handleUsunDostawce(ActionEvent event){
        if(!(obsluga.getOstatniAktywnyDostawca()==null)){
       this.poleTekstowe.clear();
        Dostawca doUsuniecia=obsluga.getOstatniAktywnyDostawca();
        doUsuniecia.getWatek().interrupt();
        doUsuniecia.getObrazek().setOnMouseClicked(null);
        this.mapa.getChildren().remove(doUsuniecia.getObrazek());
        
        obsluga.usunDostawce(doUsuniecia.getNazwisko()); 
    }
    }
    @FXML
    private void handleUsunKlienta(ActionEvent event){
        if(!(obsluga.getOstatniAktywnyKlient()==null)){
     poleTekstowe.clear();
        this.poleTekstowe.clear();
        Klient doUsuniecia=obsluga.getOstatniAktywnyKlient(); 
        doUsuniecia.getObrazek().setOnMouseClicked(null);
        this.mapa.getChildren().remove(doUsuniecia.getObrazek());
        doUsuniecia.getWatek().interrupt();
        obsluga.usunKlienta(doUsuniecia.getNrKlienta()); 
    }}
   
    
    @FXML
     private void handleDodajKlienta(ActionEvent event) {
           poleTekstowe.clear();
        int rozmiar=this.obsluga.getListaKlientow().size();
         int nrk=rozmiar+1;
    Random r =new Random();
    int x=r.nextInt(370)+15;
    int y=r.nextInt(370)+15;
  
     if(!obsluga.getZajetePolaX().isEmpty()){
      while(true){
         if( obsluga.getZajetePolaX().contains(x)||( x>199&&  x<236) ){
             x=r.nextInt(370)+15;
         }else {
             break;}}
      while (true){
          if( obsluga.getZajetePolaY().contains(y) || (y>199 &&y<236)){
             y=r.nextInt(370)+15;
         }else {
             break;}}
      }
     Klient nowyKlient;

     int rodzajKlienta=r.nextInt(2);
     if(rodzajKlienta==0){
            nowyKlient=new Staly(nrk,10,x,y,obsluga);
            obsluga.nowyKlient(nowyKlient);
            nowyKlient.rysujNaMapie(mapa);
             Thread wątek=new Thread(nowyKlient);
            wątek.setDaemon(true);  
          wątek.start();
            nowyKlient.setWatek(wątek);
         
             nowyKlient.getObrazek().setOnMouseClicked(new KontrolerKlienta(this.poleTekstowe,this.obsluga));
     }else if(rodzajKlienta==1){
             nowyKlient=new Okazjonalny(nrk,x,y,obsluga);
             obsluga.nowyKlient(nowyKlient);
              nowyKlient.rysujNaMapie(mapa);
              Thread wątek=new Thread(nowyKlient);
            
              nowyKlient.setWatek(wątek);
             wątek.setDaemon(true);
             wątek.start();
                nowyKlient.getObrazek().setOnMouseClicked(new KontrolerKlienta(this.poleTekstowe,this.obsluga));
     }else if(rodzajKlienta==2){
             nowyKlient=new Firmowy(nrk,x,y,obsluga);   
            obsluga.nowyKlient(nowyKlient);
                nowyKlient.rysujNaMapie(mapa);
              Thread wątek=new Thread(nowyKlient);
             wątek.setDaemon(true); 
             wątek.start();
             nowyKlient.setWatek(wątek);
           
                nowyKlient.getObrazek().setOnMouseClicked(new KontrolerKlienta(this.poleTekstowe,this.obsluga));
     }
      obsluga.dodajPole(x, y);
    
    }
    
   @FXML 
       private void handleDodajDostawce(ActionEvent event){
       poleTekstowe.clear();
      Dostawca nowyDostawca=new Dostawca(obsluga,189,189);
      nowyDostawca.rysujNaMapie(mapa);
      Thread wątek=new Thread(nowyDostawca);
     wątek.setDaemon(true); 
    wątek.start();
      nowyDostawca.setWatek(wątek);
      nowyDostawca.getObrazek().setOnMouseClicked(new KontrolerDostawcy(this.poleTekstowe,this.obsluga));
    }
    @FXML 
        private void handleDodajPosilek(ActionEvent event){
       poleTekstowe.clear();
        Restauracja nowy;
        Random r=new Random();
        int decyzja=r.nextInt(2);
        if(decyzja==0 || this.obsluga.getMenu().getMenu().size()<2){
       nowy =new Posilek();
       this.obsluga.getMenu().dodajPosilek(nowy);
       poleTekstowe.clear();
       poleTekstowe.appendText("Dodano Posiłek"); 
        }else if(decyzja==1)
        {
            nowy=new ZestawObiadowy(this.obsluga.getMenu());
            this.obsluga.getMenu().dodajPosilek(nowy);
            poleTekstowe.clear();
            poleTekstowe.appendText("Dodano Zestaw Obiadowy");  
            }
    }
    @FXML void handleNoweZamowienie(ActionEvent event){
          poleTekstowe.clear();
        if(!(obsluga.getListaKlientow().isEmpty())){
            Zamowienie nowe;
            Random r =new Random();
            int x= r.nextInt(obsluga.getListaKlientow().size());
            nowe=new Zamowienie(obsluga.getListaKlientow().get(x),obsluga.getMenu());
            this.obsluga.noweZamowienie(nowe);}
        else {
            poleTekstowe.appendText("Stwórz klienta");
        }
        }    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        obsluga=new Obsluga();
        obsluga.dodajPole(189, 189);
        
    }    
    
}
