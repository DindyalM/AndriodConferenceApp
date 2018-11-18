package com.example.dindyal_mursingh_assignment1;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SpeakerDao {

    @Insert
    void insert(Speaker speaker); // insert method takes in an object of class type

    @Query("DELETE FROM speaker_table")
    void deleteAll();

    @Query("SELECT * from speaker_table")
    LiveData<List<Speaker>> getAllSpeakers(); //runs sql command masked as method name, stores in a live data object
}