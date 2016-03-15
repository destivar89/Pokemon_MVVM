package com.gladheim.pokemonmvvm.detail.ui.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.transition.ChangeBounds;

import javax.inject.Inject;

import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.R;
import com.gladheim.pokemonmvvm.databinding.ActivityDetailBinding;
import com.gladheim.pokemonmvvm.detail.di.DaggerDetailComponent;
import com.gladheim.pokemonmvvm.detail.di.DetailComponent;
import com.gladheim.pokemonmvvm.detail.di.DetailModule;
import com.gladheim.pokemonmvvm.detail.ui.viewmodel.DetailViewModel;
import com.gladheim.pokemonmvvm.global.ui.view.BaseActivity;


/**
 * Created by destivar on 04/03/16.
 */
public class DetailActivity extends BaseActivity implements DetailView{

    @Inject
    DetailViewModel viewModel;

    private PokemonItem pokemonItem;
    private DetailComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        pokemonItem = (PokemonItem) getIntent().getSerializableExtra(getString(R.string.extra_pokemon_item));
        setupWindowAnimations();

        component().inject(this);
        bindData();

        viewModel.getPokemon();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail;
    }

    private void bindData() {
        ActivityDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setViewModel(viewModel);
    }

    private void setupWindowAnimations() {
        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        getWindow().setSharedElementReturnTransition(new ChangeBounds());
    }

    private DetailComponent component() {
        if(component == null){
            component = DaggerDetailComponent.builder()
                    .detailModule(new DetailModule(this, pokemonItem))
                    .build();
        }
        return component;
    }

    @Override
    public void showErrorFeedback() {
        //TODO: show error feedback snackbar
    }
}
