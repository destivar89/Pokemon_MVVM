package com.gladheim.pokemonmvvm.list.ui.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeBounds;
import android.view.View;

import com.gladheim.pokemonapi.data.PokemonItem;
import com.gladheim.pokemonmvvm.R;
import com.gladheim.pokemonmvvm.databinding.ActivityListBinding;
import com.gladheim.pokemonmvvm.detail.ui.view.DetailActivity;
import com.gladheim.pokemonmvvm.global.ui.transition.TransitionHelper;
import com.gladheim.pokemonmvvm.global.ui.view.BaseActivity;
import com.gladheim.pokemonmvvm.list.di.DaggerListComponent;
import com.gladheim.pokemonmvvm.list.di.ListComponent;
import com.gladheim.pokemonmvvm.list.di.ListModule;
import com.gladheim.pokemonmvvm.list.ui.adapter.PokemonAdapter;
import com.gladheim.pokemonmvvm.list.ui.viewmodel.ListViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends BaseActivity implements ListView {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    ListViewModel viewModel;

    private PokemonAdapter adapter;
    private ListComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        adapter = new PokemonAdapter(this);

        setupWindowAnimations();

        component().inject(this);
        bindData();
        ButterKnife.bind(this);

        initRecyclerView();
        List<PokemonItem> pokemonItems = (List<PokemonItem>) getIntent().getSerializableExtra(getString(R.string.extra_pokemon_list));
        Throwable t = (Throwable) getIntent().getSerializableExtra(getString(R.string.extra_error));

        if (t == null) {
            viewModel.setPokemons(pokemonItems);
        }else {
            showErrorFeedback(t);
        }

    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list;
    }


    private void bindData() {
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setViewModel(viewModel);
    }

    private void setupWindowAnimations() {
        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        getWindow().setSharedElementReturnTransition(new ChangeBounds());
    }

    private ListComponent component() {
        if(component == null){
            component = DaggerListComponent.builder()
                    .listModule(new ListModule(this, adapter))
                    .build();
        }
        return component;
    }

    private void showErrorFeedback(Throwable t) {
        //TODO: show snackbar
    }

    @Override
    public void goToDetail(PokemonItem pokemon, View card) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(getString(R.string.extra_pokemon_item), pokemon);
        Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, false,
                new Pair<>(card.findViewById(R.id.pokemon_image), getString(R.string.shared_thumb)),
                new Pair<>(card.findViewById(R.id.pokemon_name), getString(R.string.shared_name)));
        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
        startActivity(detailIntent, transitionActivityOptions.toBundle());
    }
}
