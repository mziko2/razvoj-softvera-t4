package ba.unsa.etf.rs.tut4;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start(Stage  stage) throws IOException {
        Racun racun= new Racun();
        Controller ctrl= new Controller(racun);
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/tutorijal.fxml"));
        loader.setController(ctrl);
        Parent root = loader.load();
        stage.setTitle("tutorijal 3");
        stage.setScene(new Scene(root, 500, 520));
        stage.setResizable(false);
        stage.show();
        stage.toFront();
    }
    @Test
    void unosArtikla(FxRobot robot){
        robot.clickOn("#poljeUpisa");
        robot.write("hljeb,hlj123,1\nmaslo,mas123," +
                "2\nriza, riz231,3");
        robot.clickOn("#btnDodajArtikle");
        TextArea polje=  robot.lookup("#poljePotvrdeUpisa").queryAs(TextArea.class);
        assertEquals("hlj123, hljeb, 1.0\n" +
                "mas123, maslo, 2.0\n" +
                " riz231, riza, 3.0\n", polje.getText());
    }
    @Test
    void testZadrugiTab(FxRobot robot){
        unosArtikla(robot);
        robot.lookup("#poljePregled").tryQuery().isPresent();
        robot.clickOn("#tab2");
        robot.clickOn("#choiceboks");
        robot.press(KeyCode.DOWN).release(KeyCode.DOWN).press(KeyCode.ENTER).release(KeyCode.ENTER);
        robot.clickOn("#spiner");
        robot.press(KeyCode.UP).press(KeyCode.UP).press(KeyCode.UP).release(KeyCode.UP).release(KeyCode.UP).release(KeyCode.UP);
        robot.clickOn("#btnDodajNaRacun");
        TextArea polje=robot.lookup("#poljePregled").queryAs(TextArea.class);
        assertEquals("maslo 2 4.0\n" +
                "UKUPNO 4.0",polje.getText());
    }
    @Test
    void pogledUchiceBox(FxRobot robot){
        testZadrugiTab(robot);
        ChoiceBox artikli=robot.lookup("#choiceboks").queryAs(ChoiceBox.class);
        assertNotNull(artikli);
        javafx.application.Platform.runLater(() -> artikli.show());
        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        robot.clickOn("#btnDodajNaRacun");
        TextArea polje=robot.lookup("#poljePregled").queryAs(TextArea.class);
        assertEquals("maslo 2 4.0\n" +
                "maslo 1 2.0\n" +
                "UKUPNO 6.0",polje.getText());

    }


}