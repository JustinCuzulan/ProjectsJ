/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs103.projekat1;

import java.util.ArrayList;

/**
 *
 * @author justincuzulan
 */
public class Queens {

    public ArrayList<int[]> AllQueenPosition;

    public Queens() {
        this.AllQueenPosition = new ArrayList<>();
    }

    public ArrayList<int[]> getAllQueenPosition() {
        return AllQueenPosition;
    }
    
    /*
    Vraca true ako je kraljica postavljena na mjesto 
    koje se ne konfliktuje sa ostalim kraljicama.
     */
    public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            //Da li se kraljice vertikalno napadaju
            if (q[i] == q[n]) { 
                return false;
            }
            //Provjerava da li se kraljice dijagonalno napadaju
            if (Math.abs(q[i] - q[n]) == (n - i)) {
                return false;
            }
        }
        return true;
    }

    public void solve() {
        int[] q = new int[8];
        this.AllQueenPosition.clear();
        solve(q, 0);
    }

    public void solve(int[] q, int k) {
        if (k == 8) {
            int[] newQ = new int[8];
            for(int i=0;i<8;i++){
                newQ[i]=q[i];
            }
            this.AllQueenPosition.add(newQ);

            return;
        } else {
            for (int i = 0; i < 8; i++) {
                q[k] = i;
                if (isConsistent(q, k)) {
                    solve(q, k + 1);
                }
            }
        }
    }
}
