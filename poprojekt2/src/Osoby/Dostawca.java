/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Osoby;

import Enums.Nazwiska;
import Enums.DniTygodnia;
import Enums.Imiona;
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
import poprojekt2.Obsluga;
import Pojazd.Pojazd;
import Pojazd.Samochod;
import Pojazd.Skuter;
import ZamowieniaIPosilki.Zamowienie;

/**
 *
 * @author Anka
 */
public class Dostawca extends Thread {
  private  String imie;
  private  String nazwisko;
  private  int[] PESEL=new int[10];
  private String dniPracy;
  private String godzinyPracy;
  private  String katPrawaJazdy;
  private Pojazd pojazdDosatwcy; 
  private Obsluga obsluga;
  private ArrayList <Zamowienie> zamowienia;
  private int x;
  private int y;
  private ImageView obrazek;
  private Thread watek;
  private boolean zajety;
  private boolean wroc;
/**
 * Ustawia x
 * @param x 
 */
    public void setX(int x) {
        this.x = x;
    }
/**
 * Ustawia y
 * @param y 
 */
    public void setY(int y) {
        this.y = y;
    }
/**
 * Zwraca x
 * @return x
 */
    public int getX() {
        return x;
    }
/**
 * Zwraca y
 * @return y
 */
    public int getY() {
        return y;
    }
/**
 * Zwraca pojazd dostawcy
 * @return pojazd dostawcy
 */
    public Pojazd getPojazdDosatwcy() {
        return pojazdDosatwcy;
    }
/**
 * Ustawia pojazd dostawcy
 * @param pojazdDosatwcy 
 */
    public void setPojazdDosatwcy(Pojazd pojazdDosatwcy) {
        this.pojazdDosatwcy = pojazdDosatwcy;
    }
/**
 * Zwraca watek dostawcy
 * @return watek dostawcy
 */
    public Thread getWatek() {
        return watek;
    }
/**
 * Ustawia watek dostawcy
 * @param watek 
 */
    public void setWatek(Thread watek) {
        this.watek = watek;
    }
  /**
   * Konstrukor Dostawcy
   * @param o
   * @param wspolx
   * @param wspoly 
   */
 public Dostawca(Obsluga o,int wspolx,int wspoly){
     this.x=wspolx;
     this.y=wspoly;
     Random r=new Random();
      this.imie=wylosujImie();
      this.nazwisko=wylosujNazwisko();
      for(int z=0;z<this.PESEL.length;z++){
      this.PESEL[z]=r.nextInt(8)+1;}
      int kat=r.nextInt(1);
      if (kat==0){ 
          this.katPrawaJazdy="A";  
      this.pojazdDosatwcy=wylosujPojazd("A");}
      else if(kat==1) {
          this.katPrawaJazdy="B";
          this.pojazdDosatwcy=wylosujPojazd("B");}
      this.dniPracy=wylosujDniPracy();
      this.godzinyPracy=wylosujGodzinyPracy();
      this.obsluga=o;
      this.zamowienia=new ArrayList<>();
      this.zajety=true;
      this.wroc=false;
  }
 /**
  * Prywatna metoda losujaca nazwisko z enuma
  * @return naziwsko
  */
 private String wylosujNazwisko(){
      String na="";
     Random r=new Random();
    ArrayList <Nazwiska> tab=new ArrayList();
    tab.addAll(Arrays.asList(Nazwiska.values()));
        int z=r.nextInt(tab.size());
        na+=tab.get(z).toString();
     return na; 
 }
 /**
  * Prywatna metoda zwracająca Imie z enuma
  * @return imie
  */
 private String wylosujImie(){
     String im="";
     Random r=new Random();
    ArrayList <Imiona> tab=new ArrayList();
    tab.addAll(Arrays.asList(Imiona.values()));
        int z=r.nextInt(tab.size());
        im+=tab.get(z).toString();
     return im;
 }
 /**
  * Prywatna metoda zwracajaca godziny pracy dostawcy
  * @return godziny pracy
  */
 private String wylosujGodzinyPracy(){
     String godziny="";
     Random r=new Random();
     int w=r.nextInt(2);
     if(w==0){
         godziny+="8-16";
     }else if(w==1) {
         godziny+="16-24";
     }
     return godziny;
 }
 /**
  * Prywatna metoda losujaca dni pracy
  * @return dni pracy
  */
 private String wylosujDniPracy(){
     String dni = "Dni pracy:\n";
     
     Random r=new Random();
    ArrayList <DniTygodnia> tab=new ArrayList();
    tab.addAll(Arrays.asList(DniTygodnia.values()));
    for(int i=0;i<3;i++){
        int z=r.nextInt(tab.size());
        dni+=tab.get(z).toString();
        dni+="\n";
        tab.remove(z);
     }
     return dni;
 }
 /**
  * Prywatna metoda losujaca pojazd dostawcy:skuter lub samochod
  * @param kategoriaPJ
  * @return pojazd
  */
  private Pojazd wylosujPojazd(String kategoriaPJ){
      Pojazd autko=null;
      if (kategoriaPJ.equals("B")){
          Random r=new Random();
          autko = new Samochod(50,90,r.nextInt(99999),60);//ladownosc zamowien, MAX predkosc, nr rejestracyjny , pojemnosc baku 
      }else if (kategoriaPJ.equals("A")){
          Random r=new Random();
          autko=new Skuter(20,60,r.nextInt(99999),30);
      }
      return autko;
  }
  /**
   * Zwraca imie dostawcy
   * @return imie
   */
    public String getImie() {
        return imie;
    }
    /**
     * Zwraca nazwisko dostawcy
     * @return naziwsko
     */
    public String getNazwisko() {
        return nazwisko;
    }
   /**
    * Zwraca dni pracy dostawcy
    * @return dni pracy
    */
    public String getDniPracy() {
        return dniPracy;
    }
    /**
     * Zwraca godziny pracy dostawcy
     * @return godziny pracy
     */
    public String getGodzinyPracy() {
        return godzinyPracy;
    }
/**
 * Zwraca kategorie prawa jazdy dostawcy
 * @return kategoria prawa jazdy
 */
    public String getKatPrawaJazdy() {
        return katPrawaJazdy;
    }
    /**
     * Metoda rysujaca dostawce na mapie
     * @param mapa 
     */
public void rysujNaMapie(AnchorPane mapa){
    this.obrazek=new ImageView();
    if(Files.notExists(Paths.get("src/Obrazki/dostwca.png"))){
        System.out.println("Plik nie istneieje");
    }
    obrazek.setImage(new Image("file:src/Obrazki/dostwca.png"));
    obrazek.setLayoutX(this.x);
    obrazek.setLayoutY(this.y);
    obrazek.setUserData(this);
    mapa.getChildren().add(obrazek);
}
/**
 * Zwraca ikone dostawcy
 * @return ikona
 */
    public ImageView getObrazek() {
        return obrazek;
    }
/**
 * Zwraca czy dostawca jest zajety
 * @return zajety
 */
    public boolean isZajety() {
        return zajety;
    }
/**
 * Ustawia pole zajety
 * @param zajety 
 */
    public void setZajety(boolean zajety) {
        this.zajety = zajety;
    }
/**
 * Zwraca czy dostawca wraca do restauracji
 * @return wraca
 */
    public boolean isWroc() {
        return wroc;
    }
/**
 * Ustawia parametr wroc
 * @param wroc 
 */
    public void setWroc(boolean wroc) {
        this.wroc = wroc;
    }
 /**
  * Metoda ujmujaca paliwo
  */
    public void utrataPaliwa(){
      double benzyna=this.getPojazdDosatwcy().getPojemnoscBaku();
      this.getPojazdDosatwcy().setPojemnoscBaku(benzyna-0.02);  
   
    }
    /**
     * Metoda sprawdzajaca czy pole na ktore chce wjechac dostawca jest wolne 
     * @param a
     * @param b 
     */
 public void czywolnepole(int a,int b){
     if (this.obsluga.czyzajete(a, b)){
         try {
             sleep(50);
         } catch (InterruptedException ex) {
             Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
         }
     }else{
         this.obsluga.setZajete(a, b);
     }
 }
 /**
  * Metoda odpowiedzialna za dostarczanie zamowien
  */
  public void dostarcz(){
      
    double aktcelx;
    double aktcely;
      if(this.getPojazdDosatwcy().getPojemnoscBaku()>0){
    if(!this.zamowienia.isEmpty()){
        if(this.wroc==true){
            wrocDoRestauracji();
        }else{
                    aktcelx=zamowienia.get(0).getKlient().getObrazek().getLayoutX();
        aktcely=zamowienia.get(0).getKlient().getObrazek().getLayoutY();
            
        
        if(aktcelx!=this.getObrazek().getLayoutX()){
            if(aktcelx>this.getObrazek().getLayoutX()){
             czywolnepole((int)(this.getObrazek().getLayoutX()+1),(int)this.getObrazek().getLayoutY());
                this.getObrazek().setLayoutX(this.getObrazek().getLayoutX()+1);
                this.getObrazek().setVisible(true);
                utrataPaliwa();
                this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()+1),(int)this.getObrazek().getLayoutY());
            }
        else {
               czywolnepole((int)(this.getObrazek().getLayoutX()-1),(int)this.getObrazek().getLayoutY() );
                this.getObrazek().setLayoutX(this.getObrazek().getLayoutX()-1);
         utrataPaliwa();
         this.getObrazek().setVisible(true);
         this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()-1),(int)this.getObrazek().getLayoutY());
            }
        }else if(aktcely!=this.getObrazek().getLayoutY()){
                if(aktcely>this.getObrazek().getLayoutY()){
                    czywolnepole((int)(this.getObrazek().getLayoutX()), (int)(this.getObrazek().getLayoutY()+1));
                    this.getObrazek().setLayoutY(this.getObrazek().getLayoutY()+1);
                     utrataPaliwa();
                     this.getObrazek().setVisible(true);
                     this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()),(int) (this.getObrazek().getLayoutY()+1));
                }else {
                    czywolnepole((int)(this.getObrazek().getLayoutX()),(int) (this.getObrazek().getLayoutY()-1));
                    this.getObrazek().setLayoutY(this.getObrazek().getLayoutY()-1);
                     utrataPaliwa();
                     this.getObrazek().setVisible(true);
                    this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()), (int)(this.getObrazek().getLayoutY()-1));
                }
        }
        if(aktcely==this.getObrazek().getLayoutY() && aktcelx==this.getObrazek().getLayoutX()){
            this.zamowienia.remove(0);
            if(this.zamowienia.isEmpty()){  
                this.zajety=true;
                wrocDoRestauracji();
            }
        }}}}
    else {
            wrocDoRestauracji();}
            }
