package com.example.tothemoon;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    public LiveData<List<Country>> getAll();

    @Update
    public void updateCountry(Country country);

    @Update
    public void updateCountries(Country... countries);

    @Insert
    public void insert(Country... countries);

    @Delete
    public void deleteCountries(Country... countries);
}
