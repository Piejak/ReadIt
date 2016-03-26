package com.bpiejak.readit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewGroupCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Brian on 3/25/2016.
 */
public class WebViewFragment extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
//        this.getActivity().getWindow().requestFeature(Window.FEATURE_PROGRESS);
        View v = layoutInflater.inflate(R.layout.web_view, container, false);
        WebView webView = (WebView) v.findViewById(R.id.web_view);
        this.webView = webView;
        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);


        final Activity activity = this.getActivity();
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                activity.setProgress(progress * 1000);
            }
        });

        webView.loadUrl(getArguments().getString("url"));

        return v;
    }


    //Doesnt work
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }
}
