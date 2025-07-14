package Projekat;


import Projekat.Baza;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


/**
 *
 * @author justincuzulan
 * Klasa AdminBrisanjeFX je zaduzena za prikazivanje i dodavanje funkcije za brisanje korisnika unosom imena.
 */
public class AdminBrisanjeFX {

    static Button btnIzbrisi = new Button("Izbrisi korisnika");
    static Button btnNazad=new Button("Nazad");
    
    /**
     * Metod brisanjeBrikaz, brise korisnika na osnovu imena.
     * @return VBox, u kojem se nalaze elementi za prikazivanje.
     */
    public static VBox brisanjePrikaz() {
        VBox VBGlavni = new VBox();
        Label lBrisi=new Label("Unesite ime korisnika");
        TextField tfImeB = new TextField();
        btnIzbrisi.setOnAction(ev -> {
            Baza.brisiIgraca(tfImeB.getText());
        });
        VBGlavni.getChildren().addAll(lBrisi,tfImeB, btnIzbrisi,btnNazad);
        VBGlavni.setAlignment(Pos.CENTER);
        return VBGlavni;
    }
}
