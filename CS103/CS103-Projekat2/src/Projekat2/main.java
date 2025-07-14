/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author justincuzulan
 * /Users/justincuzulan/NetBeansProjects/CS103-Projekat2/src/Projekat2/graph.txt
 */
public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox vBFileName = new VBox();
        Label lFileName = new Label("Set absolute path to file");
        TextField tfFileName = new TextField();
        Button bSubmitFN = new Button("Submit");
        Text noFile = new Text();
        vBFileName.getChildren().addAll(lFileName, tfFileName, bSubmitFN, noFile);
        vBFileName.setAlignment(Pos.CENTER);

        bSubmitFN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Graph g;
                try {
                    g = ReadFile.readFile(tfFileName.getText());

                    VBox vbox = new VBox(500);
                    Pane root = new Pane();
                    Group lineGroup = new Group();
                    

                    Map<String, ArrayList<Edge>> adjMap = g.getAdjMap();
                    Map<String, int[]> posMap = ReadFile.getPosMap();

                    drawCircles(root, posMap);
                    drawLines(root, adjMap, posMap);

                    HBox optionArea = new HBox();
                    optionArea.setAlignment(Pos.CENTER);

                    Label lStartNode = new Label("Start City");
                    TextField tfStartNode = new TextField();

                    Label lEndNode = new Label("End City");
                    TextField tfEndNode = new TextField();

                    Text noCity = new Text();

                    Button findPath = new Button("Find Path");
                    findPath.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            if (posMap.containsKey(tfStartNode.getText()) && posMap.containsKey(tfEndNode.getText())) {
                                noCity.setText("");
                                List<String> path = g.getPath(tfStartNode.getText(), tfEndNode.getText());

                                for (int i = 0; i < path.size() - 1; i++) {
                                    int startX = posMap.get(path.get(i))[0];
                                    int startY = posMap.get(path.get(i))[1];
                                    int endX = posMap.get(path.get(i + 1))[0];
                                    int endY = posMap.get(path.get(i + 1))[1];

                                    Line connectionPath = new Line(startX, startY, endX, endY);
                                    connectionPath.setStroke(Color.RED);
                                    lineGroup.getChildren().add(connectionPath);
                                }

                            } else {
                                noCity.setText("City not found");
                            }

                        }

                    });
                    Button bReset = new Button("Reset");
                    bReset.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            
                            lineGroup.getChildren().clear();

                        }

                    });
                    root.getChildren().add(lineGroup);
                    /*
        Treba dodati da crta promijeni boju
        uzeti mapu parents i po toj putanji promijeniti 
        boju znaci za svaku putanju na koju smo naisli promijenimo boju
                     */
                    optionArea.getChildren().addAll(lStartNode, tfStartNode, lEndNode, tfEndNode, findPath, bReset, noCity);
                    vbox.getChildren().addAll(root, optionArea);

                    Scene scene = new Scene(vbox,600,750);

                    primaryStage.setTitle("Path Finder");
                    primaryStage.setScene(scene);
                    primaryStage.show();

                } catch (FileNotFoundException ex) {
                    noFile.setText("File not Found!");
                }
            }

        });
        Scene scene = new Scene(vBFileName, 300, 100);

        primaryStage.setTitle("Path Finder");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void drawCircles(Pane root, Map<String, int[]> posMap) {
        //Prolazimo kroz posMap
        for (Map.Entry<String, int[]> entry : posMap.entrySet()) {

            Circle c = new Circle(10);
            c.setCenterX(entry.getValue()[0]);
            c.setCenterY(entry.getValue()[1]);

            Text lCity = new Text(entry.getKey());
            lCity.setLayoutX(c.getCenterX() - 5);
            lCity.setLayoutY(c.getCenterY() - 10);
            Group group = new Group();

            group.getChildren().addAll(c, lCity);
            root.getChildren().addAll(group);
        }
    }

    public static void drawLines(Pane root, Map<String, ArrayList<Edge>> adjMap, Map<String, int[]> posMap) {

        for (Map.Entry<String, ArrayList<Edge>> entry1 : adjMap.entrySet()) {
            String startNode = entry1.getKey();
            int startX = posMap.get(startNode)[0];
            int startY = posMap.get(startNode)[1];

            for (Edge e : entry1.getValue()) {
                String endNode = e.getEndNode();
                int endX = posMap.get(endNode)[0];
                int endY = posMap.get(endNode)[1];
                Line connection = new Line(startX, startY, endX, endY);
                Text lineWeight = new Text(e.getWeight() + "");

                lineWeight.setLayoutX(((startX + endX) / 2.0) + 5);
                lineWeight.setLayoutY(((startY + endY) / 2.0) + 5);
                Group group1 = new Group();
                group1.getChildren().addAll(connection, lineWeight);

                root.getChildren().addAll(group1);

            }

        }
    }
}
