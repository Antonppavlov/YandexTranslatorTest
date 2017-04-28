package su.bbrain.yandextranslator.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import su.bbrain.www.yandextranslator.R;
import su.bbrain.yandextranslator.adapter.FavoriteListAdapter;
import su.bbrain.yandextanslator.database.Initializer;
import su.bbrain.yandextranslator.fragment.abstact.AbstractTabFragment;
import su.bbrain.yandextanslator.object.Word;

public class FavoritesFragment extends AbstractTabFragment {

    private Context context;
    private View view;
    public static FavoriteListAdapter favoriteListAdapter;
    public static List<Word> wordList;


    private static FavoritesFragment favoritesFragment;

    public static FavoritesFragment getInstance(Context context) {
        favoritesFragment = new FavoritesFragment();
        favoritesFragment.context = context;
        favoritesFragment.setTitle(context.getString(R.string.favorites));


        return favoritesFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favorite_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        wordList = Initializer.getWordDAO().getFavoriteAllPost();
        favoriteListAdapter = new FavoriteListAdapter(wordList);
        recyclerView.setAdapter(favoriteListAdapter);
        return view;
    }


}
