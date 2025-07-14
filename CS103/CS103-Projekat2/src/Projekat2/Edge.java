/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat2;

/**
 *
 * @author justincuzulan
 */
public class Edge {

    String endNode;
    int weight;

    public Edge(String endNode, int weight) {
        this.endNode = endNode;
        this.weight = weight;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
