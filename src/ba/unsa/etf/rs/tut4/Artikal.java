package ba.unsa.etf.rs.tut4;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Artikal {
    private SimpleStringProperty sifra,naziv;
    private SimpleDoubleProperty cijena;

    public Artikal(String sifra, String naziv, double cijena) {
        this.setSifra(sifra);
        this.setNaziv(naziv);
        this.setCijena(cijena);
    }

    public void setSifra(String sifra) {
        if(sifra.contentEquals("")) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra= new SimpleStringProperty(sifra);
    }

    public void setNaziv(String naziv) {
        if(naziv.contentEquals("")) throw  new IllegalArgumentException("Naziv je prazn");
        this.naziv= new SimpleStringProperty(naziv);
    }

    public void setCijena(double cijena) {
        if(cijena<=0) throw  new  IllegalArgumentException("Cijena je negativna");
        this.cijena = new SimpleDoubleProperty(cijena);
    }

    public String getSifra() {
        return sifra.get();
    }

    public SimpleStringProperty sifraProperty() {
        return sifra;
    }

    public String getNaziv() {
        return naziv.get();
    }

    public SimpleStringProperty nazivProperty() {
        return naziv;
    }

    public double getCijena() {
        return cijena.get();
    }

    public SimpleDoubleProperty cijenaProperty() {
        return cijena;
    }

    public String ArtiklIspis() {

        return this.naziv.get()+", "+this.sifra.get()+", "+ this.cijena.get()+"\n";
    }
    @Override
    public String toString() { //zbog potreba choiceboxa
        return this.sifra.get();
    }

    public  static <E>  void izbaciDuplikate (List<E> lista){
        for (int i=0;i<lista.size();i++){
            for (int j = i+1; j <lista.size() ; j++) {
                if(lista.get(i)!=lista.get(j) && lista.get(i).equals(lista.get(j))){
                    lista.remove(j);
                    j--;
                }
            }
        }
    }
    public static String IspisiArtikle(ObservableList<Artikal> ar){
        String s="";
        for (Artikal a :ar )
            s+= a.ArtiklIspis();
        return s;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj!=null && obj instanceof  Artikal){
            Artikal artikal = (Artikal)obj;
            return this.getCijena()==artikal.getCijena()  && this.getNaziv().contentEquals(artikal.getNaziv())
                    && this.getSifra().contentEquals(artikal.getSifra());
        }
        return  false;
    }
}