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
public class Igrac {
    private String ime;
    private int brojBodova;

    public Igrac(String ime) {
        this.ime = ime;
        
    }

    public String getIme() {
        return ime;
    }

    public int getBrojBodova() {
        return brojBodova;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }
    
    
}
