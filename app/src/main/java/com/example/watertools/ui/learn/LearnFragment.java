package com.example.watertools.ui.learn;

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

public class LearnFragment extends Fragment {

    private LearnViewModel LearnViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        LearnViewModel = ViewModelProviders.of(this).get(LearnViewModel.class);
        View root = inflater.inflate(R.layout.fragment_learn, container, false);
//        final TextView textView = root.findViewById(R.id.text_learn);
//        LearnViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        WebView learnWebView = (WebView)root.findViewById(R.id.learnWebView);
        learnWebView.getSettings().setJavaScriptEnabled(true);
        learnWebView.setWebViewClient(new WebViewClient());
        learnWebView.loadUrl("http://learn.uwaterloo.ca");
        return root;
    }
}