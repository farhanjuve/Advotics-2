package com.farhan.advotics.View.user;

import com.farhan.advotics.model.mUser;

import java.util.HashMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    private MutableLiveData<mUser> mText;
    private HashMap <String, String> user;

    public void setUser(String name, String gender, String number) {
        mText.setValue(new mUser(name, gender, number));
    }

    public UserViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<mUser> getUser() {
        return mText;
    }
}