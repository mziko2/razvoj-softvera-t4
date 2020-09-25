package ba.unsa.etf.rs.tut4;

import com.sun.glass.ui.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("Sretan rad na tutorijalu 4!");
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Tut3");
        stage.setScene(new Scene(root,620, 400));
        stage.show();

    }

}
