package com.pawmocca.watertools.ui.quest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QuestViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public QuestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to Water");
    }

    public LiveData<String> getText() {
        return mText;
    }
}