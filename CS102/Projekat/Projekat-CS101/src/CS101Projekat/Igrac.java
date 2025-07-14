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
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author justi
 */
public class Igrac {
    private String ime;
    private int brojBodova=0;

    public Igrac(String ime) {
        if(ime.indexOf(' ')==-1){
            this.ime = ime;
        }else{
            System.out.println("Unesite ime bez razmaka!\n");
        }
       
        
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
    public void uvecajBodove(int x){
        this.brojBodova+=x;
    }
    public void ispis(){
        Path izlaz=Paths.get("stat.txt");
        String igracUStatistici=this.ime+" "+this.brojBodova+"";
        List<String>statistika=Arrays.asList(igracUStatistici);
        try{
            Files.write(izlaz, statistika,StandardOpenOption.APPEND);
            System.out.println("Podaci o ovoj igri su u fajlu stat.txt");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Igrac:"  + ime + ", broj bodova:" + brojBodova + "\n";
    }
    
}
