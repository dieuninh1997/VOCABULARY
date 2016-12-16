package com.duongkk.volcalbulary.models;

/**
 * Created by MyPC on 12/7/2016.
 */

public class Vocabulary {
    String newWord;
    String meaning;
    int id;

    public Vocabulary(int i){
        id= i;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getNewWord() {
        return newWord;
    }

    public void setNewWord(String newWord) {
        this.newWord = newWord;
    }
}
