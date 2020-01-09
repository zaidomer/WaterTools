package com.example.watertools.ui.portal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PortalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PortalViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is portal fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}