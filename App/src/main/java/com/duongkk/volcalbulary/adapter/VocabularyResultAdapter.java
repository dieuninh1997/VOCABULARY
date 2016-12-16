package com.duongkk.volcalbulary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.duongkk.volcalbulary.R;
import com.duongkk.volcalbulary.models.Vocabulary;

import java.util.List;

/**
 * Created by MyPC on 12/7/2016.
 */

public class VocabularyResultAdapter extends RecyclerView.Adapter<VocabularyResultAdapter.VocabularyHolder> {
    List<Vocabulary> list;
    Context context;

    public VocabularyResultAdapter(Context context, List<Vocabulary> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VocabularyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new VocabularyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_add_vocabulary, parent, false));
    }

    @Override
    public void onBindViewHolder(VocabularyHolder holder, final int position) {
        final Vocabulary vocabulary = list.get(position);
        if (vocabulary != null && holder != null) {
//            holder.edtMean.setText("");
//            holder.edtNewWord.setText("");
            holder.tvNewWord.setText(String.format(context.getString(R.string.new_word_1),vocabulary.getId()));
            holder.edtMean.setText(vocabulary.getMeaning());
            holder.edtNewWord.setText(vocabulary.getNewWord());


        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VocabularyHolder extends RecyclerView.ViewHolder {
        EditText edtNewWord;
        EditText edtMean;
        TextView tvNewWord;
        public VocabularyHolder(View itemView) {
            super(itemView);
            edtMean = (EditText) itemView.findViewById(R.id.edt_mean);
            edtNewWord = (EditText) itemView.findViewById(R.id.edt_newword);
            tvNewWord = (TextView) itemView.findViewById(R.id.tv_newword);
            edtMean.setEnabled(false);
            edtNewWord.setEnabled(false);
//            final Vocabulary vocabulary =  ;

        }
    }
}
