package su.bbrain.www.yandextranslator.fragment;//package su.bbrain.www.yandextranslator.fragment;
//
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import su.bbrain.www.yandextranslator.R;
//import su.bbrain.www.yandextranslator.adapter.FavoriteListAdapter;
//import su.bbrain.www.yandextranslator.dto.RemindDTO;
//import su.bbrain.www.yandextranslator.fragment.abstact.AbstractTabFragment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import su.bbrain.www.yandextranslator.database.Initializer;
//import su.bbrain.www.yandextranslator.object.Word;
//
//public class HistoryFragment extends AbstractTabFragment {
//
//    private final static int LAYOUT = R.layout.history_fragment;
//
//    private Context context;
//    private View view;
//
//
//    private static HistoryFragment historyFragment;
//
//    public static HistoryFragment getInstance(Context context) {
//        historyFragment = new HistoryFragment();
//        historyFragment.context = context;
//        historyFragment.setTitle(context.getString(R.string.history));
//
//
//        return historyFragment;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        view = inflater.inflate(LAYOUT, container, false);
//
//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//
//        List<Word> wordList = Initializer.getWordDAO().getWordList();
//
//        recyclerView.setAdapter(new FavoriteListAdapter(wordList));
//
//        return view;
//    }
//
//}
