package com.example.pokemon.model;

import java.util.ArrayList;

public class PokemonResource {
    private int count;
    private String next , previews;
    private ArrayList<Pokemon> results;

    public PokemonResource(int count, String next, String previews, ArrayList<Pokemon> pokemons) {
        this.count = count;
        this.next = next;
        this.previews = previews;
        this.results = pokemons;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPreviews() {
        return previews;
    }

    public void setPreviews(String previews) {
        this.previews = previews;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
