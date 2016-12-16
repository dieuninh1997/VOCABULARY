package com.duongkk.volcalbulary.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.duongkk.volcalbulary.R;
import com.duongkk.volcalbulary.activities.TestAcitivity;
import com.duongkk.volcalbulary.models.Vocabulary;

import java.util.List;
import java.util.Random;

public class CardsAdapter extends ArrayAdapter<String> {

    public static String TAG = CardsAdapter.class.getSimpleName().toUpperCase();
    Activity activity;
    CardView cv;
    List<Vocabulary> list;

    public CardsAdapter(Activity context, List<Vocabulary> list) {
        super(context, R.layout.card_content);
        this.activity = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, final View contentView, ViewGroup parent) {
        TextView v = (TextView) (contentView.findViewById(R.id.tv_newword));
        cv = (CardView) (contentView.findViewById(R.id.card));
        RadioGroup radioGroup = (RadioGroup) contentView.findViewById(R.id.rad_group);
//        RadioButton radioButtonA = (RadioButton)radioGroup.findViewById(R.id.rad_ans_a);
//        RadioButton radioButtonB = (RadioButton)radioGroup.findViewById(R.id.rad_ans_b);
//        RadioButton radioButtonC = (RadioButton)radioGroup.findViewById(R.id.rad_ans_c);
//        RadioButton radioButtonD = (RadioButton)radioGroup.findViewById(R.id.rad_ans_d);
//        List<RadioButton> listRAd = new ArrayList<>();

        Vocabulary vocabularyTrue = list.get(position);
        v.setText(vocabularyTrue.getNewWord());
        int posAnsFalse1 = new Random().nextInt(list.size() - 1);
//        String ansFalse1 = list.get(posAnsFalse1).getMeaning();
        int posAnsFalse2;
        do {
            posAnsFalse2 = new Random().nextInt(list.size() - 1);

        } while (posAnsFalse1 == posAnsFalse2);
//        String ansFalse2 = list.get(posAnsFalse2).getMeaning();
//        int posAnsFalse3 = new Random().nextInt(list.size() - 1);
        int posAnsFalse3;
        do {
            posAnsFalse3 = new Random().nextInt(list.size() - 1);

        } while (posAnsFalse3 == posAnsFalse2 || posAnsFalse3 == posAnsFalse1);
//        String ansFalse3 = list.get(posAnsFalse3).getMeaning();
        String[] ansFalse = {list.get(posAnsFalse1).getMeaning(), list.get(posAnsFalse2).getMeaning(), list.get(posAnsFalse3).getMeaning()};
        int posTrue = new Random().nextInt(3);
        int k = 0;
        for (int in = 0; in < 4; in++) {
            RadioButton rad = new RadioButton(activity);
            rad.setTextColor(Color.WHITE);
            rad.setTextSize(16);
            rad.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            if (posTrue == in) {
                rad.setText(vocabularyTrue.getMeaning());
            } else {
                rad.setText(ansFalse[k]);
                k++;
            }
            radioGroup.addView(rad);

        }
//        listRAd.get(posTrue).setText(vocabularyTrue.getMeaning());


        int i = new Random().nextInt(TestAcitivity.arrayList.length - 1);
        cv.setCardBackgroundColor(Color.parseColor(TestAcitivity.arrayList[i]));


        return contentView;
    }


}

