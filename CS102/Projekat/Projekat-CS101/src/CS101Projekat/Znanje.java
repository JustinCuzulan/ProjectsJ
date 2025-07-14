/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS101Projekat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author justi
 */
public class Znanje extends Pitanje {

    private List<String> Znanja;
    private String pitanje;
    private String tacanOdgovor;
    private List<String> PonudjeniOdgovori;
    private boolean prvoPitanje = true;
    private int rBroj;
    private int maxBodova = 10;

    public Znanje() {
    }

    public Znanje(List<String> Znanja, String pitanje, String tacanOdgovor, List<String> PonudjeniOdgovori, int rBroj) {
        this.Znanja = Znanja;
        this.pitanje = pitanje;
        this.tacanOdgovor = tacanOdgovor;
        this.PonudjeniOdgovori = PonudjeniOdgovori;
        this.rBroj = rBroj;
    }

    public List<String> getZnanja() {
        return Znanja;
    }

    public String getPitanje() {
        return pitanje;
    }

    public String getTacanOdgovor() {
        return tacanOdgovor;
    }

    public List<String> getPonudjeniOdgovori() {
        return PonudjeniOdgovori;
    }

    public boolean isPrvoPitanje() {
        return prvoPitanje;
    }

    public int getrBroj() {
        return rBroj;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setZnanja(List<String> Znanja) {
        this.Znanja = Znanja;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public void setTacanOdgovor(String tacanOdgovor) {
        this.tacanOdgovor = tacanOdgovor;
    }

    public void setPonudjeniOdgovori(List<String> PonudjeniOdgovori) {
        this.PonudjeniOdgovori = PonudjeniOdgovori;
    }

    public void setPrvoPitanje(boolean prvoPitanje) {
        this.prvoPitanje = prvoPitanje;
    }

    public void setrBroj(int rBroj) {
        this.rBroj = rBroj;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }
    
    
    
    @Override
    public void ucitaj() {
        Path ulaz = Paths.get("znanje.txt");

        try {
            this.Znanja = Files.readAllLines(ulaz);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void izaberi() {
        if (prvoPitanje) {
            Random r = new Random();
            this.rBroj = r.nextInt(Znanja.size() - 2);
            this.prvoPitanje = false;
        } else {
            this.rBroj++;

        }
        String[] niz = Znanja.get(this.rBroj).split(";");
        pitanje = niz[0];
        tacanOdgovor = niz[1];
        String[] razdvojiPonudjene = niz[2].split(",");
        PonudjeniOdgovori = Arrays.asList(razdvojiPonudjene);
    }

    @Override
    public boolean pokusaj(String s) {
        if (s.compareToIgnoreCase(tacanOdgovor) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(this.pitanje).append("? \n");
        char a='a';
        for(String s : PonudjeniOdgovori){
            sb.append(a).append(") ").append(s +"\n");
            a++;
        }
        return sb.toString();
    }

}
