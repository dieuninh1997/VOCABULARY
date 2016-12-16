package com.duongkk.volcalbulary.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.duongkk.volcalbulary.R;
import com.duongkk.volcalbulary.adapter.CardsAdapter;
import com.duongkk.volcalbulary.adapter.VocabularyResultAdapter;
import com.duongkk.volcalbulary.application.AppController;
import com.duongkk.volcalbulary.models.Vocabulary;
import com.wenchao.cardstack.CardStack;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;


public class TestAcitivity extends AppCompatActivity {
    private CardStack mCardStack;
    private CardsAdapter mCardAdapter;
    public static String [] arrayList;
    public static RelativeLayout frRoot;
    public  SweetAlertDialog dialog;
    android.support.design.widget.FloatingActionButton fab;
    @Bind(R.id.rcv_vocabulary)
    RecyclerView rcvVocabulary;
    List<Vocabulary> list;
    VocabularyResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);
        arrayList = getResources().getStringArray(R.array.colors);
        mCardStack = (CardStack)findViewById(R.id.container);
        frRoot = (RelativeLayout) findViewById(R.id.frRoot);
        mCardStack.setContentResource(R.layout.card_content);
        mCardAdapter = new CardsAdapter(this, AppController.getInstance().getListVocabularies());
        mCardStack.setAdapter(mCardAdapter);

        mCardStack.setListener(new CardStack.CardEventListener() {
            @Override
            public boolean swipeEnd(int section, float distance) {
//                finish();
                return true;
            }

            @Override
            public boolean swipeStart(int section, float distance) {
                return false;
            }

            @Override
            public boolean swipeContinue(int section, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void discarded(int mIndex, int direction) {

            }

            @Override
            public void topCardTapped() {

            }
        });
        rcvVocabulary.setLayoutManager(new LinearLayoutManager(this));
        rcvVocabulary.setHasFixedSize(true);
        list =AppController.getInstance().getListVocabularies();
        adapter = new VocabularyResultAdapter(this, list);
        rcvVocabulary.setAdapter(adapter);
    }

//    private void showDialogHelp() {
//       dialog =  new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText("View Sample app on Google Play")
//                .setContentText("GO GO GO GO GO GO GO GO GO GO GO GO GO GO ")
//                .setCancelText("No")
//                .setConfirmText("Yes")
//                .showCancelButton(true)
//                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        openGGPlay();
//                        dialog.dismissWithAnimation();
//                    }
//                })
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sweetAlertDialog) {
//                        openGGPlay();
//                        dialog.dismissWithAnimation();
//                    }
//                });
//        dialog.show();
//    }

//    private void openGGPlay() {
//        String url = Utils.APP_URL;
//        Intent i = new Intent(Intent.ACTION_VIEW);
//        i.setData(Uri.parse(url));
//        startActivity(i);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.about) {
//            share();
//            return true;
//        }
//        if (id == R.id.add) {
//            share();
//            return true;
//        }
//        if (id == R.id.share) {
//            share();
//            return true;
//        }
//        if (id == R.id.chplay) {
//            share();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    public void share(){
//        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("text/plain");
//        i.putExtra(Intent.EXTRA_SUBJECT, "#ask2know");
//        i.putExtra(Intent.EXTRA_TEXT, Utils.APP_URL);
//        startActivity(Intent.createChooser(i, "ask2know"));
//    }
}
