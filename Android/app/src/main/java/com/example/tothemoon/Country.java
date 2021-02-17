package com.example.tothemoon;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Country {
    @PrimaryKey
    public String code;

    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="visited")
    public boolean visited;
}
