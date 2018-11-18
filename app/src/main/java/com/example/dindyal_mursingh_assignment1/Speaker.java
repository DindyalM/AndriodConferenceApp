package com.example.dindyal_mursingh_assignment1;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "speaker_table")
public class Speaker {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Name")
    private String mName;

    @NonNull
    @ColumnInfo(name = "Affiliation")
    private String mAffiliation;

    @NonNull
    @ColumnInfo(name = "Email")
    private String mEmail;

    @NonNull
    @ColumnInfo(name = "Bio")
    private String mBio;

    public Speaker(String name, String affiliation, String email, String bio) {
        this.mName = name;
        this.mAffiliation = affiliation;
        this.mEmail = email;
        this.mBio = bio;
    }


    public String getName() {
        return mName;
    }


    public String getAffiliation() {
        return mAffiliation;
    }


    public String getEmail() {
        return mEmail;
    }

    public String getBio() {
        return mBio;
    }
}
