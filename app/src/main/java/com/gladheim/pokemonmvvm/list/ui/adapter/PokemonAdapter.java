package com.gladheim.pokemonmvvm.list.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.R;
import com.gladheim.pokemonmvvm.BR;
import com.gladheim.pokemonmvvm.list.ui.viewmodel.PokemonViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destivar on 04/03/16.
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private List<PokemonItem> pokemonItems = new ArrayList<>();
    private OnItemClickListener onItemClickListener;
    private Activity activity;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public PokemonAdapter(Activity activity) {
        this.activity = activity;
    }

    public PokemonItem getPokemon(int position) {
        return pokemonItems.get(position);
    }

    public void setPokemonItems(List<PokemonItem> pokemonItems) {
        this.pokemonItems = pokemonItems;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        PokemonHolder holder = new PokemonHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(PokemonHolder holder, int position) {
        final PokemonItem pokemonItem = pokemonItems.get(position);
        holder.getBinding().setVariable(BR.viewModel, new PokemonViewModel(activity, pokemonItem));
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return pokemonItems.size();
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ViewDataBinding binding;

        public PokemonHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v, getAdapterPosition());
        }

    }

}
