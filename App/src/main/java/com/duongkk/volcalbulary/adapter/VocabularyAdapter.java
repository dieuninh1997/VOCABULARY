package com.duongkk.volcalbulary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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

public class VocabularyAdapter extends RecyclerView.Adapter<VocabularyAdapter.VocabularyHolder> {
    List<Vocabulary> list;
    Context context;

    public VocabularyAdapter(Context context, List<Vocabulary> list) {
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
//            final Vocabulary vocabulary =  ;
            edtNewWord.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    list.get(getAdapterPosition()).setNewWord(s.toString());
                    list.set(getAdapterPosition(),list.get(getAdapterPosition()));

                }
            });
            edtMean.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    list.get(getAdapterPosition()).setMeaning(s.toString());
                    list.set(getAdapterPosition(),list.get(getAdapterPosition()));
                }
            });
        }
    }
}
