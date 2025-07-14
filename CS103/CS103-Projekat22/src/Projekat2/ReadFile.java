/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat2;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files

public class ReadFile {

   static Map<String, int[]> posMap = new HashMap<String, int[]>();
     //Mora imati pored u,v i w dvije kordinate koje ce predstavljati
    //piksele odnosno poziciju na pane-u

    public static Graph readFile(String inp) throws FileNotFoundException {
        Graph g = new Graph();
        
        try {
            File myObj = new File(inp);
            Scanner myReader = new Scanner(myObj);
            boolean firstLine = true;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] s = data.split(" ");
                if (firstLine) {
                    int numNode = Integer.parseInt(s[0]);
                    
                    g.setV(numNode);
                    
                } else {
                    String startNode = (s[0]);
                    int x = Integer.parseInt(s[1]);
                    int y = Integer.parseInt(s[2]);
                    int[] coordinates = new int[2];
                    coordinates[0] = x;
                    coordinates[1] = y;
                    posMap.put(startNode, coordinates);
                    
                    for (int i = 3; i < s.length-1; i += 2) {

                        String endNode = s[i];
                        int w = Integer.parseInt(s[i + 1]);
                        g.addEdge(startNode, endNode, w);
                    }
                }
                firstLine = false;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
        return g;
    }

    public static Map<String, int[]> getPosMap() {
        return posMap;
    }

    public static void setPosMap(Map<String, int[]> posMap) {
        ReadFile.posMap = posMap;
    }
    
}
