package com.example.word_dictionary;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {

    public static Group root;

    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        stage.setTitle("Word Dictionary");
        DictionaryPage page = new DictionaryPage();
        root.getChildren().add(page.root);
        Scene scene = new Scene(root, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}