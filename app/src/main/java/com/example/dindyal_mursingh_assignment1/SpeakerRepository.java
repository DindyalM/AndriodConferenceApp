package com.example.dindyal_mursingh_assignment1;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class SpeakerRepository {

    private SpeakerDao mSpeakerDao; // reference DAO object
    private LiveData<List<Speaker>> mAllSpeakers;

    SpeakerRepository(Application application) {
        SpeakerRoomDatabase db = SpeakerRoomDatabase.getDatabase(application);
        mSpeakerDao = db.speakerDao();
        mAllSpeakers = mSpeakerDao.getAllSpeakers();// repo makes a request to the DAO to store class entities in list
    }

    LiveData<List<Speaker>> getAllSpeakers() {
        return mAllSpeakers;
    } // the repo hides the logic to the view layer


    public void insert (Speaker speaker) {
        new insertAsyncTask(mSpeakerDao).execute(speaker);
    } //inserts object using dao

    private static class insertAsyncTask extends AsyncTask<Speaker, Void, Void> {

        private SpeakerDao mAsyncTaskDao; //grab dao object

        insertAsyncTask(SpeakerDao dao) {
            mAsyncTaskDao = dao;
        }//local dao will take value of parameter DAO

        @Override
        protected Void doInBackground(final Speaker... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}