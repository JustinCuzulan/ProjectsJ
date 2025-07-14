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
 */
public class Asocijacije {
    private String odabrana;
    private ArrayList<String>ponudjeniPojam=new ArrayList<String>();
    private int maxBodova=20;

    public Asocijacije(String odabrana,ArrayList<String>ponudjeniPojam) {
        this.odabrana = odabrana;
        this.ponudjeniPojam=ponudjeniPojam;
    }

    public String getOdabrana() {
        return odabrana;
    }

    public ArrayList<String> getPonudjeniPojam() {
        return ponudjeniPojam;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setPonudjeniPojam(ArrayList<String> ponudjeniPojam) {
        this.ponudjeniPojam = ponudjeniPojam;
    }

    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }
    
    
}
