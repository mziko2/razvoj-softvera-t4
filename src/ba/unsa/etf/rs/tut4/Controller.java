package ba.unsa.etf.rs.tut4;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    public Button btnDodajArtikle;
    public TextArea poljeUpisa;
    public TextArea poljePotvrdeUpisa;
    public Button btnDodajNaRacun;
    public Spinner<Integer> spiner;
    public TextArea poljePregled;
    public ChoiceBox<Artikal> choiceboks;
    public Racun racun ;

    public ObservableList <Artikal>  artikli =FXCollections.observableArrayList();
    public SimpleObjectProperty postojciArtikli = new SimpleObjectProperty("");
    public SimpleStringProperty trenutniRacun = new SimpleStringProperty("");

    public Controller(Racun racun) {
        this.racun=racun;
    }

    @FXML
    public void initialize(){
        poljePotvrdeUpisa.textProperty().bindBidirectional(postojciArtikli); // uspostavljena veza izmedju stringa koji ima nazive svih dadanih artikala
        choiceboks.setItems(artikli);
        poljePregled.textProperty().bindBidirectional(trenutniRacun); //uspostavljena veza izmedju trenutnog racuna i tekst polja za ispis racuna
    }



    public void dodajArtikle(ActionEvent actionEvent) {
        for (String s:poljeUpisa.getText().split("\\n") ) {
            String a[]=s.split(",");
            artikli.add(new Artikal(a[0],a[1],Double.parseDouble(a[2])));
        }
        Artikal.izbaciDuplikate(artikli);
        postojciArtikli.set(Artikal.IspisiArtikle(artikli));
    }

    public void selektujArtikl(ActionEvent actionEvent) {
        racun.setTrenutniArtikl(choiceboks.getValue());
        System.out.println(racun.getTrenutniArtikl());
    }
    public void dodajNaRacun(ActionEvent actionEvent) {
        racun.dodajStavku(racun.getTrenutniArtikl(),spiner.getValue());
        trenutniRacun.set(racun.toString());
        spiner.getValueFactory().setValue(1);
    }
}