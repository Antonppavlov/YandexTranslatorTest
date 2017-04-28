package su.bbrain.yandextranslator.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.sql.SQLException;

import su.bbrain.www.yandextranslator.R;
import su.bbrain.yandextranslator.adapter.TabsFragmentAdapter;
import su.bbrain.yandextranslator.app.DbConnection;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            DbConnection.initConnection(getApplicationContext());
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.getSQLState(), Toast.LENGTH_SHORT).show();
        }

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setTheme(R.style.AppDefault);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initTabLayout();
    }


    private void  initTabLayout() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        TabsFragmentAdapter tabsAdapter = new TabsFragmentAdapter(getApplicationContext(),getSupportFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }


    public  void method(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
