package ba.unsa.etf.rs.tut4;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea rezultat;
    public TextArea unos;
    public ChoiceBox<Artikal> cdartikli;
    public Spinner<Integer> spkolicina;
    public TextArea aktuelniRacun;
    private ArrayList<Artikal> artikli= new ArrayList<>();
    private ObservableList<Artikal> observableList= FXCollections.observableArrayList();
    private Racun racun= new Racun();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        observableList.setAll(artikli);
        cdartikli.setItems(observableList);

    }

    public void Dodaj(ActionEvent actionEvent) {
        String[] artikliStr = unos.getText().split("\n");
        for(String linija : artikliStr)
            artikli.add(new Artikal(linija));
        Artikal.izbaciDuplikate(artikli);
        observableList.clear();
        observableList.setAll(artikli);
        String res= "";
        for(Artikal artikal : artikli){
            res+=artikal + "\n";
        }

        rezultat.setText(res);

    }

    public void obracunaj(ActionEvent actionEvent) {
        Artikal trenutni=cdartikli.getSelectionModel().getSelectedItem();
        int kolicna=spkolicina.getValue();
        racun.dodajStavku(trenutni, kolicna);
    }



    private class Stavka{
        int kolicina;
        Artikal artikal;
        Stavka(){

        }
        Stavka(Artikal art, int kol){
            artikal=art;
            kolicina=kol;
        }


    }
}
