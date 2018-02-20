package controller;

import model.MyFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import static controller.ControllerHOME.Start;
import java.io.IOException;

public class ControllerShowXML {
    @FXML
    TextArea TextXml ;

    @FXML
    public void initialize(){
        TextXml.appendText("<Dictionary>\n");
         Start.format(new MyFormatter() {
             String From ;
             @Override
            public String format(Object obj) {
                for (String v : Start.wordList()) {
                    From =
                            ("\t<Vocab word=" + "\"" + Start.ShowWord(v) + "\"" + ">" + "\n\t"
                            + "<PartOfSpeech>" + Start.ShowPartOfSpeech(v) + "</PartOfSpeech>" + "\n"
                            + "       " + "<Meaning>" + Start.ShowMeaning(v) + ";" + "</Meaning>" + "\n"
                            + "       " + "<Example>" + Start.ShowExample(v) + "</Example>" + "\n" +
                            "   " + "</Vocab>" + "\n" );
                    TextXml.appendText(From);

                }
                TextXml.appendText("<Dictionary>");
                return "";
            }
        });
    }

    @FXML
    public void Back(ActionEvent event){
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
