package com.rechar.campusassistant.model;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {


    private static final String TAG="PageViewModel";
    private MutableLiveData<String > mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<String, String>() {
        @Override
        public String apply(String input) {
            Log.e(TAG, "apply: "+input );
            return "Hello world from section: " + input;
        }
    });

    public void setIndex(String  index) {
        Log.e(TAG, "setIndex: "+index );
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}