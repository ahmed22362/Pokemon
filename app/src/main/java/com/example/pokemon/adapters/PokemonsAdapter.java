package com.example.pokemon.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pokemon.R;
import com.example.pokemon.model.Pokemon;

import java.util.ArrayList;

import retrofit2.http.POST;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder> {

    private ArrayList<Pokemon> mList = new ArrayList<>();
    private Context mContext;

    public PokemonsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_pokemon_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.pokemon_name.setText(mList.get(position).getName());

        Glide.with(mContext).load(mList.get(position).getUrl())
                .into(holder.pokemon_image);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(ArrayList<Pokemon> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }


    public Pokemon getPokemonAt(int position){
        return mList.get(position);
    }
     class PokemonViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemon_image;
        TextView pokemon_name;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemon_image = itemView.findViewById(R.id.custom_pokemon_iv);
            pokemon_name = itemView.findViewById(R.id.custom_pokemon_tv);
        }
    }
}
