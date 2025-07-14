/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

/**
 *
 * @author justincuzulan
 * Klasa za objekat koji predstavlja jednu rijec koja se koristi u prvoj igri.
 */
public class Rijeci {
    /**
     * String koji sadrzi odabranu nisku koju korisnik pokusava da pogodi
     */
    private String odabrana;
/**
 * 
 * @param odabrana String koji predstavlja odabranu rijec.Reprezentacije rijeci u vidu stringa.
 */
    public Rijeci(String odabrana) {
        this.odabrana = odabrana;
    }
/**
 * Podrazumijevani konstruktor
 */
    public Rijeci() {
    }
/**
 * 
 * @return vraca odabranu nisku
 */
    public String getOdabrana() {
        return odabrana;
    }
    /**
     * 
     * @param odabrana odabrana niska
     */
    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }

    @Override
    public String toString() {
        return odabrana ;
    }
    
    
}
