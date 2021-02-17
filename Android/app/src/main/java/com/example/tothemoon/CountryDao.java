package com.example.tothemoon;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    public Country[] getAll();

    @Update
    public void updateCountries(Country... countries);

    @Insert
    public void insertAll(Country... countries);

    @Delete
    public void deleteCountries(Country... countries);
}
