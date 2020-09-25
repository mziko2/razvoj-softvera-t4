package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;

    String s;



    public Artikal(String ulaz) {
        String[] ulazi = ulaz.split(",");
        setSifra(ulazi[0]);
        setNaziv(ulazi[1]);
        setCijena((int) Double.parseDouble(ulazi[2]));

    }

    public double getCijena() {
        return cijena;
    }


    public void setCijena(double cijena) {
        this.cijena =  cijena;
        if (cijena <0) {
            throw new IllegalArgumentException("Unjeli se pogresnu cijenu");
        }
    }

    public Artikal(String hlb, String hljeb, double v) {

    }

    public String getSifra() {

        return sifra;
    }

    public void setSifra(String sifra) {

        this.sifra = sifra;
        if (sifra == null || sifra.isEmpty()) {
            throw new IllegalArgumentException("Unjeli ste pogresnu sifru");
        }
    }

    public String getNaziv() {

        return naziv;
    }

    public void setNaziv(String naziv) {

        this.naziv = naziv;
        if (naziv == null || naziv.isEmpty()) {
            throw new IllegalArgumentException("Unjeli ste pogresan naziv");
        }


    }


    @Override
    public String toString() {
        return sifra + ", " + naziv + ", " + cijena;
    }

    public boolean equals(Object o){
        Artikal artikal = (Artikal)o;
        if(!this.sifra.equals(artikal.getSifra())) return false;
        if(!this.naziv.equals(artikal.getNaziv())) return false;
        if(this.cijena!=artikal.getCijena()) return false;
        return true;


    }
    static void izbaciDuplikate(ArrayList<Artikal> lista){

        for(int i=0;i<lista.size();i++){
            for(int j=0;j<lista.size();j++){
                if(i!=j){
                    if(lista.get(i).equals(lista.get(j))){
                        lista.remove(j);
                    }

                }
            }
        }

    }
}


