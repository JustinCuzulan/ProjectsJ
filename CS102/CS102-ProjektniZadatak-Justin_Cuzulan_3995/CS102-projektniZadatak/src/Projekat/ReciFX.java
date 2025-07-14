/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author justincuzulan
 * Klasa ReciFX je zaduzena za prikazivanje,stilizovanje prve igre.
 */
public class ReciFX {

    static Button btnPotvrdiRijec = new Button("Potvrdi");
    static Button btnDalje = new Button("Dalje");
    static int bodoviIzIgre=0;
    /**
     * Metod prikaziReci je zaduzen sa smijestanje elemenata u prozor, u kojem se nalazi prva igra.
     * @param pripremaZaIgru je objekat klase PripremaZaIgru
     * @param igracF je objekat klase Igrac
     * @return VBIgraReci
     */
    public static VBox prikaziReci(PripremaZaIgru pripremaZaIgru,Igrac igracF) {

        VBox VBIgraReci = new VBox();
        HBox HBIgraReci = new HBox();
        Label TAIzlazReci = new Label(izmijesajRijec(pripremaZaIgru.getRijec().getOdabrana()));
        Label lUnosReci = new Label("Unesite rec");
        TextField TFUnosReci = new TextField();

        
        Label lIgracIme = new Label(igracF.getIme());
        Label lIgracBodovi = new Label(igracF.getBrojBodova()+"");
        
        btnPotvrdiRijec.setOnAction(ev->{
        if(TFUnosReci.getText().equalsIgnoreCase(pripremaZaIgru.getRijec().getOdabrana())){
            igracF.povecajBrojBodova(10);
            bodoviIzIgre+=10;
            btnPotvrdiRijec.setStyle("-fx-background-color:#00FF00;");
            btnPotvrdiRijec.setDisable(true);
            lIgracBodovi.setText(igracF.getBrojBodova()+"");
        }else{
            btnPotvrdiRijec.setStyle("-fx-background-color:#FF0000;");
            btnPotvrdiRijec.setDisable(true);
        }
        });
        
        HBIgraReci.setAlignment(Pos.BOTTOM_RIGHT);
        HBIgraReci.getChildren().add(btnDalje);

        VBox VBHeader = new VBox();
        VBHeader.getChildren().addAll(lIgracIme, lIgracBodovi);
        VBHeader.setAlignment(Pos.TOP_LEFT);

        VBIgraReci.getChildren().addAll(VBHeader, TAIzlazReci, TFUnosReci, btnPotvrdiRijec, HBIgraReci);
        VBIgraReci.setAlignment(Pos.TOP_CENTER);
        return VBIgraReci;
    }
    /**
     * Metod izmijesajRijec je zaduzen za mijesanje slova unutar jedne rijeci.
     * @param s je objekat tipa String
     * @return charLista vraca listu tipa String.
     */
    private static String izmijesajRijec(String s){
        List<String> charLista=Arrays.asList(s.split(""));
        Collections.shuffle(charLista);
        return charLista.toString();
       
    }  
}
