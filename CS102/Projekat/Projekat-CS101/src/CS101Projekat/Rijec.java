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
public class Rijec extends Pitanje {

    private List<String> Rijeci;
    private String odabrana;
    private int maxBodova = 10;

    public Rijec() {
    }

    
    public Rijec(List<String> Rijeci, String odabrana) {
        this.Rijeci = Rijeci;
        this.odabrana = odabrana;
    }

    public List<String> getRijeci() {
        return Rijeci;
    }

    public String getOdabrana() {
        return odabrana;
    }

    public int getMaxBodova() {
        return maxBodova;
    }

    public void setRijeci(List<String> Rijeci) {
        this.Rijeci = Rijeci;
    }

    public void setOdabrana(String odabrana) {
        this.odabrana = odabrana;
    }

    public void setMaxBodova(int maxBodova) {
        this.maxBodova = maxBodova;
    }
    

    @Override
    public void ucitaj() {
        Path ulaz = Paths.get("rijeci.txt");

        try {
            this.Rijeci = Files.readAllLines(ulaz);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void izaberi() {
        Random r = new Random();
        int rBroj = r.nextInt(Rijeci.size());
        this.odabrana = Rijeci.get(rBroj);
    }

    @Override
    public boolean pokusaj(String s) {
        s = s.toLowerCase();
        if (s.compareTo(odabrana) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String promijesaj() {
        izaberi();
        List<String> slova = Arrays.asList(odabrana.split(""));
        Collections.shuffle(slova);
        return slova.toString();
    }

    @Override
    public String toString() {
        String s = promijesaj();
        StringBuilder sb = new StringBuilder();
        sb.append("Vasa ponudjena slova su:\n");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(" ");
        }
        return sb.toString();
    }

}
