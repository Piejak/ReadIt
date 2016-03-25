package com.bpiejak.readit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Brian on 3/25/2016.
 */
public class WebViewBroadcaster extends AppCompatActivity {
    public WebViewBroadcaster(String url) {
        Log.i("Broadcaster", "Now broadcasting message");

        Intent intent = new Intent("com.bpiejak.start_web_view");
        intent.putExtra("url", url);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
//
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        WebViewFragment webViewFragment = new WebViewFragment();
        webViewFragment.setArguments(bundle);
//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.content, webViewFragment);
//        fragmentTransaction.commit();
    }
}
