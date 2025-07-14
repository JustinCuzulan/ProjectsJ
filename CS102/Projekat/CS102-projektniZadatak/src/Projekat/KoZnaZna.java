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
public class KoZnaZna {
    private String pitanje;
    private int tacanOdgovor;
    private ArrayList<String>ponudjeniOdgovor=new ArrayList<String>();
    int rBroj;
    int maxBodova=10;

    public KoZnaZna(String pitanje,ArrayList<String>ponudjenOdgovor ,int tacanOdgovor) {
        this.pitanje = pitanje;
        this.ponudjeniOdgovor=ponudjenOdgovor;
        this.tacanOdgovor = tacanOdgovor;
        
    }

    public String getPitanje() {
        return pitanje;
    }

    public ArrayList<String> getPonudjeniOdgovor() {
        return ponudjeniOdgovor;
    }

    public int getTacanOdgovor() {
        return tacanOdgovor;
    }

    public int getrBroj() {
        return rBroj;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public void setPonudjeniOdgovor(ArrayList<String> ponudjeniOdgovor) {
        this.ponudjeniOdgovor = ponudjeniOdgovor;
    }

    public void setTacanOdgovor(int tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public void setrBroj(int rBroj) {
        this.rBroj = rBroj;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }
    
    
    
    
    
            
}
