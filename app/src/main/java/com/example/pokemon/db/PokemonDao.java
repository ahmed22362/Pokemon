package com.example.pokemon.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pokemon.model.Pokemon;

import java.util.List;

@Dao
public interface PokemonDao {

    @Insert
    public void insert(Pokemon pokemon);

    @Query("delete from fav_table where name=:pokemonName ")
    public void delete(String pokemonName);

    @Query("select * from fav_table")
    public LiveData<List<Pokemon>> getPokemons();

}
