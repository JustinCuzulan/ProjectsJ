/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author justincuzulan
 * klasa KoZnaZnaFX je klasa koja priprema elemente za prikaz, smijesta elemente i daje im funkciju.
 */
public class KoZnaZnaFX {

    static Button btnDalje2 = new Button("Dalje");
    static int bodoviIzIgre = 0;
/**
 * Metod prikaziKoZnaZna je zaduzen za smijestanje elemenata u VBox.
 * @param pripremaZaIgru je objekat tipa PripremaZaIgru.
 * @param igracF je objekat tipa Igrac.
 * @return VBGlavni vraca VBox u kojem su smjesteni elementi.
 */
    public static VBox prikaziKoZnaZna(PripremaZaIgru pripremaZaIgru, Igrac igracF) {

        VBox VBKoZnaZna = new VBox();
        Label lIgracIme = new Label(igracF.getIme());
        Label lIgracBodovi = new Label(igracF.getBrojBodova() + "");

        
        for (int c = 0; c < 3; c++) {

            HBox HBGornji = new HBox();
            HBox HBSrednji = new HBox();
            HBox HBDonji = new HBox();

            Label TAIzlazPitanja = new Label(pripremaZaIgru.getListaPitanja().get(c).getPitanje());

            Button btnA = new Button(pripremaZaIgru.getListaPitanja().get(c).getPonudjeniOdgovor().get(0));
            Button btnB = new Button(pripremaZaIgru.getListaPitanja().get(c).getPonudjeniOdgovor().get(1));
            Button btnC = new Button(pripremaZaIgru.getListaPitanja().get(c).getPonudjeniOdgovor().get(2));
            Button btnD = new Button(pripremaZaIgru.getListaPitanja().get(c).getPonudjeniOdgovor().get(3));

            Button nizBtn[] = {btnA, btnB, btnC, btnD};

            for (int j = 0; j < 4; j++) {
                int x = j;
                int y = c;
                nizBtn[j].setOnAction(e5 -> {
//                    System.out.println(x);
//                    System.out.println(pripremaZaIgru.getListaPitanja().get(y).getTacanOdgovor());
                    if (x == pripremaZaIgru.getListaPitanja().get(y).getTacanOdgovor()) {
                        nizBtn[x].setStyle("-fx-background-color:#00FF00;");
                        igracF.povecajBrojBodova(3);
                        bodoviIzIgre += 3;
                    } else {
                        nizBtn[x].setStyle("-fx-background-color:#FF0000;");
                        igracF.povecajBrojBodova(-1);
                        nizBtn[x].setDisable(true);
                        bodoviIzIgre -= 1;
                    }
                    for (Button btn : nizBtn) {
                        btn.setDisable(true);
                    }
                    System.out.println(igracF.getBrojBodova());
                    lIgracBodovi.setText(igracF.getBrojBodova() + "");

                });

            }

            HBGornji.getChildren().addAll(btnA, btnB);
            HBSrednji.getChildren().addAll(btnC, btnD);
            HBDonji.getChildren().add(btnDalje2);
            VBKoZnaZna.getChildren().addAll(TAIzlazPitanja, HBGornji, HBSrednji, HBDonji);
            HBDonji.setAlignment(Pos.BOTTOM_RIGHT);
            HBGornji.setAlignment(Pos.CENTER);
            HBSrednji.setAlignment(Pos.CENTER);
        }

        VBox VBHeader01 = new VBox();
        VBHeader01.getChildren().addAll(lIgracIme, lIgracBodovi);
        VBHeader01.setAlignment(Pos.TOP_LEFT);

        VBox VBGlavni = new VBox();
        VBGlavni.getChildren().addAll(VBHeader01, VBKoZnaZna);
        VBGlavni.setSpacing(10);
        return VBGlavni;
    }

}
