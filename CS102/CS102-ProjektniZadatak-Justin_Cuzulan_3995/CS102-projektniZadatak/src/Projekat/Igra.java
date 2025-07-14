/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Klasa Igra je zaduzena za pozivanje i prikazivanje elemenata.
 * @author justincuzulan
 */
public class Igra extends Application {
/**
 * Metod start u scenu poziva i smijesta elemente iz klase PocetakFX. Zaduzen je za prikazivanje.
 * @param primaryStage je objekat tipa Stage
 */
    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(PocetakFX.prikaziPocetak(), 300, 250);

        primaryStage.setTitle("Kviz");
        primaryStage.setScene(scene);
        primaryStage.show();

        PocetakFX.btnStart.setOnAction(ev -> {
            Scene zeroScene = new Scene(LogFX.prikaziLog());
            primaryStage.setScene(zeroScene);
            primaryStage.setTitle("LOG");
            primaryStage.show();

        });
        
        LogFX.btnAdminBrisanje.setOnAction(ev->{
            Scene zeroScene = new Scene(AdminBrisanjeFX.brisanjePrikaz(),200,200);
            primaryStage.setScene(zeroScene);
            primaryStage.setTitle("Brisanje");
            primaryStage.show();
        });
        AdminBrisanjeFX.btnNazad.setOnAction(ev->{
            Scene zeroScene = new Scene(LogFX.prikaziLog());
            primaryStage.setScene(zeroScene);
            primaryStage.setTitle("LOG");
            primaryStage.show();
        });
        PocetakFX.btnIgraci.setOnAction(ev0 -> {
            Scene playerScene = new Scene(TabelaIgracaFX.prikazIgraca(), 250, 500);

            primaryStage.setScene(playerScene);
            primaryStage.setTitle("Igraci");
            primaryStage.show();
        });
        TabelaIgracaFX.btnNazad.setOnAction(ev0 -> {

            primaryStage.setTitle("Kviz");
            primaryStage.setScene(new Scene(PocetakFX.prikaziPocetak(), 300, 250));
            primaryStage.show();
        });

        PripremaZaIgru pripremaZaIgru = new PripremaZaIgru();
        LogFX.btnDaljeIgrac.setOnAction(ev2 -> {
            ReciFX.btnPotvrdiRijec.setDisable(false);
            ReciFX.btnPotvrdiRijec.setStyle("");

            pripremaZaIgru.setRijec();
            Igrac igracF = LogFX.igracTmp;

            Scene secondScene = new Scene(ReciFX.prikaziReci(pripremaZaIgru, igracF), 500, 150);

            primaryStage.setScene(secondScene);
            primaryStage.setTitle("Reci");
            primaryStage.show();
        });
        ReciFX.btnDalje.setOnAction(ev3 -> {
            pripremaZaIgru.setListuPitanja();
            Igrac igracF = LogFX.igracTmp;

            Scene thirdScene = new Scene(KoZnaZnaFX.prikaziKoZnaZna(pripremaZaIgru, igracF));

            primaryStage.setScene(thirdScene);
            primaryStage.setTitle("Ko Zna Zna");
            primaryStage.show();

        });

        KoZnaZnaFX.btnDalje2.setOnAction(ev4 -> {
            pripremaZaIgru.setAsocijacije();
            Igrac igracF = LogFX.igracTmp;

            Scene fourthScene = new Scene(AsocijacijeFX.prikaziAsocijacije(pripremaZaIgru, igracF));

            primaryStage.setScene(fourthScene);
            primaryStage.setTitle("Asocijacije");
            primaryStage.show();

        });

        AsocijacijeFX.btnDalje3.setOnAction(ev5 -> {

            Scene fifthScene = new Scene(TabelaRezultataFX.prikaziRezultate(LogFX.igracTmp), 250, 350);

            primaryStage.setScene(fifthScene);
            primaryStage.setTitle("Rezultati");
            primaryStage.show();

        });
        TabelaRezultataFX.btnKonacno.setOnAction(ev6 -> {
            Scene scene1 = new Scene(PocetakFX.prikaziPocetak(), 300, 250);

            primaryStage.setTitle("Kviz");
            primaryStage.setScene(scene1);
            primaryStage.show();

        });
        PocetakFX.btnKraj.setOnAction(ev7 -> {
            primaryStage.close();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
