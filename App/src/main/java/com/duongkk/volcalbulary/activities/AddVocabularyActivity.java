package com.duongkk.volcalbulary.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.duongkk.volcalbulary.R;
import com.duongkk.volcalbulary.adapter.VocabularyAdapter;
import com.duongkk.volcalbulary.application.AppController;
import com.duongkk.volcalbulary.models.Vocabulary;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddVocabularyActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.rcv_vocabulary)
    RecyclerView rcvVocabulary;
    List<Vocabulary> list;
    VocabularyAdapter adapter;

    @Bind(R.id.fab_save)
    FloatingActionButton fabSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vocabulary);
        ButterKnife.bind(this);
        rcvVocabulary.setLayoutManager(new LinearLayoutManager(this));
        rcvVocabulary.setHasFixedSize(true);
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Vocabulary(i));
        }
        adapter = new VocabularyAdapter(this, list);
        rcvVocabulary.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_save: {
                List<Vocabulary> listVo = new ArrayList<>();
                for (Vocabulary vs : list) {
                       if(!vs.getMeaning().isEmpty() && !vs.getNewWord().isEmpty()){
                           listVo.add(vs);
                       }
                }
                if(listVo.size()<4){
                    Toast.makeText(this,"Missing Vocabulary to ready to contest",Toast.LENGTH_SHORT).show();
                    return;
                }
                AppController.getInstance().setListVocabularies(listVo);
                startActivity(new Intent(AddVocabularyActivity.this, TestAcitivity.class));
                finish();
                break;
            }
            case R.id.fab_more: {
                list.add(new Vocabulary(list.size()));
                adapter.notifyItemInserted(adapter.getItemCount()-1);
                rcvVocabulary.smoothScrollToPosition(adapter.getItemCount());
                break;
            }
        }
    }
}
