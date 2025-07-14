package Projekat;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author justincuzulan
 * Klasa TabelaRezultataFX je klasa zaduzena za prikazivanje, smijestanje i stilizovanje elemenata koji ce biti prikazani.
 * Klasa je zaduzena za prikazivanje posljednje stranice igre.
 */
public class TabelaRezultataFX {

    static Button btnKonacno = new Button("Konacno");
/**
 * Metod prikaziRezultate je zaduzen za smijestanje elemenata u VBox
 * @param igracF je objekat klase Igrac
 * @return VBRezultati je VBox u kojem se nalaze slementi.
 */
    public static VBox prikaziRezultate(Igrac igracF) {

        VBox VBRezultati = new VBox();
        HBox HBDonji4 = new HBox();

        Label LRezultat = new Label("Rezultat");
        Label LRijeci = new Label("Rijeci");
        Label TARijeci = new Label(ReciFX.bodoviIzIgre + "");
        Label LKoZnaZna = new Label("Ko zna zna");
        Label TAKoZnaZna = new Label(KoZnaZnaFX.bodoviIzIgre + "");
        Label LAsocijacije = new Label("Asocijacije");
        Label TAAsocijacije = new Label(AsocijacijeFX.bodoviIzIgre + "");
        Label LUkupno = new Label("Ukupno");
        Label TAUkupno = new Label(igracF.getBrojBodova() + "");
        Baza.updateIgraca(igracF.getIme(), igracF.getPassword(), igracF.getAdmin(), igracF.getBrojBodova());
        HBDonji4.getChildren().add(btnKonacno);
        HBDonji4.setAlignment(Pos.BOTTOM_RIGHT);
        VBRezultati.getChildren().addAll(LRezultat, LRijeci, TARijeci, LKoZnaZna, TAKoZnaZna, LAsocijacije, TAAsocijacije, LUkupno, TAUkupno, HBDonji4);
        VBRezultati.setAlignment(Pos.TOP_CENTER);
        VBRezultati.setSpacing(10);
        return VBRezultati;
    }
}
