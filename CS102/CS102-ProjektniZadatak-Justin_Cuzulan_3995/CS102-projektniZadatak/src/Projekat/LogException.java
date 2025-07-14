/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

/**
 *
 * @author justincuzulan
 * Klasa LogExceptipon je specijalna klasa za obradu izuzetaka prilikom provjere podataka.
 */
public class LogException extends Exception{
/**
 * 
 */
    public LogException() {
    }
/**
 * 
 * @param string sadrzi objekat klase String
 */
    public LogException(String string) {
        super(string);
    }
/**
 * 
 * @param string sadrzi objekat klase String
 * @param thrwbl sadrzi objekat klase Throwable
 */
    public LogException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
/**
 * 
 * @param thrwbl sadrzi objekat klase Throwable
 */
    public LogException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
