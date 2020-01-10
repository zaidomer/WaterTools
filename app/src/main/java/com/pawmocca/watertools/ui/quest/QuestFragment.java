//Credit to petrnohejl for lines 64-87 on Stack Overflow
//https://stackoverflow.com/questions/6077141/how-to-go-back-to-previous-page-if-back-button-is-pressed-in-webview
package com.pawmocca.watertools.ui.quest;

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

public class QuestFragment extends Fragment {

    private WebView questWebView;
    private com.pawmocca.watertools.ui.quest.QuestViewModel QuestViewModel;

    @Override
    public void onDestroy(){
        super.onDestroy();
        MainActivity.oldQuestURL = questWebView.getUrl();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quest, container, false);

        questWebView = (WebView)root.findViewById(R.id.questWebView);
        questWebView.getSettings().setJavaScriptEnabled(true);
        questWebView.setWebViewClient(new WebViewClient());
        questWebView.loadUrl(MainActivity.oldQuestURL);
        questWebView.setOnKeyListener(new View.OnKeyListener()
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

        questWebView.getSettings().setAllowFileAccess(true);
        questWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        //partial credit to https://stackoverflow.com/questions/10069050/download-file-inside-webview for the download function
        questWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(questWebView, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        return root;
    }
}