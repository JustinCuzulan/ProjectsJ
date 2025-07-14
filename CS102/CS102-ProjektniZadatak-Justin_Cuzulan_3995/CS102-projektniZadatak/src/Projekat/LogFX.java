/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author justincuzulan
 * Ova klasa je zaduzena za prikazivanje, stilizovanje, logiku za prijavljivanje i registrovanje.
 */
public class LogFX {

    static Button btnPotvrdiIgracaP = new Button("Potvrdi");
    static Button btnDaljeIgrac = new Button("Dalje");
    static Button btnPotvrdiIgracaN = new Button("Potvrdi");
    static Button btnAdminBrisanje=new Button("Izbrisi korisnika");
    
    private static TextField tfImeP = new TextField();
    private static TextField tfPasswordP = new TextField();
    static Igrac igracTmp;

    public static TextField tfImeN = new TextField();
    public static TextField tfPasswordN = new TextField();
    public static Label lIgracNePostoji = new Label();
    public static Label lIgracVecPostoji = new Label();

    /**
     * Metod prikaziLog je zaduzen za prikazivanje login i register prozora kao i za smijestanje elemenata u prozoru.
     * @return HBIgrac je HBox koji sadrzi elemente koji trebaju biti prikazani.
     */
    public static HBox prikaziLog() {
        tfImeP.clear();
        tfPasswordP.clear();
        VBox VBIgracDesno = new VBox();
        VBox VBIgracLijevo = new VBox();
        HBox HBDoleDesno = new HBox();
        HBox HBIgrac = new HBox();

        Label LPostojeci = new Label("Postojeci");
        Label LImeP = new Label("Ime");
//        TextField tfImeP = new TextField();
        Label LPasswordP = new Label("Password");
//        TextField tfPasswordP = new TextField();

        btnAdminBrisanje.setDisable(true);
        btnDaljeIgrac.setDisable(true);

        //DODATI METOD ZA DODAVANJE IGRACA U KLASI BAZA
        Label LNovi = new Label("Novi");
        Label LImeN = new Label("Ime");
        Label LPasswordN = new Label("Password");
        btnPotvrdiIgracaP.setOnAction(ev1 -> {
            try {
                loginIgracaP();
                lIgracNePostoji.setText("");
            } catch (LogException ex) {
                lIgracNePostoji.setText(ex.getMessage());
            }

        });
        btnPotvrdiIgracaN.setOnAction(ev9 -> {

            try {
                registrovanjeIgracaN();
                lIgracVecPostoji.setText("");
            } catch (LogException ex) {
                lIgracVecPostoji.setText(ex.getMessage());
            }
        });

        VBIgracLijevo.getChildren().addAll(LPostojeci, LImeP, tfImeP, LPasswordP, tfPasswordP, lIgracNePostoji, btnPotvrdiIgracaP,btnAdminBrisanje);
        VBIgracDesno.getChildren().addAll(LNovi, LImeN, tfImeN, LPasswordN, tfPasswordN, lIgracVecPostoji, btnPotvrdiIgracaN);
        HBDoleDesno.getChildren().add(btnDaljeIgrac);
        HBDoleDesno.setAlignment(Pos.BOTTOM_RIGHT);
        HBIgrac.getChildren().addAll(VBIgracLijevo, VBIgracDesno, HBDoleDesno);
        
        
        HBIgrac.setSpacing(10);
//        LPostojeci.setStyle("-fx-text-fill:BLUE;");
        
        
        return HBIgrac;
    }
/**
 * Metod loginIgracaP je metod za login igraca.
 * @throws LogException je izuzetak, koji se izbaci prilikom nepostojanja igraca u bazi.
 */
    private static void loginIgracaP() throws LogException {
        Igrac i = new Igrac(tfImeP.getText(), tfPasswordP.getText());

//        System.out.println(Baza.dohvatiIgraca().get(0));
//        System.out.println(Baza.dohvatiIgraca().contains(i));

        if (Baza.dohvatiIgraca().contains(i)) {
            igracTmp = Baza.dohvatiIgraca().get(Baza.dohvatiIgraca().indexOf(i));
            btnDaljeIgrac.setDisable(false);
//            System.out.println(igracTmp);
            if(igracTmp.getAdmin()==1){
                btnAdminBrisanje.setDisable(false);
            }
            
        } else {
            throw new LogException("Igrac ne postoji! Registrujte se.");

        }

    }

/**
 * Metod registovanjeIgracaN je metod za registrovanje igraca.
 * @throws LogException je izuzetak koji se izbaci ukoliko takav igrac sa istim imenom i sifrom vec postoji.
 */
    private static void registrovanjeIgracaN() throws LogException {
        Igrac i = new Igrac(tfImeN.getText(), tfPasswordN.getText());
        for(Igrac z: Baza.dohvatiIgraca()){
            if(z.getIme().equals(tfImeN.getText())){
                throw new LogException("Igrac vec postoji!");
            }
            
        }
        igracTmp = new Igrac(tfImeN.getText(), tfPasswordN.getText(), 0, 0);
            Baza.addIgrac(igracTmp);
            btnDaljeIgrac.setDisable(false);
    }
}
