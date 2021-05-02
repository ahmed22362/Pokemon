package com.example.pokemon.viewmodels;


import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.PokemonResource;
import com.example.pokemon.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PokemonViewModel extends ViewModel {
    private static final String TAG = "PokemonViewModel";
    private final Repository repository ;
    public MutableLiveData<ArrayList<Pokemon>>  pokemonList = new MutableLiveData<>();
    private LiveData<List<Pokemon>> favList  = null;

    @ViewModelInject
    public PokemonViewModel(Repository repository) {
        this.repository = repository;
    }




    public void getPokemon(){
        repository.getPokemons().
                subscribeOn(Schedulers.io())
                .map(new Function<PokemonResource, ArrayList<Pokemon>>() {
                    @Override
                    public ArrayList<Pokemon> apply(PokemonResource pokemonResource) throws Throwable {
                        ArrayList<Pokemon> list = pokemonResource.getResults();
                        for (Pokemon p : list){
                            String url = p.getUrl();
                            String[] pokemonIndex = url.split("/");
                            p.setUrl("https://pokeres.bastionbot.org/images/pokemon/"+pokemonIndex[pokemonIndex.length-1]+".png");
                        }
                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> pokemonList.setValue(result),
                error -> Log.e(TAG ,error.getMessage()));

    }

    public void insert(Pokemon pokemon){repository.insert(pokemon);}


    public void delete(String pokemonName){repository.delete(pokemonName);}
    public LiveData<List<Pokemon>> getFavList() {
        return favList;
    }
    public void getFavPokemon(){
        favList = repository.getFavPokemon();
    }
}
