/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author justincuzulan
 * Ova klasa je zaduzena za generisanje i stilizovanje elemenata na pocetnom prozoru.
 */
public class PocetakFX {

    
    static Button btnStart = new Button();
    static Button btnIgraci = new Button();
    static Button btnKraj = new Button();
/**
 * Metod prikaziPocetak je zaduzen za stilizovanje i rasporedjivanje elemenata u prozoru.
 * @return root1 je VBox koji sadrzi sve elemente za prikazivanje.
 */
    public static VBox prikaziPocetak() {

        VBox root1 = new VBox();

        root1.setAlignment(Pos.CENTER);

        btnStart.setText("Start");
        btnIgraci.setText("Pregled igraca");
        btnKraj.setText("Kraj");
        root1.setStyle("-fx-background-color:#1DA1F2;");
        root1.setSpacing(8);
        root1.getChildren().addAll(btnStart, btnIgraci, btnKraj);

        return root1;

    }
}
