/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author justincuzulan
 */
public class PripremaZaIgru {
    private ArrayList<KoZnaZna>ListaPitanja=new ArrayList<KoZnaZna>();
    private Asocijacije asocijacija;
    private Rijeci rijec;

    public PripremaZaIgru() {
    }

    
    public PripremaZaIgru(Asocijacije asocijacija, Rijeci rijec) {
        this.asocijacija = asocijacija;
        this.rijec = rijec;
    }

    public ArrayList<KoZnaZna> getListaPitanja() {
        return ListaPitanja;
    }

    public Asocijacije getAsocijacija() {
        return asocijacija;
    }

    public Rijeci getRijec() {
        return rijec;
    }
    public void setAsocijacija(Asocijacije asocijacija) {
        this.asocijacija = asocijacija;
    }

    public void setRijec(Rijeci rijec) {
        this.rijec = rijec;
    }
    
    public void setListuPitanja(){
        Random r=new Random();
        int pozicijaPrvogPitanja=r.nextInt(Baza.dohvatiKoZnaZna().size()-3);
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja));
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja+1));
        ListaPitanja.add(Baza.dohvatiKoZnaZna().get(pozicijaPrvogPitanja+2));
        
        
    }
    
    public void setAsocijacije(){
        Random r=new Random();
        int a=r.nextInt(Baza.dohvatiAsocijacije().size()-1);
        asocijacija=Baza.dohvatiAsocijacije().get(a);
    }
}
