//Credit to petrnohejl for lines 34-57 on Stack Overflow
//https://stackoverflow.com/questions/6077141/how-to-go-back-to-previous-page-if-back-button-is-pressed-in-webview
package com.example.watertools.ui.crowdmark;

import android.os.Bundle;
import android.view.KeyEvent;
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

public class CrowdmarkFragment extends Fragment {

    private CrowdmarkViewModel CrowdmarkViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_crowdmark, container, false);

        WebView crowdmarkWebView = (WebView)root.findViewById(R.id.crowdmarkWebView);
        crowdmarkWebView.getSettings().setJavaScriptEnabled(true);
        crowdmarkWebView.setWebViewClient(new WebViewClient());
        crowdmarkWebView.loadUrl("https://app.crowdmark.com/student/courses");
        CookieManager.getInstance().setAcceptCookie(true);
        crowdmarkWebView.setOnKeyListener(new View.OnKeyListener()
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
        return root;
    }
}