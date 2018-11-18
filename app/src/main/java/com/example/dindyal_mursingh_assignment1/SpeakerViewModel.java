package com.example.dindyal_mursingh_assignment1;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class SpeakerViewModel extends AndroidViewModel {

    private SpeakerRepository mRepository; //reference repo

    private LiveData<List<Speaker>> mAllSpeakers; // create a live data list

    public SpeakerViewModel(Application application) {
        super(application);
        mRepository = new SpeakerRepository(application);
        mAllSpeakers = mRepository.getAllSpeakers();
    }

    //interacting with repo
    LiveData<List<Speaker>> getAllSpeakers() { return mAllSpeakers; }

    public void insert(Speaker speaker) { mRepository.insert(speaker); }
}