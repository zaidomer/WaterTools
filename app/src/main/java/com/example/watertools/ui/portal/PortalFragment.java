package com.example.watertools.ui.portal;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watertools.R;

public class PortalFragment extends Fragment {

    private PortalViewModel PortalViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_portal, container, false);

        WebView portalWebView = (WebView) root.findViewById(R.id.portalWebView);
        portalWebView.loadUrl("https://portal.uwaterloo.ca");
        portalWebView.getSettings().setLoadsImagesAutomatically(true);
        portalWebView.getSettings().setJavaScriptEnabled(true);
        portalWebView.getSettings().setAllowContentAccess(true);
        portalWebView.getSettings().setUseWideViewPort(true);
        portalWebView.getSettings().setLoadWithOverviewMode(true);
        portalWebView.getSettings().setDomStorageEnabled(true);
        portalWebView.setHorizontalScrollBarEnabled(false);
        portalWebView.getSettings().setAppCacheEnabled(true);
        portalWebView.getSettings().setDatabaseEnabled(true);
        portalWebView.setVerticalScrollBarEnabled(false);
        portalWebView.getSettings().setBuiltInZoomControls(true);
        portalWebView.getSettings().setDisplayZoomControls(false);
        portalWebView.getSettings().setAllowFileAccess(true);
        portalWebView.setScrollbarFadingEnabled(false);
        portalWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        portalWebView.setWebViewClient(new WebViewClient());
        portalWebView.setInitialScale(1);
        portalWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return false;
            }
        });
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(portalWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        return root;
    }
}