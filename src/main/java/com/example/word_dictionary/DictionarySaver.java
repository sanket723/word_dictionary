package com.example.word_dictionary;

import java.io.*;
import java.util.HashMap;

public class DictionarySaver {
    public HashMap<String,String> dictionaryList;

    DictionarySaver(){
        dictionaryList=new HashMap<>();
    }

    void serializeHashMap() throws IOException {

        FileOutputStream fos = new FileOutputStream("dictionaryData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(dictionaryList);
        oos.close();
        fos.close();
    }

    void deserializeHashMap() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("dictionaryData");
        ObjectInputStream ois = new ObjectInputStream(fis);

        dictionaryList = (HashMap<String,String>) ois.readObject();

    }

}
