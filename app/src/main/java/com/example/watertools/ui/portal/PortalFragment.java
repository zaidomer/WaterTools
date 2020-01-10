//Credit to Anjal Saneen for lines 37-62 on Stack Overflow
//https://stackoverflow.com/questions/47367382/webview-does-not-load-a-particular-website/47367462
//Credit to petrnohejl for lines 64-87 on Stack Overflow
//https://stackoverflow.com/questions/6077141/how-to-go-back-to-previous-page-if-back-button-is-pressed-in-webview
package com.example.watertools.ui.portal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
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

import com.example.watertools.MainActivity;
import com.example.watertools.R;
import com.example.watertools.ui.learn.LearnFragment;

public class PortalFragment extends Fragment {

    private PortalViewModel PortalViewModel;
    private WebView portalWebView;

    @Override
    public void onDestroy(){
        super.onDestroy();
        MainActivity.oldPortalURL = portalWebView.getUrl();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_portal, container, false);

        portalWebView = (WebView) root.findViewById(R.id.portalWebView);
        portalWebView.loadUrl(MainActivity.oldPortalURL);
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

        portalWebView.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;

                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(portalWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

        //partial credit to https://stackoverflow.com/questions/10069050/download-file-inside-webview for the download function
        portalWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return root;
    }
}