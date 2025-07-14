/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs103.projekat1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author justincuzulan
 */
public class Display extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Queens queens = new Queens();
        queens.solve();
        ArrayList<int[]> solutions = queens.getAllQueenPosition();
        
        Image image = new Image(new FileInputStream("image/queen.png"));
        HBox root = new HBox();

        for (int a = 0; a < solutions.size(); a++) {
            VBox labelBoard = new VBox();
            GridPane board = new GridPane();

            labelBoard.getChildren().add(new Label("SOLUTION " + (a + 1)));
            int count = 0;
            double s = 50;
            for (int i = 0; i < 8; i++) {
                count++;
                for (int j = 0; j < 8; j++) {

                    Rectangle r = new Rectangle(s, s, s, s);
                    if (count % 2 == 0) {
                        r.setFill(Color.WHITE);
                    }
                    if (j == (solutions.get(a))[i]) {
                        StackPane stackPane = new StackPane();
                        stackPane.setPrefSize(50, 50);
                        ImageView imageView = new ImageView(image);
                        imageView.setFitHeight(50);
                        imageView.setFitWidth(50);

                        stackPane.getChildren().addAll(r, imageView);

                        board.add(stackPane, j, i);
                    } else {
                        board.add(r, j, i);
                    }
                    count++;

                }

            }
            labelBoard.getChildren().add(board);

            root.getChildren().add(labelBoard);
        }

        root.setSpacing(50);
        root.setPadding(new Insets(10));
        ScrollPane sp = new ScrollPane();
        sp.setContent(root);

        Scene scene = new Scene(sp);
        primaryStage.setTitle("Multiple Queens");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
