package ba.unsa.etf.rs.tut4;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

import static java.lang.StrictMath.round;

public class Racun {
    private ObservableList<Stavke> racun= FXCollections.observableArrayList();
    private SimpleObjectProperty<Artikal> trenutniArtikl=new SimpleObjectProperty<>();


    private class Stavke{
        Artikal artikal;
        int kolicina;
        public Stavke(Artikal artikal, int kolicina) {
            setArtikal( artikal);
            setKolicina(kolicina);
        }

        public void setArtikal(Artikal artikal) {
            this.artikal = artikal;
        }

        public void setKolicina(int kolicina) {
            this.kolicina = kolicina;
        }

        public Artikal getArtikal() {
            return artikal;
        }

        public int getKolicina() {
            return kolicina;
        }
    }

    public void setTrenutniArtikl(Artikal trenutniArtikl) {
        this.trenutniArtikl.set(trenutniArtikl);
    }

    public Artikal getTrenutniArtikl() {
        return this.trenutniArtikl.get();
    }

    public SimpleObjectProperty<Artikal> trenutniArtiklProperty() {
        return trenutniArtikl;
    }

    public  void dodajStavku(Artikal artikal, int kolicina){
        this.racun.add(new Stavke(artikal, kolicina));
    }

    public  double ukupanIznos(){
        double suma=0;
        for (int i = 0; i <racun.size() ; i++) {
            suma+=racun.get(i).getArtikal().getCijena()*racun.get(i).getKolicina();
        }
        return  suma;
    }

    @Override
    public String toString() {
        String s="";
        double suma=0;
        for (int i=0;i<racun.size();i++){
            suma+=racun.get(i).getKolicina()*racun.get(i).getArtikal().getCijena();
            s+=racun.get(i).getArtikal().getSifra()+" "+racun.get(i).getKolicina()+" "+racun.get(i).getKolicina()*racun.get(i).getArtikal().getCijena() +"\n";
        }
        s+="UKUPNO "+suma;
        return s;
    }
}