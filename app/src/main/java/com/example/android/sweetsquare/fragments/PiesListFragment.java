package com.example.android.sweetsquare.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.sweetsquare.R;
import com.example.android.sweetsquare.adapters.SimpleRecyclerViewAdapter;
import com.example.android.sweetsquare.model.Item;


import java.util.ArrayList;
import java.util.List;



/**
 * Created by Tanaskovic on 4/12/2018.
 */

public class PiesListFragment extends Fragment {

    ArrayList<Item> items;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_list, container, false);
        items = new ArrayList<>();

        items.add(new Item("Applepie", getActivity().getString(R.string.description_applepie),R.drawable.applepie));
        items.add(new Item("Fruitpie", getActivity().getString(R.string.description_fruitpie),R.drawable.fruitpie));
        items.add(new Item("Moonpie", getActivity().getString(R.string.description_moonpie),R.drawable.moonpie));

        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleRecyclerViewAdapter(getActivity(), items));
    }



}