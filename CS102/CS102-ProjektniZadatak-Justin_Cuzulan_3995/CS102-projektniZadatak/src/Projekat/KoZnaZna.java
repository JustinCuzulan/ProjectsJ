/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.ArrayList;

/**
 *
 * @author justincuzulan
 * Klasa predstavlja objekat koji se koristi u drugoj igri.
 * Sastoji se od pitanja, liste ponudjenih odgovora i indikatora za tacan odgovor.
 */
public class KoZnaZna {
    /**
     * String pitanje sadrzi pitanje na koje koriskik treba da odgovori.
     * int tacanOdgovor sadrzi tacan odgovor na dato pitanje.
     * ArrayList<String>ponudjeniOdgovor predstavlja String listu ponudjenih odgovora medju kojima se nalazi i tacan odgovor,
     */
    private String pitanje;
    private int tacanOdgovor;
    private ArrayList<String>ponudjeniOdgovor=new ArrayList<String>();
    
/**
 * 
 * @param pitanje String koji predstavlja jedno pitanje
 * @param ponudjenOdgovor lista koja predstavlja ponudjen odgovor.
 * @param tacanOdgovor int koji predstavlja tacan odgovor.
 */
    public KoZnaZna(String pitanje,ArrayList<String>ponudjenOdgovor ,int tacanOdgovor) {
        this.pitanje = pitanje;
        this.ponudjeniOdgovor=ponudjenOdgovor;
        this.tacanOdgovor = tacanOdgovor;
        
    }
/**
 * Podrazumijevani konstruktor
 */
    public KoZnaZna() {
    }
/**
 * 
 * @return vraca pitanje
 */
    public String getPitanje() {
        return pitanje;
    }
/**
 * 
 * @return vraca ponudjene odgovore
 */
    public ArrayList<String> getPonudjeniOdgovor() {
        return ponudjeniOdgovor;
    }
/**
 * 
 * @return govori programu koji je tacan odgovor
 */
    public int getTacanOdgovor() {
        return tacanOdgovor;
    }
/**
 * 
 * @param pitanje odabrano pitanje
 */
    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }
/**
 * 
 * @param ponudjeniOdgovor odabran ponudjen odgovor
 */
    public void setPonudjeniOdgovor(ArrayList<String> ponudjeniOdgovor) {
        this.ponudjeniOdgovor = ponudjeniOdgovor;
    }
/**
 * 
 * @param tacanOdgovor odabran tacan odgovor
 */
    public void setTacanOdgovor(int tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    @Override
    public String toString() {
        return "KoZnaZna{" + "pitanje=" + pitanje + ", tacanOdgovor=" + tacanOdgovor + ", ponudjeniOdgovor=" + ponudjeniOdgovor +  '}';
    }
    
    
    
    
    
            
}
