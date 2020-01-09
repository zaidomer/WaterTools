package com.example.watertools.ui.portal;
import android.webkit.WebViewClient;
import android.webkit.WebView;

public class WebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageFinished(WebView view, String url) {

    }
}
