/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author justincuzulan
 * Klasa CitanjeURL je zaduzena za ucitavanje elemenata sa web stranice.
 */
public class CitanjeURL {

    static String rec;
    static List<Rijeci> listaRijeci=new ArrayList<Rijeci>();
    /**
     * Metod citanje je zaduzen za ucitavanje elemenata sa web stranice.
     * @return listaRijeci je Lista klase Rijeci.
     */
    public static List<Rijeci> citanje() {
        try {
        
            Document doc = Jsoup.connect("https://projekatcs102.wordpress.com/2021/08/20/kolekcija-reci-za-kviz/").get();
            Elements tmp = doc.select("body>#page> #content> #primary> #main> #post-16> .entry-content>p");
//            System.out.println(tmp);
            rec=tmp.html().replace("<p>", "").replace("</p>", "").replace("</br>", "").replace("<br>", "");
            String[] niz=rec.split("\\r?\\n");
            for(String s: niz){
                Rijeci r=new Rijeci(s); 
                listaRijeci.add(r);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return listaRijeci;
    }
}
