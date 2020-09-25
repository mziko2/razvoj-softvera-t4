package ba.unsa.etf.rs.tut4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArtikalTest {

    @Test
    void getSifra() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals("ABC", a.getSifra());
    }

    @Test
    void setSifra() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setSifra("DEF");
        assertEquals("DEF", a.getSifra());
    }

    @Test
    void getNaziv() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals("Proizvod", a.getNaziv());
    }

    @Test
    void setNaziv() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setNaziv("Usluga");
        assertEquals("Usluga", a.getNaziv());
    }

    @Test
    void getCijena() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertEquals(100, a.getCijena());
    }

    @Test
    void setCijena() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        a.setCijena(2020.2);
        assertEquals(2020.2, a.getCijena());
    }

    @Test
    void ctorCijenaIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("ABC", "Proizvod", -5);
        }, "Cijena je negativna");
    }

    @Test
    void setCijenaIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setCijena(-1);
        }, "Cijena je negativna");
    }

    @Test
    void ctorSifraIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("", "Proizvod", -5);
        }, "Šifra je prazna");
    }

    @Test
    void setSifraIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setSifra("");
        }, "Šifra je prazna");
    }


    @Test
    void ctorNazivIzuzetak() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Artikal("ABC", "", -5);
        }, "Naziv je prazan");
    }

    @Test
    void setNazivIzuzetak() {
        Artikal a = new Artikal("ABC", "Proizvod", 100);
        assertThrows(IllegalArgumentException.class, () -> {
            a.setNaziv("");
        }, "Naziv je prazan");
    }

    @Test
    void testEquals() {
        Artikal a1 = new Artikal("ABC", "Proizvod", 100);
        Artikal a2 = new Artikal("ABC", "Proizvod", 100);
        assertTrue(a1.equals(a2));
        assertTrue(a2.equals(a1));
    }

    @Test
    void testNotEquals() {
        Artikal a1 = new Artikal("ABC", "Proizvod", 100);
        Artikal a2 = new Artikal("ABC", "Proizvod", 100);
        a2.setSifra("DEF");
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setSifra("ABC");
        a2.setNaziv("Usluga");
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setNaziv("Proizvod");
        a2.setCijena(100.1);
        assertFalse(a1.equals(a2));
        assertFalse(a2.equals(a1));
        a2.setCijena(100);
        assertTrue(a1.equals(a2));
        assertTrue(a2.equals(a1));
    }

    @Test
    void izbaciDuplikate() {
        ArrayList<Artikal> lista = new ArrayList<>();
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("DEF", "Usluga", 200));
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("ABC", "Proizvod", 100));
        lista.add(new Artikal("DEF", "Usluga", 200.2));
        lista.add(new Artikal("DEF", "Usluga", 200));
        Artikal.izbaciDuplikate(lista);
        assertEquals(3, lista.size());

        // Pošto nećemo da pravimo nikakve pretpostavke o redoslijedu nakon izbacivanja,
        // sada tražimo da li se u listi nalaze artikli
        assertTrue(lista.contains(new Artikal("ABC", "Proizvod", 100)));
        assertTrue(lista.contains(new Artikal("DEF", "Usluga", 200)));
        assertFalse(lista.contains(new Artikal("ABC", "Usluga", 100)));
        assertFalse(lista.contains(new Artikal("DEF", "Usluga", 100)));
    }

    @Test
    void izbaciDuplikateObservableList () {
        ObservableList<Artikal> lista = FXCollections.observableArrayList();

        lista.add(new Artikal("222D", "tesnje", 3.4));
        lista.add(new Artikal("111D", "jagode", 2));
        lista.add(new Artikal("222C", "jabuke", 1));
        lista.add(new Artikal("222C", "jabuke", 1));
        lista.add(new Artikal("222D", "tesnje", 3.4));
        lista.add(new Artikal("222V", "visnje", 3));
        lista.add(new Artikal("111A", "kruske",  5));
        Artikal.izbaciDuplikate(lista);
        assertEquals(5, lista.size());

        // Pošto nećemo da pravimo nikakve pretpostavke o redoslijedu nakon izbacivanja,
        // sada tražimo da li se u listi nalaze artikli
        assertTrue(lista.contains(new Artikal("222D", "tesnje", 3.4)));
        assertTrue(lista.contains(new Artikal("111D", "jagode", 2)));
        assertTrue(lista.contains(new Artikal("222C", "jabuke", 1)));
        assertTrue(lista.contains(new Artikal("222V", "visnje", 3)));
        assertTrue(lista.contains(new Artikal("111A", "kruske",  5)));

    }
    @Test
    void ispisiArtikl(){
        Artikal a = new Artikal("ja123","jabuka",3.4);
        assertEquals("jabuka, ja123, 3.4\n",a.ArtiklIspis());

    }
    @Test
    void objektiSeNemoguUporediti(){
        Artikal a = new Artikal("ja123","jabuka",3.4);
        assertEquals(false,a.equals(null));

    }
    @Test
    void ispisiArtikle(){
        ObservableList<Artikal> artikli= FXCollections.observableArrayList();
        artikli.add(new Artikal("tip500","brasno",2));
        artikli.add(new Artikal("tip520","brasno",22));
        artikli.add(new Artikal("co432","cokolada",1));
        assertEquals("brasno, tip500, 2.0\n" +
                "brasno, tip520, 22.0\n" +
                "cokolada, co432, 1.0\n",Artikal.IspisiArtikle(artikli));
    }
    @Test
    void testZaProperty_e(){
        Artikal a = new Artikal("ja123","jabuka",3.4);
        assertEquals("jabuka",a.nazivProperty().get());
        assertEquals("ja123",a.sifraProperty().get());
        assertEquals(3.4,a.cijenaProperty().get());
    }
    @Test
    void  provjeraIspisToString(){
        Artikal a = new Artikal("kr98","kruska",3.2);
        assertEquals("kr98",a.toString());

    }
}