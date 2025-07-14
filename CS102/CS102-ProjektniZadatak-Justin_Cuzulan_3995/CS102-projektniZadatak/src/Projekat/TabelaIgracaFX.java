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
 * Klasa TabelaIgracaFX je zaduzena za prikazivanje igraca u jednoj stranici.
 */
public class TabelaIgracaFX {

    static Button btnNazad = new Button("Nazad");
/**
 * Metod prikazIgraca je zaduzen za prikazivanje svih igraca.
 * @return VBGlavni je VBox u kojem se nalaze elementi.
 */
    public static VBox prikazIgraca() {
        VBox VBGlavni = new VBox();
        VBox VBIgraciTabela = new VBox();
        HBox HBNazad = new HBox();

        HBNazad.getChildren().add(btnNazad);
        HBNazad.setAlignment(Pos.BOTTOM_LEFT);
        for (Igrac i : Baza.dohvatiIgraca()) {
            Label label = new Label(i.toString());

            VBIgraciTabela.getChildren().addAll(label);
            VBIgraciTabela.setAlignment(Pos.TOP_CENTER);
        }
        VBGlavni.getChildren().addAll(VBIgraciTabela, HBNazad);
         VBGlavni.setSpacing(10);
        return VBGlavni;
    }
}
