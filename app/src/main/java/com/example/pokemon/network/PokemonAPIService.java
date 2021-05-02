package com.example.pokemon.network;


import com.example.pokemon.model.PokemonResource;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonAPIService {

   @GET("pokemon")
   Observable<PokemonResource> getPokemons();

}
