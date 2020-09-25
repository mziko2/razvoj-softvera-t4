package ba.unsa.etf.rs.tut4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Racun racun= new Racun();
        Controller ctrl= new Controller(racun);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/tutorijal.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        primaryStage.setTitle("tutorijal 4");
        primaryStage.setScene(new Scene(root, 500, 520));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}