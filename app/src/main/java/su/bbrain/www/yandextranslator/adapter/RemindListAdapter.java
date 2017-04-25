package su.bbrain.www.yandextranslator.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import su.bbrain.www.yandextranslator.R;

import java.util.List;

import su.bbrain.www.yandextranslator.object.Word;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {

    private  List<Word>  remindDTOList;

    public RemindListAdapter( List<Word>  remindDTOList) {
        this.remindDTOList = remindDTOList;
    }

    public void setRemindDTOList(List<Word> remindDTOList) {
        this.remindDTOList = remindDTOList;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.remind_item, parent, false);
        return new RemindViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        Word data = remindDTOList.get(position);

        holder.text.setText(data.getText());
        holder.textTranslator.setText(data.getTranslatorText());
        holder.codeLanguageFrom .setText(data.getCodeLanguageFrom());
        holder.codeLanguageTo.setText(data.getCodeLanguageTo());
    }

    @Override
    public int getItemCount() {
        return remindDTOList.size();
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

            text = (TextView) itemView.findViewById(R.id.itemTextViewTitle);
            textTranslator = (TextView) itemView.findViewById(R.id.textDescription);

            codeLanguageFrom = (TextView) itemView.findViewById(R.id.codeLanguageFrom);
            codeLanguageTo = (TextView) itemView.findViewById(R.id.codeLanguageTo);
        }
    }
}
