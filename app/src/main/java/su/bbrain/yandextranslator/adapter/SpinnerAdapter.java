package su.bbrain.yandextranslator.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import su.bbrain.www.yandextranslator.R;

public class SpinnerAdapter extends ArrayAdapter<String> {


    private Context context;

    private String[] languagesName;

    public SpinnerAdapter(Context context, int textViewResourceId, String[] languagesName) {
        super(context, textViewResourceId, languagesName);
        this.context = context;
        this.languagesName = languagesName;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.row, parent, false);
        TextView label = (TextView) row.findViewById(R.id.weekofday);
        label.setText(languagesName[position]);

        return row;
    }

}


