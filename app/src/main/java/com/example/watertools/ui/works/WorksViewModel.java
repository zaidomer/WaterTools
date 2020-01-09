package com.example.watertools.ui.works;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WorksViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public WorksViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome to Works");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
