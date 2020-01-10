package com.pawmocca.watertools.ui.crowdmark;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrowdmarkViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CrowdmarkViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}