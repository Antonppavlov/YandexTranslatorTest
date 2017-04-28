package su.bbrain.yandextranslator.fragment.abstact;

import android.support.v4.app.Fragment;

public abstract class AbstractTabFragment extends Fragment {

    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}