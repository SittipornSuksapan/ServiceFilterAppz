package com.chan.revernue.filterapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TabHost;

public class TabMenuActivity extends AppCompatActivity {


    TabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_menu);

        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();

        mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("TAB 1").setContent(R.id.tab1));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("TAB 2").setContent(R.id.tab2));
        mTabHost.addTab(mTabHost.newTabSpec("tab_test3").setIndicator("TAB 3").setContent(R.id.tab3));

        mTabHost.setCurrentTab(0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tab_host, menu);
        return true;
    }

}