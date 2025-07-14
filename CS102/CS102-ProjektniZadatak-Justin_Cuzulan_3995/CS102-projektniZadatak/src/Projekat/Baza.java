/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justincuzulan
 * Klasa koja nam omogucava konekciju sa bazom podataka i manipulisanje podacima.
 * Objezbedjuje dodavanje, dohvatanje i update podataka.
 */
public class Baza {
    private static java.sql.Connection con = null;
    private static String url = "jdbc:mysql://localhost/igra";
    private static String username = "root";
    private static String password = "";

    /**
     * 
     * @param igrac je objekat kolasse Igrac.
     * Metod bi trebao da doda igraca u bazu.
     */
    public static void addIgrac(Igrac igrac) {
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement st = (Statement) con.createStatement();
            st.execute("INSERT INTO igrac (Ime,Sifra,Admin,BrojBodova)" + "VALUES ('" + igrac.getIme() + "','" + igrac.getPassword() + "','" + igrac.getAdmin() + "','" + igrac.getBrojBodova() + "')");
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Medot brisiIgraca je zaduzen za brisanje igraca po imenu.
     * @param ime je String u kojem se nalazi ime igraca.
     */
    public static void brisiIgraca(String ime){
        try {

            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM igrac WHERE Ime=?");
            ps.setString(1,ime);
    
            ps.execute();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Metod bi trebalo da dohvati sve igrace iz baze i smjesti ih u listu.
 * @return listaIgraca koja sadrzi igrace iz baze.
 */
    public static List<Igrac> dohvatiIgraca() {
        ArrayList<Igrac> listaIgraca = new ArrayList<Igrac>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM igrac";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String ime = rs.getString("Ime");
                String password = rs.getString("Sifra");
                int admin = rs.getInt("Admin");
                int brojBodova = rs.getInt("BrojBodova");
                listaIgraca.add(new Igrac(ime, password, admin, brojBodova));
            }
            st.close();
        } catch (SQLException ex0) {
            ex0.printStackTrace();
        }
        Collections.sort(listaIgraca);
        return listaIgraca;
    }
/**
 * Metod bi trebao da vrsi update igraca na osnovu njegovih svojstava.
 * @param Ime je String koji predstavlja ime igraca kojeg hocemo da update-ujemo.
 * @param Password je String koji predstavlja sifru igraca kojeg hocemo da update-ujemo.
 * @param Admin je int koji predstavlja...
 * @param BrojBodova je int koji predstavlja broj bodova igraca kojeg hocemo da updejtujemo.
 */
    public static void updateIgraca(String Ime, String Password, int Admin, int BrojBodova) {
        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE igrac SET BrojBodova=? WHERE Ime=?");
            ps.setInt(1,BrojBodova);
            ps.setString(2, Ime);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex9) {
            Logger.getLogger(Baza.class.getName()).log(Level.SEVERE, null, ex9);
        }
    }
/**
 *  Metod treba da dohvati pitanja, ponudjene odgovore i broj koji predstavlja tacan odgovor iz baze i smjesti ih u listu objekata tipa KoZnaZna.
 * @return Lista objekata tipa KoZnaZna dohvatiKoZnaZna vraca listu sa pitanjima, ponudjenim odgovorom i tacnim odgovorom.
 */
    public static List<KoZnaZna> dohvatiKoZnaZna() {
        ArrayList<KoZnaZna> listaKoZnaZna = new ArrayList<KoZnaZna>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM znanje";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //Kupi podatke iz tabele i smijesta ih u objekat KoZnaZna i njega u listu 
            while (rs.next()) {
                String pitanje = rs.getString("Pitanje");
                ArrayList<String> ponudjenOdgovor = new ArrayList<String>();
                ponudjenOdgovor.add(rs.getString("PonOdg1"));
                ponudjenOdgovor.add(rs.getString("PonOdg2"));
                ponudjenOdgovor.add(rs.getString("PonOdg3"));
                ponudjenOdgovor.add(rs.getString("PonOdg4"));
                int tacanOdgovor = rs.getInt("TacanOdgovor");
                listaKoZnaZna.add(new KoZnaZna(pitanje, ponudjenOdgovor, tacanOdgovor));
            }
            st.close();
        } catch (SQLException ex2) {
            ex2.printStackTrace();
        }
        return listaKoZnaZna;
    }
/**
 * Metod treba da dohvati odabranu rijec i cetiri ponudjena pojma.
 * @return Lisa objekata tipa asocijacije dohvatiAsocijacije vraca listu sa odabranom rijecju i cetiri ponudjena pojma.
 */
    public static List<Asocijacije> dohvatiAsocijacije() {
        ArrayList<Asocijacije> listaAsocijacija = new ArrayList<Asocijacije>();
        try {
            con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM Asocijacije";
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String odabrana = rs.getString("Konacno");
                ArrayList<String> ponudjeniPojam = new ArrayList<String>();
                ponudjeniPojam.add(rs.getString("Pojam1"));
                ponudjeniPojam.add(rs.getString("Pojam2"));
                ponudjeniPojam.add(rs.getString("Pojam3"));
                ponudjeniPojam.add(rs.getString("Pojam4"));
                listaAsocijacija.add(new Asocijacije(odabrana, ponudjeniPojam));
            }
            st.close();
        } catch (SQLException ex3) {
            ex3.printStackTrace();
        }
        return listaAsocijacija;
    }
}
