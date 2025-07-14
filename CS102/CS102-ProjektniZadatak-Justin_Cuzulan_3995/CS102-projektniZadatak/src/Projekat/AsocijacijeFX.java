/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.util.Iterator;
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
 * Klasa AsocijacijeFX je zaduzena za smijestanje elemenata i davanje funkcije istim.
 */
public class AsocijacijeFX {

    static Button btnDalje3 = new Button("Dalje");
    private static int brojPokusaja = 4;
    static int bodoviIzIgre;
/**
 * smanjiBrojPokusaja je metod koji umanjuje broj pokusaja za jedan.
 */
    private static void smanjiBrojPokusaja() {
        brojPokusaja--;
    }
/**
 * Metod prikaziAsocijacije je metod zaduzen za smijestanje elemenata u VBox.
 * @param pripremaZaIgru je objekat klase PripremaZaIgru.
 * @param igracF je objekat klase Igrac.
 * @return VBAsocijacije, je povratna vrijednost tipa VBox u kojoj su smjesteni elementi.
 */
    public static VBox prikaziAsocijacije(PripremaZaIgru pripremaZaIgru, Igrac igracF) {
        VBox VBAsocijacije = new VBox();
        HBox HBDonji3 = new HBox();

        Button btnHint = new Button("HINT");
        TextField tfKonacanOdg = new TextField();
        Button btnPotvrdi = new Button("Potvrdi");
        TextArea TAHints = new TextArea("");
        TAHints.setEditable(false);
        Label lIgracIme = new Label(igracF.getIme());
        Label lIgracBodovi = new Label(igracF.getBrojBodova() + "");
        Iterator it = pripremaZaIgru.getAsocijacija().getPonudjeniPojam().iterator();

        btnDalje3.setDisable(true);
        bodoviIzIgre = 16;
        btnHint.setOnAction(ev8 -> {

            if (it.hasNext()) {
                TAHints.appendText(it.next().toString() + '\n');
                //igracF.povecajBrojBodova(-2);
                bodoviIzIgre -= 2;
            } else {
                TAHints.appendText("\nNema vise hintova\n");
                btnHint.setDisable(true);
            }
        });

        btnPotvrdi.setOnAction(ev9 -> {
            if (tfKonacanOdg.getText().equalsIgnoreCase(pripremaZaIgru.getAsocijacija().getOdabrana())) {
                btnPotvrdi.setStyle("-fx-background-color:#00FF00;");
                igracF.povecajBrojBodova(bodoviIzIgre);
                lIgracBodovi.setText(igracF.getBrojBodova() + "");
                btnDalje3.setDisable(false);

            } else {

                smanjiBrojPokusaja();

                if (brojPokusaja <= 0) {
                    btnPotvrdi.setStyle("-fx-background-color:#FF0000;");
                    TAHints.appendText("Tacan odgovor je: " + pripremaZaIgru.getAsocijacija().getOdabrana() + '\n');
                    btnPotvrdi.setDisable(true);
                    btnHint.setDisable(true);
                    btnDalje3.setDisable(false);
                    bodoviIzIgre = 0;
                } else {
                    TAHints.appendText("Netacan odgovor! Imate jos " + brojPokusaja + " pokusaja!\n");
                    bodoviIzIgre -= 2;
                }
            };

        });

        VBox VBHeader1 = new VBox();
        VBHeader1.getChildren().addAll(lIgracIme, lIgracBodovi);
        VBHeader1.setAlignment(Pos.TOP_LEFT);
        HBDonji3.getChildren().add(btnDalje3);
        HBDonji3.setAlignment(Pos.BOTTOM_RIGHT);
        VBAsocijacije.getChildren().addAll(VBHeader1, TAHints, btnHint, tfKonacanOdg, btnPotvrdi, HBDonji3);
        VBAsocijacije.setAlignment(Pos.CENTER);
        VBAsocijacije.setSpacing(10);
        return VBAsocijacije;
    }
}
