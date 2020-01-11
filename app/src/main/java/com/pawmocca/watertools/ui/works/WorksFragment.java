//Credit to petrnohejl for lines 64-87 on Stack Overflow
//https://stackoverflow.com/questions/6077141/how-to-go-back-to-previous-page-if-back-button-is-pressed-in-webview
package com.pawmocca.watertools.ui.works;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.pawmocca.watertools.R;
import com.pawmocca.watertools.MainActivity;

public class WorksFragment extends Fragment {

    private com.pawmocca.watertools.ui.works.WorksViewModel WorksViewModel;
    private WebView worksWebView;

    @Override
    public void onDestroy(){
        super.onDestroy();
        MainActivity.oldWorksURL = worksWebView.getUrl();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_works, container, false);

        worksWebView = (WebView)root.findViewById(R.id.worksWebView);
        worksWebView.getSettings().setJavaScriptEnabled(true);
        worksWebView.setWebViewClient(new WebViewClient());
        worksWebView.loadUrl(MainActivity.oldWorksURL);
        worksWebView.setOnKeyListener(new View.OnKeyListener()
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

        if (android.os.Build.VERSION.SDK_INT >= 21){
            CookieManager.getInstance().setAcceptThirdPartyCookies(worksWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

        //partial credit to https://stackoverflow.com/questions/10069050/download-file-inside-webview for the download function
        worksWebView.setDownloadListener(new DownloadListener() {
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