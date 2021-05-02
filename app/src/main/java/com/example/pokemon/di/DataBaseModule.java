package com.example.pokemon.di;


import android.app.Application;

import androidx.room.Room;

import com.example.pokemon.db.PokemonDB;
import com.example.pokemon.db.PokemonDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static PokemonDB provideDatabase(Application application){
        return Room.databaseBuilder(application, PokemonDB.class,"fav_table")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

    }
    @Provides
    @Singleton
    public static PokemonDao provideDao(PokemonDB pokemonDB){
        return pokemonDB.pokemonDao();
    }
}
