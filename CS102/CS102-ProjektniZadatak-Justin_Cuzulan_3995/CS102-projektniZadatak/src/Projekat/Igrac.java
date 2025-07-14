/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projekat;

/**
 *
 * @author justincuzulan
 * Predstavlja igraca koji igra ovu igru.
 *
 */
public class Igrac implements Comparable<Igrac>{
    /**
     * Igrac ima String ime, u kojem je smjesteno njegovo ime; String password u kojem je smjestena sifra neophodna da se igrac uloguje;
     * int admin koji je setovan na 0, svi igraci se po defaultu setuju na 0; int brojBodova, igrac pocinje sa 0 bodova na pocetku igre.
     * 
     */
    private String ime;
    private String password="";
    private int admin=0;
    private int brojBodova=0;
/**
 * Podrazumijevani konstruktor.
 */
    public Igrac() {
    }
/**
 * 
 * @param ime u njemu je smjesteno ime igraca.
 * @param password u njemu je smjesten password igraca.
 */
    public Igrac(String ime,String password) {
        this.ime = ime;
        this.password=password;
        
    }
/**
 * 
 * @param ime String koji predstavlja ime igraca.
 * @param password String na koji se postavlja password igraca.
 * @param admin --
 * @param brojBodova int na koji se postavlja broj bodova igraca.
 */
    public Igrac(String ime, String password, int admin,int brojBodova) {
        this.ime = ime;
        this.password = password;
        this.admin = admin;
        this.brojBodova=brojBodova;
    }
/**
 * 
 * @return ime, vraca ime igraca.
 */
    public String getIme() {
        return ime;
    }
/**
 * 
 * @return getPassword, vraca sifru igraca.
 */
    public String getPassword() {
        return password;
    }
/**
 * 
 * @return admin, vraca da li je igrac admin ili ne.
 */
    public int getAdmin() {
        return admin;
    }
    
/**
 * 
 * @return vraca broj bodova igraca.
 */
    public int getBrojBodova() {
        return brojBodova;
    }
/**
 * 
 * @param ime String na koji se postavlja vrijednost ime.
 */
    public void setIme(String ime) {
        this.ime = ime;
    }
/**
 * 
 * @param password, postavlja se njegova sifra.
 */
    public void setPassword(String password) {
        this.password = password;
    }
/**
 * 
 * @param admin, postavlja se da li ima adminkse privilegije ili ne.
 */
    public void setAdmin(int admin) {
        this.admin = admin;
    }
/**
 * 
 * @param brojBodova, postavlja se njegov broj bodova.
 */
    public void setBrojBodova(int brojBodova) {
        this.brojBodova = brojBodova;
    }
 
    @Override
    public String toString() {
        return "ime: " + ime +  ", broj bodova: " + brojBodova +'\n';
    }
    /**
     * 
     * @param o je objekat za podjenje.
     * @return true ili false u zavisnosti da li su dva igraca ista ili ne.
     * ovaj metod je iskoristen za prijavljivanje igraca, tj. provjeru da li jedan takav igrac vec postoji u bazi.
     */
    public boolean equals(Object o){
        Igrac igractmp=(Igrac)o;
        if(igractmp.getIme().equals(this.getIme())&& igractmp.getPassword().equals(this.getPassword())){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 
     * @param x metod cijim se pozivom dodaje odredjen broj bodova.
     */
    public void povecajBrojBodova(int x){
        this.brojBodova+=x;
    }
/**
 * 
 * @param o je objekat za poredjenje.
 * @return njegova povratna vrijednost omogucava programu da poreda igrace po bodovima od najvise ka najmanje bodova.
 */
    @Override
    public int compareTo(Igrac o) {
        return -Integer.compare(this.getBrojBodova(), o.getBrojBodova());
    }
    
    
    
}
