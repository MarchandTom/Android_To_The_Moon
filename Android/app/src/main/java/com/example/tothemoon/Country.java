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

    public Country(){
    }

    public Country(String code,String name){
        this.code = code;
        this.name = name;
    }

    void setCode(String code){
        this.code = code;
    }

    void setName(String name){
        this.name = name;
    }

    void setVisited(boolean visited){
        this.visited = visited;
    }

    public String toString(){
        return "name="+this.name+", code="+this.code+", visited="+this.visited;
    }
}
