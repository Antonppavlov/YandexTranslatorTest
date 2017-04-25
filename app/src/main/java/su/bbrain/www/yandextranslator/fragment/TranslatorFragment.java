package su.bbrain.www.yandextranslator.fragment;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import su.bbrain.www.yandextranslator.R;
import su.bbrain.www.yandextranslator.adapter.SpinnerAdapter;
import su.bbrain.www.yandextranslator.dao.WordDAO;
import su.bbrain.www.yandextranslator.database.Initializer;
import su.bbrain.www.yandextranslator.fragment.abstact.AbstractTabFragment;
import su.bbrain.www.yandextranslator.object.Word;
import su.bbrain.www.yandextranslator.yandex.ApiKeys;
import su.bbrain.www.yandextranslator.yandex.language.Language;
import su.bbrain.www.yandextranslator.yandex.translate.Translate;

public class TranslatorFragment extends AbstractTabFragment {

    private final static int LAYOUT = R.layout.transletor_fragment;
    private Context context;
    private View view;

    private Spinner spinner1;
    private Spinner spinner2;

    private TextView translatedText;
    private EditText inputField;

    private CheckBox checkBox;


    private static TranslatorFragment translatorFragment;

    public static TranslatorFragment getInstance(Context context) {
        translatorFragment = new TranslatorFragment();
        translatorFragment.context = context;
        translatorFragment.setTitle(context.getString(R.string.translator));

        return translatorFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);

        String[] arrayString = Language.getNameList();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context, 2, arrayString);

        spinner1.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);
        spinner1.setSelection(Language.Russian.ordinal());
        spinner2.setSelection(Language.English.ordinal());
        SelectItemListener selectItemListener = new SelectItemListener();
        spinner1.setOnItemSelectedListener(selectItemListener);
        spinner2.setOnItemSelectedListener(selectItemListener);
        translatedText = (TextView) view.findViewById(R.id.translatedText);
        inputField = (EditText) view.findViewById(R.id.inputField);
        checkBox = (CheckBox) view.findViewById(R.id.chbFavorite);

        inputField.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                new AsyncRequest(getWord()).execute("");

                checkBox.setChecked(FavoritesFragment.wordList.contains(getWord()));
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });



        checkBox.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            WordDAO wordDAO = Initializer.getWordDAO();

                                            if (checkBox.isChecked()) {
                                                try {
                                                    wordDAO.insertWordFavorite(getWord());
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                            } else {
                                                try {
                                                    wordDAO.deleteFavorite(getWord());
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }

                                            }
                                            List<Word> favoriteAllPost = wordDAO.getFavoriteAllPost();
                                            FavoritesFragment.wordList=favoriteAllPost;
                                            FavoritesFragment.favoriteListAdapter.setWordList(favoriteAllPost);
                                            FavoritesFragment.favoriteListAdapter.notifyDataSetChanged();
                                        }
                                    }
        );

        return view;
    }


    private class SelectItemListener implements AdapterView.OnItemSelectedListener {


        @Override
        public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
            new AsyncRequest(getWord()).execute("");
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    class AsyncRequest extends AsyncTask<String, Integer, String> {

        private Word word;

        public AsyncRequest(Word word) {
            this.word =word;
        }

        @Override
        protected String doInBackground(String... arg) {
            Translate.setKey(ApiKeys.YANDEX_API_KEY);
            try {
                return Translate.execute(word.getText(), Language.fromCode(word.getCodeLanguageFrom()), Language.fromCode(word.getCodeLanguageTo()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Здесь отобразится перевод...";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            translatedText.setText(s);
        }
    }

    public Word getWord(){
        String s1 = inputField.getText().toString();
        String s2 = translatedText.getText().toString();
        Language language1 = Language.values()[spinner1.getSelectedItemPosition()];
        Language language2 = Language.values()[spinner2.getSelectedItemPosition()];

        return new Word(s1, s2,language1.getCode(),language2.getCode());
    }
}
