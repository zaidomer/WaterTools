package com.example.watertools.ui.crowdmark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        crowdmarkWebView.loadUrl("https://app.crowdmark.com/sign-in");
        return root;
    }
}