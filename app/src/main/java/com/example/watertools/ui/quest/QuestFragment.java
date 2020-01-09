package com.example.watertools.ui.quest;

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

public class QuestFragment extends Fragment {

    private QuestViewModel QuestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_quest, container, false);

        WebView questWebView = (WebView)root.findViewById(R.id.questWebView);
        questWebView.getSettings().setJavaScriptEnabled(true);
        questWebView.setWebViewClient(new WebViewClient());
        questWebView.loadUrl("https://quest.pecs.uwaterloo.ca/psp/SS/ACADEMIC/SA/?cmd=login&languageCd=ENG&");
        return root;
    }
}