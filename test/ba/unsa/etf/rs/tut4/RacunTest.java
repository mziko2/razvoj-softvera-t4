package ba.unsa.etf.rs.tut4;

import javafx.beans.property.SimpleObjectProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacunTest {

    @Test
    void test1() {
        Racun r = new Racun();
        r.dodajStavku(new Artikal("HLB", "Hljeb", 1.1), 2);
        r.dodajStavku(new Artikal("JAJ", "Jaje", 0.25), 5);
        assertEquals(3.45, r.ukupanIznos());
    }

    @Test
    void testPrazno() {
        Racun r = new Racun();
        assertEquals(0, r.ukupanIznos());
    }
    @Test
    void postaviTrenutniArtikl(){
        Racun r= new Racun();
        r.setTrenutniArtikl(new Artikal("tip 500","brasno",20));
        Artikal s= new Artikal("tip 500","brasno",20);
        assertTrue( s.equals(r.getTrenutniArtikl()));
    }
    @Test
    void ispisArtikalaNaRacunu(){
        Racun r= new Racun();
        r.dodajStavku(new Artikal("tip500","brasno",20),1);
        r.dodajStavku(new Artikal("tip520","brasno",22),3);
        r.dodajStavku(new Artikal("co432","cokolada",1),5);
        assertEquals("tip500 1 20.0\n" +
                "tip520 3 66.0\n" +
                "co432 5 5.0\n" +
                "UKUPNO 91.0",r.toString());
    }
    @Test
    void porovjeraSimpleProperty_a(){
        Racun r= new Racun();
        r.setTrenutniArtikl(new Artikal("sir321","sirup",20));
        Artikal s= new Artikal("sir321","sirup",20);
        SimpleObjectProperty<Artikal> ar= new SimpleObjectProperty<>(s);
        assertEquals(r.trenutniArtiklProperty().get().getNaziv(), ar.get().getNaziv());
    }


}