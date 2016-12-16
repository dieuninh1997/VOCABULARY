package com.duongkk.volcalbulary.application;

import android.app.Application;

import com.duongkk.volcalbulary.models.Vocabulary;

import java.util.List;

/**
 * Created by MyPC on 12/7/2016.
 */

public class AppController extends Application {
    static AppController instance;
    List<Vocabulary> listVocabularies;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized AppController getInstance() {
        if (instance == null) instance = new AppController();
        return instance;
    }

    public List<Vocabulary> getListVocabularies() {
        return listVocabularies;
    }

    public void setListVocabularies(List<Vocabulary> listVocabularies) {
        this.listVocabularies = listVocabularies;
    }
}