/**
 * Metoda kierująca dostawce do restauracji
 */
public void wrocDoRestauracji(){
    int xR=189;
    int yR=189;
  
  
    //tankowanie
    if ("A".equals(this.getKatPrawaJazdy())){
       this.getPojazdDosatwcy().setPojemnoscBaku(30); 
  
    }else {
          this.getPojazdDosatwcy().setPojemnoscBaku(60); 
    }
    
    
    while(xR!=this.getObrazek().getLayoutX()){
      
            if(xR>this.getObrazek().getLayoutX()){
                
                czywolnepole((int)(this.getObrazek().getLayoutX()+1),(int) (this.getObrazek().getLayoutX()+1));
                this.getObrazek().setLayoutX(this.getObrazek().getLayoutX()+1);
                
                utrataPaliwa();
                try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()+1),(int) (this.getObrazek().getLayoutX()+1));
            }
        else {
                czywolnepole((int)(this.getObrazek().getLayoutX()-1),(int)(this.getObrazek().getLayoutY()));
                this.getObrazek().setLayoutX(this.getObrazek().getLayoutX()-1);
        utrataPaliwa();
       this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()-1),(int)(this.getObrazek().getLayoutY()));
        try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    while(yR!=this.getObrazek().getLayoutY()){
                if(yR>this.getObrazek().getLayoutY()){
                    czywolnepole((int)(this.getObrazek().getLayoutX()),(int)(this.getObrazek().getLayoutY()+1));
                    this.getObrazek().setLayoutY(this.getObrazek().getLayoutY()+1);
                    utrataPaliwa();
                    this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()),(int)(this.getObrazek().getLayoutY()+1));
                    try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else {
                    czywolnepole((int)(this.getObrazek().getLayoutX()), (int)(this.getObrazek().getLayoutY()-1));
                    this.getObrazek().setLayoutY(this.getObrazek().getLayoutY()-1);
                    utrataPaliwa();
                    this.obsluga.zwolnij((int)(this.getObrazek().getLayoutX()), (int)(this.getObrazek().getLayoutY()-1));
                    try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Dostawca.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
        }
    
    if(this.wroc==true){
        this.wroc=false;
    }
  
}
    /**
     *Watek dostawcy sprawdza czy sa nieobsluzone zamowienia i je rozwozi
     */
    @Override
  
   public void run() {//sprawdzac czy sa jakies zamowienia i je rozwozic 
 while(!Thread.currentThread().isInterrupted()){
     try{
        
         if(this.getObrazek().getLayoutX()<226 &&this.getObrazek().getLayoutX()>189 && this.getObrazek().getLayoutY()<224 && this.getObrazek().getLayoutY()>189){
             this.getObrazek().setVisible(false);
         }else{
             this.getObrazek().setVisible(true);
         }
     if(!this.obsluga.getAktualneZamowienia().isEmpty() && this.zajety==true){ 
          this.zajety=false;
          this.zamowienia= new ArrayList<>(this.obsluga.getAktualneZamowienia());
         this.obsluga.czyscZamowienia();
         }
         
         dostarcz();
       Thread.sleep(30);
     } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
     }

     }
   }
/**
 * Zwraca pesel
 * @return pesel
 */
    public int[] getPESEL() {
        return PESEL;
    }
/**
 * Ustawia pesel
 * @param PESEL 
 */
    public void setPESEL(int[] PESEL) {
        this.PESEL = PESEL;
    }
/**
 * Zwraca obsluge
 * @return obsluga
 */
    public Obsluga getObsluga() {
        return obsluga;
    }
/**
 * Ustawia obsluge
 * @param obsluga 
 */
    public void setObsluga(Obsluga obsluga) {
        this.obsluga = obsluga;
    }
/**
 * Zwraca liste zamowien
 * @return lista zamowien
 */
    public ArrayList<Zamowienie> getZamowienia() {
        return zamowienia;
    }
/**
 * ustawia liste zamowien
 * @param zamowienia 
 */
    public void setZamowienia(ArrayList<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

}

 

 


