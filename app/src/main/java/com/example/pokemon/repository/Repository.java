package com.example.pokemon.repository;

import androidx.lifecycle.LiveData;

import com.example.pokemon.db.PokemonDao;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.PokemonResource;
import com.example.pokemon.network.PokemonAPIService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

public class Repository {

    private PokemonAPIService pokemonApiService;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonAPIService pokemonApiService, PokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResource> getPokemons(){
        return pokemonApiService.getPokemons();
    }

    public void insert(Pokemon pokemon){pokemonDao.insert(pokemon);}

    public void delete(String pokemonName){pokemonDao.delete(pokemonName);}

    public LiveData<List<Pokemon>> getFavPokemon(){
        return pokemonDao.getPokemons();
    }
}
