package com.example.tothemoon;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {
    @NonNull
    @PrimaryKey
    public String code;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="visited")
    public boolean visited;
}
