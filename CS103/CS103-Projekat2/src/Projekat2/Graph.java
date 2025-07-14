/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

    private int V;
    private Map<String, ArrayList<Edge>> adjMap;
    private Map<String, String> parentsMap = new HashMap<>();

    public Graph() {
    }

    Graph(int v) {
        V = v;
    }

    void addEdge(String startNode, String endNode, int w) {
        Edge e = new Edge(endNode, w);
        if (adjMap.containsKey(startNode)) {
            adjMap.get(startNode).add(e);
        } else {
            ArrayList<Edge> eList = new ArrayList<>();
            eList.add(e);
            adjMap.put(startNode, eList);
        }

    }

    public List<String> getPath(String startNode, String endNode){

        Map<String, Integer> weights = new HashMap<String, Integer>();
        weights.put(startNode, 0);

        LinkedList<String> queue = new LinkedList<>();
        queue.add(startNode);
        // Sve dok ide queue znaci da ima cvorova unutra queua.
        // Ova petlja radi dok se queue ne isprazni.
        while (queue.size() != 0) {
            // .poll izvuce prvi sa liste.
            //curr sadrzi trenutni grad
            String curr = queue.poll(); //bileca
            //iterator prolazi kroz direktne susjede curr cvora
            //uzima trenutnog iz mape
            Iterator<Edge> i = adjMap.get(curr).listIterator();
            
            while (i.hasNext()) {
                //kupi redom edgeve (sastoji se od grada i tezine).
                Edge n = i.next();
                   
                //pitamo se da li smo ikada prije vidjeli iduci grad
                if (weights.containsKey(n.getEndNode())) {
                    //Ukoliko jesmo vijeli taj grad 
                    //pitamo se da li je to najefikasniji put
                    //mi smo sada na prvom gradu od pocetnog
                    //i sada se pitamo da li je vec postojeci put bolji
                    //od onog na koga upravo nailazimo

                    if (weights.get(n.getEndNode()) > weights.get(curr) + n.getWeight()) {
                        //ako jeste promijenimo vrijednost
                        weights.put(n.getEndNode(), weights.get(curr) + n.getWeight());
                        //ako smo nasli bolji put
                        parentsMap.put(n.getEndNode(), curr);
                        queue.add(n.getEndNode());
                        

                    }
                } else {
                    weights.put(n.getEndNode(), n.getWeight() + weights.get(curr));
                    //ubacujemo u mapu parenta
                    parentsMap.put(n.getEndNode(), curr);
                    queue.add(n.getEndNode());

                }

            }

        }

        List<String> path = new ArrayList<>();

        path.add(endNode);
        String tmpParent = "";
        while (!tmpParent.equals(startNode)) {

            tmpParent = parentsMap.get(endNode);
            endNode = tmpParent;
            path.add(tmpParent);

        }
        Collections.reverse(path);
        
        return path;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        this.V = v;
        adjMap = new HashMap<String, ArrayList<Edge>>();
    }

    public Map<String, ArrayList<Edge>> getAdjMap() {
        return adjMap;
    }

    public void setAdjMap(Map<String, ArrayList<Edge>> adjMap) {
        this.adjMap = adjMap;
    }

    public Map<String, String> getParentsMap() {
        return parentsMap;
    }

    public void setParentsMap(Map<String, String> parentsMap) {
        this.parentsMap = parentsMap;
    }

}
