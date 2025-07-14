/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS101Projekat;

/**
 *
 * @author justi
 */
public enum OpcijeZaIgru {
    IGRAJ(0),
    STATISTIKA(1),
    MOJASTATISTIKA(2);

    private int br;

    private OpcijeZaIgru(int br) {
        this.br = br;
    }
    public static OpcijeZaIgru izBroja(int br){
        switch(br){
            case 0:
                return IGRAJ;
            case 1:
                return STATISTIKA;
            default:
                return MOJASTATISTIKA;
        }
    }
}
