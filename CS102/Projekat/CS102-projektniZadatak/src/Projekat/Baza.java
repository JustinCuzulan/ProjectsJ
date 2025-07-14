/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justincuzulan
 */
public class Baza {
    private static java.sql.Connection con=null;
    private static String url="jdbc:mysql://localhost/igra";
    private static String username="root";
    private static String password="";
    
    public static void addIgrac(Igrac igrac){
       try{
           con=DriverManager.getConnection(url,username,password);
           Statement st=(Statement) con.createStatement();
           st.execute("INSERT INTO igrac (ime)"+"VALUES ('"+igrac.getIme()+"')");
           con.close();
           
       }catch(SQLException ex){
           Logger.getLogger(Baza.class.getName()).log(Level.SEVERE,null,ex);
       }
    }
    public static List<KoZnaZna> dohvatiKoZnaZna(){
        ArrayList<KoZnaZna> listaKoZnaZna=new ArrayList<KoZnaZna>();
        try{
            con=DriverManager.getConnection(url,username,password);
            String query="SELECT * FROM koZnaZna";
            Statement st=(Statement) con.createStatement();
            ResultSet rs=st.executeQuery(query);
            //Kupi podatke iz tabele i smijesta ih u objekat KoZnaZna i njega u listu 
            while(rs.next()){
                String pitanje=rs.getString("Pitanje");
                ArrayList<String>ponudjenOdgovor=new ArrayList<String>();
                ponudjenOdgovor.add(rs.getString("PonOdg1"));
                ponudjenOdgovor.add(rs.getString("PonOdg2"));
                ponudjenOdgovor.add(rs.getString("PonOdg3"));
                ponudjenOdgovor.add(rs.getString("PonOdr4"));
                int tacanOdgovor=rs.getInt("TacanOdgovor");
                listaKoZnaZna.add(new KoZnaZna(pitanje,ponudjenOdgovor,tacanOdgovor));
            }
            st.close();
        }catch(SQLException ex2){
            ex2.printStackTrace();
        }
        return listaKoZnaZna;
    }
    public static List<Asocijacije> dohvatiAsocijacije(){
        ArrayList<Asocijacije>listaAsocijacija=new ArrayList<Asocijacije>();
        try{
            con=DriverManager.getConnection(url,username,password);
            String query="SELECTI * FROM Asocijacije";
            Statement st=(Statement)con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                String odabrana=rs.getString("Konacno");
                ArrayList<String> ponudjeniPojam=new ArrayList<String>();
                ponudjeniPojam.add(rs.getString("Pojam1"));
                ponudjeniPojam.add(rs.getString("Pojam2"));
                ponudjeniPojam.add(rs.getString("Pojam3"));
                ponudjeniPojam.add(rs.getString("Pojam4"));
                listaAsocijacija.add(new Asocijacije(odabrana,ponudjeniPojam));
            }
            st.close();
        }catch(SQLException ex3){
            ex3.printStackTrace();
        }
        return listaAsocijacija;
    }
}
