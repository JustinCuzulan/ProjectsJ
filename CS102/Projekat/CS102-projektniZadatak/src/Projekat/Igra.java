/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.security.auth.callback.TextInputCallback;

/**
 *
 * @author justincuzulan
 */
public class Igra extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VBox root1=new VBox();
        
        root1.setAlignment(Pos.CENTER);
        
        Button btnStart = new Button();
        Button btnPregledIgraca=new Button();
        Button btnIgraci=new Button();
        Button btnKraj=new Button();
        
        btnStart.setText("Start");
        btnPregledIgraca.setText("Pregled igraca (odigranih igara)");
        btnIgraci.setText("Pregled igraca");
        btnKraj.setText("Kraj");
        
        //ActionEvents
        //1
        btnStart.setOnAction(ev->{ 
            VBox VBIgraReci=new VBox();
            HBox HBIgraReci=new HBox();
            TextArea TAIzlazReci=new TextArea();
            Label lUnosReci=new Label("Unesite rec");
            TextField TFUnosReci=new TextField();
            Button btnPotvrdiRijec=new Button("Potvrdi");
            Button btnDalje=new Button("Dalje");
            
            
            HBIgraReci.setAlignment(Pos.BOTTOM_RIGHT); 
            HBIgraReci.getChildren().add(btnDalje);
           
            VBIgraReci.getChildren().addAll(TAIzlazReci,TFUnosReci,btnPotvrdiRijec,HBIgraReci);
            VBIgraReci.setAlignment(Pos.TOP_CENTER);
            
            Scene secondScene=new Scene(VBIgraReci,500,500);
            Stage secondStage=new Stage();
            secondStage.setScene(secondScene);
            secondStage.setTitle("Reci");
            secondStage.show();
            primaryStage.close();
            
            //KoZnaZna
            //2
            btnDalje.setOnAction(ev2->{
            VBox VBKoZnaZna=new VBox();
            HBox HBGornji=new HBox();
            HBox HBSrednji=new HBox();
            HBox HBDonji=new HBox();
            
            TextArea TAIzlazPitanja=new TextArea();
            Button btnA=new Button("A.");
            btnA.setId("1");
            Button btnB=new Button("B.");
            Button btnC=new Button("C.");
            Button btnD=new Button("D.");
            Button btnPotvrdiKoZnaZna=new Button("Potvrdi");
            Button btnDalje2=new Button("Dalje");
            PripremaZaIgru pripremaZaIgru=new PripremaZaIgru();
            pripremaZaIgru.setListuPitanja();
            Button nizBtn[]={btnA,btnB,btnC,btnD};
            for(int i=0;i<3;i++){
            TAIzlazPitanja.setText(pripremaZaIgru.getListaPitanja().get(i).getPitanje());
            for(int j=0;j<4;j++){
                nizBtn[j].setText(pripremaZaIgru.getListaPitanja().get(i).getPonudjeniOdgovor().get(j));
            }
            }
            HBGornji.getChildren().addAll(btnA,btnB);
            HBSrednji.getChildren().addAll(btnC,btnD);
            HBDonji.getChildren().add(btnDalje2);
            HBDonji.setAlignment(Pos.BOTTOM_RIGHT);
            HBGornji.setAlignment(Pos.CENTER);
            HBSrednji.setAlignment(Pos.CENTER);
            
            VBKoZnaZna.getChildren().addAll(TAIzlazPitanja,HBGornji,HBSrednji,btnPotvrdiKoZnaZna,HBDonji);
            Scene thirdScene=new Scene(VBKoZnaZna,500,500);
            Stage thirdStage=new Stage();
            thirdStage.setScene(thirdScene);
            thirdStage.setTitle("Ko Zna Zna");
            thirdStage.show();
            secondStage.close();
            
            //Asocijacije
            //3
            btnDalje2.setOnAction(ev3->{
                VBox VBAsocijacije=new VBox();
                HBox HBDonji3=new HBox();
                
                Button btnHint=new Button("HINT");
                TextField tfKonacanOdg=new TextField();
                Button btnPotvrdi=new Button("Potvrdi");
                TextArea TAHints=new TextArea();
                Button btnDalje3=new Button("Dalje");
                
                HBDonji3.getChildren().add(btnDalje3);
                HBDonji3.setAlignment(Pos.BOTTOM_RIGHT);
                VBAsocijacije.getChildren().addAll(TAHints,btnHint,tfKonacanOdg,btnPotvrdi,HBDonji3);
                VBAsocijacije.setAlignment(Pos.CENTER);
                
                Scene fourthScene=new Scene(VBAsocijacije);
                Stage fourthStage=new Stage();
                fourthStage.setScene(fourthScene);
                fourthStage.setTitle("Asocijacije");
                fourthStage.show();
                thirdStage.close();
                
                btnDalje3.setOnAction(ev4->{
                    VBox VBRezultati=new VBox();
                    HBox HBDonji4=new HBox();
                    
                    Label LRezultat=new Label("Rezultat");
                    Label LRijeci=new Label("Rijeci");
                    TextArea TARijeci=new TextArea();
                    Label LKoZnaZna=new Label("Ko zna zna");
                    TextArea TAKoZnaZna=new TextArea();
                    Label LAsocijacije=new Label("Asocijacije");
                    TextArea TAAsocijacije=new TextArea();
                    Label LUkupno=new Label("Ukupno");
                    TextArea TAUkupno=new TextArea();
                    Button btnKonacno=new Button("Konacno");
                    
                    HBDonji4.getChildren().add(btnKonacno);
                    HBDonji4.setAlignment(Pos.BOTTOM_RIGHT);
                    VBRezultati.getChildren().addAll(LRezultat,LRijeci,TARijeci,LKoZnaZna,TAKoZnaZna,LAsocijacije,TAAsocijacije,LUkupno,TAUkupno,HBDonji4);
                    VBRezultati.setAlignment(Pos.CENTER);
                    
                    Scene fifthScene=new Scene(VBRezultati);
                    Stage fifthStage=new Stage();
                    fifthStage.setScene(fifthScene);
                    fifthStage.setTitle("Rezultati");
                    fifthStage.show();
                    fourthStage.close();
                    
                    
                });
            });
            });
            
        });
        //2
        btnPregledIgraca.setOnAction(ev->{
            });
        //3
        btnIgraci.setOnAction(ev->{
        });
        //4
        btnKraj.setOnAction(ev->{ 
            primaryStage.close();
        });
            
        StackPane root = new StackPane();
        root1.getChildren().addAll(btnStart,btnPregledIgraca,btnIgraci,btnKraj);
        
        Scene scene = new Scene(root1, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
