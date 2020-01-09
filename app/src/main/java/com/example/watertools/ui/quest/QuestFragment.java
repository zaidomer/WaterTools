package com.example.watertools.ui.quest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.watertools.R;

public class QuestFragment extends Fragment {

    private QuestViewModel QuestViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        QuestViewModel =
                ViewModelProviders.of(this).get(QuestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_quest, container, false);
        final TextView textView = root.findViewById(R.id.text_quest);
        QuestViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}