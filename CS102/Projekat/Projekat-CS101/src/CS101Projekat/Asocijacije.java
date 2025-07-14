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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author justi
 */
public class Asocijacije extends Pitanje {

    private List<String> Asocijacije;
    private String odabrana;
    private List<String> Nagovjestaj = new ArrayList<String>();
    private int maxBodova = 20;

    public Asocijacije() {
    }

    public Asocijacije(List<String> Asocijacije, String odabrana) {
        this.Asocijacije = Asocijacije;
        this.odabrana = odabrana;
    }

    public List<String> getAsocijacije() {
        return Asocijacije;
    }

    public String getOdabrana() {
        return odabrana;
    }

    public List<String> getNagovjestaj() {
        return Nagovjestaj;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setAsocijacije(List<String> Asocijacije) {
        this.Asocijacije = Asocijacije;
    }

    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }

    public void setNagovjestaj(List<String> Nagovjestaj) {
        this.Nagovjestaj = Nagovjestaj;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }

    @Override
    public void ucitaj() {
        Path ulaz = Paths.get("asoc.txt");

        try {
            this.Asocijacije = Files.readAllLines(ulaz);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void izaberi() {
        Random r = new Random();
        int rBroj = r.nextInt(Asocijacije.size());
        String[] niz = Asocijacije.get(rBroj).split(",");
       this.odabrana = niz[0];
        for (int i = 1; i < niz.length; i++) {
            this.Nagovjestaj.add(niz[i]);
        }
    }

    @Override
    public boolean pokusaj(String s) {
        if (s.compareToIgnoreCase(odabrana) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void prikaziNagovjestaj(int p) {
        System.out.println(Nagovjestaj.get(p));
    }

    // @Override
    //  public String toString() {
    // }
}
