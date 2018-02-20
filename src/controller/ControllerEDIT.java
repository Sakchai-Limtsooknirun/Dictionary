package controller;

import model.Vocabulary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

import static controller.ControllerHOME.Start;

public class ControllerEDIT {
    @FXML
    TextField inputword ;
    @FXML
    TextField inputpos ;
    @FXML
    TextField inputmeaning ;
    @FXML
    TextField inputexample ;
    @FXML
    TextField inputpostword;
    @FXML
    Label status;


    @FXML
    public void EDIT(ActionEvent event){
        if (inputword.getLength()!=0 && inputpostword.getLength()!=0){
            System.out.println(inputword.getLength());
            Start.remove(inputpostword.getText());
            Start.add(inputword.getText(),new Vocabulary(inputword.getText(),inputpos.getText(),inputmeaning.getText(),inputexample.getText()));
            Back(event);
        }else status.setText("Please fill PostWord and NewWord");
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
