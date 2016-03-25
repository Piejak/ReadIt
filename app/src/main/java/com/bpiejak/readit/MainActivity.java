package com.bpiejak.readit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private BroadcastReceiver mWebViewReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("main", context + " " + intent.getStringExtra("url"));
            Bundle bundle = new Bundle();
            bundle.putString("url", intent.getStringExtra("url"));
            WebViewFragment webViewFragment = new WebViewFragment();
            webViewFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.content, webViewFragment);
            fragmentTransaction.commit();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, new FrontPage());
        fragmentTransaction.commit();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName(R.string.item1);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName(R.string.item2);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Brian Piejak")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        item1,
                        item2
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                                .beginTransaction();
                        if (position == 1) {
                            fragmentTransaction.replace(R.id.content, new FrontPage());
                            fragmentTransaction.commit();
                        } else if (position == 2) {
                            fragmentTransaction.replace(R.id.content, new All());
                            fragmentTransaction.commit();
                        }
                        return true;
                    }
                })
                .withAccountHeader(headerResult)
                .build();

        LocalBroadcastManager.getInstance(this).registerReceiver(mWebViewReceiver, new IntentFilter("com.bpiejak.start_web_view"));
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mWebViewReceiver);
        super.onDestroy();
    }
}