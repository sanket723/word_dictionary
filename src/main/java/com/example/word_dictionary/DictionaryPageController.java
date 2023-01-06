package com.example.word_dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {

    public DictionarySaver db;
    @FXML
    TextField search;
    @FXML
    TextField addword;
    @FXML
    TextField addmeaning;
    @FXML
    TextField findmeaning;


    public void searchButton(MouseEvent event) throws IOException, ClassNotFoundException {

        try {
            db = new DictionarySaver();
            //db.serializeHashMap();
            db.deserializeHashMap();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dictionary");

            if(search.getText().equals(""))
                alert.setContentText("Please enter a word to search");

            else if (db.dictionaryList.containsKey(search.getText().toLowerCase()))
                alert.setContentText("The word is available in the dictionary");
            else
                alert.setContentText("The word is not available in the dictionary");

            alert.showAndWait();
        }
        catch (IOException ex){
            db.serializeHashMap();
            System.out.println("Exception resolved");
        }
    }

    public void addButton(MouseEvent event) throws IOException, ClassNotFoundException {
        db= new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(addword.getText().equals("") || addmeaning.getText().equals(""))
            alert.setContentText("Please enter a word/meaning to add");

        else {
            db.dictionaryList.put(addword.getText().toLowerCase(), addmeaning.getText());
            db.serializeHashMap();

            alert.setContentText("The new word/meaning is added");
        }
        alert.showAndWait();

    }

    public void findButton(MouseEvent event) throws IOException, ClassNotFoundException {
        //System.out.println(find.getText());
        db= new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");

        if(findmeaning.getText().equals(""))
            alert.setContentText("Please enter a word to find meaning");

        else if(db.dictionaryList.containsKey(findmeaning.getText().toLowerCase()))
            alert.setContentText(db.dictionaryList.get(findmeaning.getText().toLowerCase()));
        else
            alert.setContentText("Meaning is not present please add with word in dictionary");

        alert.showAndWait();
    }

}
