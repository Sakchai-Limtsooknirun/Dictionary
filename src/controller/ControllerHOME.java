package controller;

import model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerHOME {

    public static Dictionary Start = new Dictionary();
    @FXML
    Label showValue;
    @FXML
    TextField inputword;
    @FXML
    TextField inputpos;
    @FXML
    TextField inputmeaning;
    @FXML
    TextField inputexample;
    @FXML
    TableView<TableRecord> showDic;

    @FXML
    private final ObservableList<TableRecord> data = FXCollections.observableArrayList();

    @FXML
    TableColumn vocabColumn;
    @FXML
    TableColumn posColumn;
    @FXML
    TableColumn meaningColumn;
    @FXML
    TableColumn exampleColumn;
    @FXML
    TextField SearchField;

    @FXML
    public void initialize() {
        Start.add("Fish",new Vocabulary("Fish","Verb","ปลา","Fish is Good"));
        Start.add("Pig",new Vocabulary("Pig","Verb","หมู","Pig is Good"));
        Start.add("Dog",new Vocabulary("Dog","Verb","หมา","Dog is Good"));
        Start.add("Chicken",new Vocabulary("Chicken","Verb","ไก่","Chicken is Good"));
        Start.add("Car",new Vocabulary("Car","Verb","รถยนตร์","Car is Good"));
        vocabColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("vocab"));
        posColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("partOfSpeech"));
        meaningColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("meaning"));
        exampleColumn.setCellValueFactory(new PropertyValueFactory<TableRecord, String>("example"));
        showDic.setItems(data);
        showTable();

    }

    @FXML
    public void add(ActionEvent event) {
        if (inputword.getText().equals("") || inputpos.getText().equals("") ||
                inputmeaning.getText().equals("") || inputexample.getText().equals("")) {
            showValue.setText("Plase Fill all TextField ");
        } else if (Start.contains(inputword.getText()) == false) {
            Start.add(inputword.getText(), new Vocabulary(inputword.getText(),
                    inputpos.getText(), inputmeaning.getText(), inputexample.getText()));
            inputword.clear();
            inputpos.clear();
            inputmeaning.clear();
            inputexample.clear();
            showTable();
        } else showValue.setText("This Word is Same in Dictionary");
    }

    @FXML
    public void Search(ActionEvent event) {
        try {
            showValue.setText(Start.toString(SearchField.getText()));
            SearchField.clear();
        } catch (Exception E) {
            showValue.setText("Cannot search this word in Dictionary!");
        }
    }

    @FXML
    public void editNextPage(ActionEvent event) {

        if (Start.size() != 0) {
            Button b = (Button) event.getSource();
            Stage stage = (Stage) b.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/EDIT.fxml"));
            try {
                stage.setScene(new Scene(loader.load(), 600, 400));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } else showValue.setText("Dictionary is Empty");

    }
    @FXML
    public void XmlNextpage(ActionEvent event){
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/XMLShow.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 590, 400));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void JsonNextpage(ActionEvent event){
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/JSONShow.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 590, 400));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void Delete(ActionEvent event) {
        if (inputpos.getText().equals("") ||
                inputmeaning.getText().equals("") || inputexample.getText().equals("")) {
            Start.remove(inputword.getText());
            inputword.clear();
            showTable();
        } else showValue.setText("Plase Fill Only Word");
    }


    private void showTable() {
        data.clear();
        for (String word : Start.wordList()) {
            data.add(new TableRecord(word, Start.ShowPartOfSpeech(word), Start.ShowMeaning(word), Start.ShowExample(word)));
        }
    }

    public static class TableRecord {
        private final SimpleStringProperty vocab;
        private final SimpleStringProperty partOfSpeech;
        private final SimpleStringProperty meaning;
        private final SimpleStringProperty example;

        public TableRecord(String vocab, String partOfSpeech, String meaning, String example) {
            this.vocab = new SimpleStringProperty(vocab);
            this.partOfSpeech = new SimpleStringProperty(partOfSpeech);
            this.meaning = new SimpleStringProperty(meaning);
            this.example = new SimpleStringProperty(example);
        }

        public TableRecord(String word, Vocabulary vocabulary) {
            vocab = new SimpleStringProperty(word);
            partOfSpeech = new SimpleStringProperty(vocabulary.getPartOfSpeech());
            meaning = new SimpleStringProperty(vocabulary.getMeaning());
            example = new SimpleStringProperty(vocabulary.getExample());
        }

        public String getVocab() {
            return vocab.get();
        }

        public SimpleStringProperty vocabProperty() {
            return vocab;
        }

        public void setVocab(String vocab) {
            this.vocab.set(vocab);
        }

        public String getPartOfSpeech() {
            return partOfSpeech.get();
        }

        public SimpleStringProperty partOfSpeechProperty() {
            return partOfSpeech;
        }

        public void setPartOfSpeech(String partOfSpeech) {
            this.partOfSpeech.set(partOfSpeech);
        }

        public String getMeaning() {
            return meaning.get();
        }

        public SimpleStringProperty meaningProperty() {
            return meaning;
        }

        public void setMeaning(String meaning) {
            this.meaning.set(meaning);
        }

        public String getExample() {
            return example.get();
        }

        public SimpleStringProperty exampleProperty() {
            return example;
        }

        public void setExample(String example) {
            this.example.set(example);
        }
    }
}



