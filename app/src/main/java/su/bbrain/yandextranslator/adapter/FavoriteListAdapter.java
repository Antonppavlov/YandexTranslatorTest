package su.bbrain.yandextranslator.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import su.bbrain.www.yandextranslator.R;

import java.util.List;

import su.bbrain.yandextanslator.object.Word;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.RemindViewHolder> {

    private  List<Word> wordList;

    public FavoriteListAdapter(List<Word> wordList) {
        this.wordList = wordList;
    }

    public void setWordList(List<Word> wordList) {
        this.wordList = wordList;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.favorite_item, parent, false);
        return new RemindViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        Word data = wordList.get(position);

        holder.text.setText(data.getText());
        holder.textTranslator.setText(data.getTranslatorText());
        holder.codeLanguageFrom .setText(data.getCodeLanguageFrom());
        holder.codeLanguageTo.setText(data.getCodeLanguageTo());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }


    public static class RemindViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView text;
        TextView textTranslator;
        TextView codeLanguageFrom;
        TextView codeLanguageTo;

        public RemindViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

            text = (TextView) itemView.findViewById(R.id.textFrom);
            textTranslator = (TextView) itemView.findViewById(R.id.textTo);

            codeLanguageFrom = (TextView) itemView.findViewById(R.id.codeLanguageFrom);
            codeLanguageTo = (TextView) itemView.findViewById(R.id.codeLanguageTo);
        }
    }
}
