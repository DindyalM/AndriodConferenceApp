package com.example.dindyal_mursingh_assignment1;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Speaker.class}, version = 1)
public abstract class SpeakerRoomDatabase extends RoomDatabase {

    public abstract SpeakerDao speakerDao(); //reference the DAO layer

    private static volatile SpeakerRoomDatabase INSTANCE;

    static SpeakerRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SpeakerRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SpeakerRoomDatabase.class, "word_database").addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final SpeakerDao mDao;

        PopulateDbAsync(SpeakerRoomDatabase db) {
            mDao = db.speakerDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Speaker speaker = new Speaker("Andrew","Drw","@","hi"); //construct object add to db
            mDao.insert(speaker);
            speaker = new Speaker("Andrew2","Drw","@","hi");
            mDao.insert(speaker);
            speaker = new Speaker("Shanay","Andrew2","shan@gmail.com","hello guys !");
            mDao.insert(speaker);
            return null;
        }
    }
}