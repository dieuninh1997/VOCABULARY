package com.duongkk.volcalbulary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.duongkk.volcalbulary.R;
import com.github.clans.fab.FloatingActionButton;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.fab_add)
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,AddVocabularyActivity.class));
    }
}
