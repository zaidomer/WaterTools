package com.example.watertools.ui.portal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
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

        WebView portalWebView = (WebView)root.findViewById(R.id.portalWebView);
        portalWebView.getSettings().setJavaScriptEnabled(true);
        portalWebView.setWebViewClient(new WebViewClient());
        portalWebView.loadUrl("https://portal.uwaterloo.ca");
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(portalWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        return root;
    }
}