package controller;

import model.MyFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

import static controller.ControllerHOME.Start;

public class ContorllerShowJSON {
    @FXML
    TextArea TextJson;

    @FXML
    public void initialize() {
        TextJson.appendText("[\n");

        Start.format(new MyFormatter() {
            String From;

            @Override
            public String format(Object obj) {
                int n = 0;
                for (String key : Start.wordList()) {

                    From = String.format("\t{\n" + "\t\tvocab: " + '"' + "%s" + '"' + ",\n" + "\t\tPartOfSpeech: " + '"' + "%s" + '"' + ",\n" +
                                    "\t\tmeaning: " + '"' + "%s" + '"' + ",\n" +
                                    "\t\texample: " + '"' + "%s" + '"' + "\n\t},\n"
                            , Start.ShowWord(key), Start.ShowPartOfSpeech(key), Start.ShowMeaning(key), Start.ShowExample(key));
                    if (n != Start.wordList().size() - 1) {
                        TextJson.appendText(From);
                        n++;

                    } else {
                        String lastFrom = From.substring(0, From.length() - 2);
                        TextJson.appendText(lastFrom);
                    }
                }

                TextJson.appendText("\n]");
                return "";
            }
        });
    }


    @FXML
    public void Back(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/HOME.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 662, 770));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}
