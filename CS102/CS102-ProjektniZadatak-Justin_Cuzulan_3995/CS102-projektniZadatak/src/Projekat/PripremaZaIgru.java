/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author justincuzulan
 * Klasa koja ima atribute i metode potrebne za jednu partiju igre.
 * Ovdje su smjesteni jedna rijec klase Rijeci, jedna asocijacija klase Asocijacija i lista pitanja klase KoZnaZna
 */
public class PripremaZaIgru {
    
    private ArrayList<KoZnaZna>ListaPitanja=new ArrayList<KoZnaZna>();
    private Asocijacije asocijacija;
    private Rijeci rijec;
/**
 * Podrazumijevani konstruktor.
 */
    public PripremaZaIgru() {
    }
    /**
     * 
     * @return ListaPitanja vraca listu od 3 objekata KoZnaZna.
     */
    public ArrayList<KoZnaZna> getListaPitanja() {
        return ListaPitanja;
    }
/**
 * 
 * @return asocijacija vraca jednu asocijaciju.
 */
    public Asocijacije getAsocijacija() {
        return asocijacija;
    }
/**
 * 
 * @return rijec vraca jednu rijec neophodnu za prvu igru.
 */
    public Rijeci getRijec() {
        return rijec;
    }
    
    /**
     * Metod setRijec bira, nasumicno, jedan Rijec objekat koji predstavlja rijec koju korisnik treba da pogodi. 
     */
    public void setRijec() {
        Random r=new Random();
        int a=r.nextInt(CitanjeURL.citanje().size());
        rijec=CitanjeURL.citanje().get(a);
    }
    /**
     * Metod setListuPitanja bira, nasumicno, tri objekta KoZnaZna iz baze i dodaje ih u ListuPitanja.
     */
    public void setListuPitanja(){
        Random r=new Random();
        int pozicijaPrvogPitanja=r.nextInt(Baza.dohvatiKoZnaZna().size()-2);
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja));
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja+1));
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja+2));
        
        
    }
    /**
     * Metod setAsocijacije bira, nasumicno, jedan objekat tipa Asocijacija.
     */
    public void setAsocijacije(){
        Random r=new Random();
        int a=r.nextInt(Baza.dohvatiAsocijacije().size());
        asocijacija=Baza.dohvatiAsocijacije().get(a);
    }
}
