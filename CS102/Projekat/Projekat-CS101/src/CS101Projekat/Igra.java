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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author justi
 */
public class Igra {
    static Scanner inp=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Dobrodosli! \n Unesite Vase ime: ");
        String ime=inp.next(); 
        Igrac igrac=new Igrac(ime);
        System.out.println("Izaberite opciju");
        System.out.println("0 : Igrajte \n"
                + "1 : Statistika \n"
                + "2 : Moja statistika");
        int opcija=inp.nextInt();
        
        if(OpcijeZaIgru.izBroja(opcija)==OpcijeZaIgru.IGRAJ){
            igraj(igrac);
        }else if(OpcijeZaIgru.izBroja(opcija)==OpcijeZaIgru.STATISTIKA){
            citaj();
        }else if(OpcijeZaIgru.izBroja(opcija)==OpcijeZaIgru.MOJASTATISTIKA){
            citajMoje(igrac.getIme());
        }
        else{
            System.out.println("Opcija nije validna, pokusajte ponovo!");
                    
        }
    }
    
    public static void igraj(Igrac igrac){
        Rijec rijec=new Rijec();
        rijec.ucitaj();
        System.out.println(rijec.toString());
        String unesenaRijec=inp.next();
        if(rijec.pokusaj(unesenaRijec)){
            System.out.println("Pogodili ste rijec! Dobili ste " +rijec.getMaxBodova()+" bodova");
            igrac.uvecajBodove(rijec.getMaxBodova());
    
        }else{
            System.out.println("Niste pogodili trazenu rijec: "+rijec.getOdabrana());
        }
        Znanje pitanje=new Znanje();
        pitanje.ucitaj();
        for(int i=0;i<3;i++){
            pitanje.izaberi();
            System.out.println(pitanje.toString());
            String uneseniOdgovor=inp.next();
            if(pitanje.pokusaj(uneseniOdgovor)){
                System.out.println("Odgovor je tacan! Dobili ste "+pitanje.getMaxBodova()+" bodova");
                igrac.uvecajBodove(pitanje.getMaxBodova());
            }else{
                System.out.println("Pogresan odgovor. Tacan odgovor je pod "+pitanje.getTacanOdgovor());
            }
        }
        Asocijacije asocijacije=new Asocijacije();
        asocijacije.ucitaj();
        asocijacije.izaberi();
        int nagovjestaj = 0;
        int pokusaj=0;
        asocijacije.prikaziNagovjestaj(nagovjestaj);
        System.out.println("Ostalo Vam je "+(asocijacije.getNagovjestaj().size()-1)+" nagovjestaja.");

        while(pokusaj<3){
            String unos=inp.next();
            if(unos.compareTo("-")==0){
                if(nagovjestaj+1 < asocijacije.getNagovjestaj().size()){
                nagovjestaj++;
                asocijacije.prikaziNagovjestaj(nagovjestaj);
                    System.out.println("Ostalo Vam je "+(asocijacije.getNagovjestaj().size()-nagovjestaj-1)+" nagovjestaja.");
                }
                else{
                    System.out.println("Nemate vise nagovjestaja! Pokusajate da pogodite rijec.");
                }
               
            }else{
                if(asocijacije.pokusaj(unos)){
                    System.out.println("Pogodili ste trazeni pojam! Dobili ste "+asocijacije.getMaxBodova()+" bodova");
                    igrac.uvecajBodove(asocijacije.getMaxBodova()*(3-pokusaj));
                    break;
                }else{
                    System.out.println("To nije trazeni pojam."+" Preostali broj pokusaja je: "+(2-pokusaj));
                    pokusaj++;
                }
            }
        }if(pokusaj==3){
            System.out.println("Nazalost, ostali ste bez pokusaja.Trazeni pojam je "+asocijacije.getOdabrana());
        }
        igrac.ispis();
        
    }
    public static void citaj(){
        Path ulaz=Paths.get("stat.txt");
        try{
            List<String> stat=Files.readAllLines(ulaz);
            for(String s : stat){
                System.out.println(s);
            }
        }catch(IOException ex){
            ex.printStackTrace();
    }
    }
    public static void citajMoje(String a){
        Path ulaz=Paths.get("stat.txt");
        try{
            List<String> stat=Files.readAllLines(ulaz);
            for(String s : stat){
                if(a.compareTo(s.substring(0, s.indexOf(" ")))==0){
                     System.out.println(s);
                }
               
            }
        }catch(IOException ex){
            ex.printStackTrace();
    }
    }
}
