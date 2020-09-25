package ba.unsa.etf.rs.tut4;


import java.util.ArrayList;


public class Racun {

    private ArrayList<Stavka> stavke;

    public Racun() {
        stavke = new ArrayList<>();

    }

    public void dodajStavku(Artikal artikal, int kolicina) {
        stavke.add(new Stavka(artikal, kolicina));
    }

    public double ukupanIznos() {
        double iznos = 0;
        for (Stavka s : stavke) {
            iznos += s.kolicina * s.artikal.getCijena();

        }
        return iznos;
    }

    private class Stavka {
        int kolicina;
        Artikal artikal;

        Stavka() {
        }

        Stavka(Artikal art, int kol) {
            artikal = art;
            kolicina = kol;
        }

        public String toString() {
            String str = "";

            for (Stavka s : stavke) {
                str += String.format("%-8s %-4d %.2f\n", s.artikal.getSifra(), s.kolicina, s.kolicina * s.artikal.getCijena());

            }
            str += String.format("%-12s %.2f", "UKUPNO", ukupanIznos());
            return str;
        }
    }

}

