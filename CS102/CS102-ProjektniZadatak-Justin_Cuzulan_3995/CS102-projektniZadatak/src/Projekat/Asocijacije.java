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
 * Klasa koja predstavlja objekat koji se nalazi u posljednjoj igri.
 * Sastoji se od ponudjenog pojma odnosno hint-a koji korisniku pomaze da pogodi konacan pojam
 * i od odabrane rijeci koju korisnik treba da pogodi.
 */

public class Asocijacije {
    /**
     * String odabrana je odabrani pojam koji korisnik treba da pogodi.
     * ArrayList<String>ponudjeniPojam je lista pomocnih pojmova koji nas vode do konacnog.
     */
    private String odabrana;
    private ArrayList<String>ponudjeniPojam=new ArrayList<String>();
/**
 * 
 * @param odabrana String koji predstavlja odabrani pojam koji treba da pogodite.
 * @param ponudjeniPojam lista koja predstavlja hint-ove koji vam pomazu da pogodite odabrani pojam.
 */
    public Asocijacije(String odabrana,ArrayList<String>ponudjeniPojam) {
        this.odabrana = odabrana;
        this.ponudjeniPojam=ponudjeniPojam;
    }
/**
 * Podrazumijevani konstruktor
 */
    public Asocijacije() {
    }
/**
 * 
 * @return odabrna vraca odabrani pojam
 */
    public String getOdabrana() {
        return odabrana;
    }
/**
 * 
 * @return ponudjeniPojam vraca ponudjeni pojam
 */
    public ArrayList<String> getPonudjeniPojam() {
        return ponudjeniPojam;
    }
/**
 * 
 * @param ponudjeniPojam odabran ponudjeni pojam
 */
    public void setPonudjeniPojam(ArrayList<String> ponudjeniPojam) {
        this.ponudjeniPojam = ponudjeniPojam;
    }
/**
 * 
 * @param odabrana odabrna rijec
 */
    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }
    @Override
    public String toString() {
        return "Asocijacije{" + "odabrana=" + odabrana + ", ponudjeniPojam=" + ponudjeniPojam + '}';
    }
    
    
}
