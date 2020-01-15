package com.farhan.advotics.View.home;

import com.farhan.advotics.MyData;
import com.farhan.advotics.model.mCat;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<mCat>> mText;
    ArrayList<mCat> siKucing;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

        siKucing = new ArrayList<>();
        for (int i = 0; i < MyData.drawableArray.length; i++) {
            siKucing.add(new mCat(
                    MyData.drawableArray[i]
            ));
        }
        mText.setValue(siKucing);
    }

    public MutableLiveData<ArrayList<mCat>> getText() {
        return mText;
    }
}