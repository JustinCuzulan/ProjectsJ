/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

/**
 *
 * @author justincuzulan
 */
public class Rijeci {
    private String odabrana;
    private int maxBodova=10;

    public Rijeci(String odabrana) {
        this.odabrana = odabrana;
    }

    public String getOdabrana() {
        return odabrana;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }
    
    
}
