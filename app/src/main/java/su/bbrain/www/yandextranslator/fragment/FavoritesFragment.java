package su.bbrain.www.yandextranslator.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import su.bbrain.www.yandextranslator.R;
import su.bbrain.www.yandextranslator.adapter.FavoriteListAdapter;
import su.bbrain.www.yandextranslator.fragment.abstact.AbstractTabFragment;

import java.util.List;

import su.bbrain.www.yandextranslator.database.Initializer;
import su.bbrain.www.yandextranslator.object.Word;

public class FavoritesFragment extends AbstractTabFragment {

    private final static int LAYOUT = R.layout.favorite_fragment;

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
        view = inflater.inflate(LAYOUT, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        wordList = Initializer.getWordDAO().getFavoriteAllPost();
        favoriteListAdapter = new FavoriteListAdapter(wordList);
//        favoriteListAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(favoriteListAdapter);
        return view;
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        favoriteListAdapter.notifyDataSetChanged();
//    }
}
