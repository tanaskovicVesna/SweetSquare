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

/**
 * Created by Tanaskovic on 4/29/2018.
 */

public class CoffeesListFragment extends Fragment {
    ArrayList<Item> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_list, container, false);

        items = new ArrayList<>();
        items.add(new Item("Traditional coffee", getActivity().getString(R.string.description_traditional_coffee),R.drawable.turkishcoffee));
        items.add(new Item("Espresso", getActivity().getString(R.string.description_espresso),R.drawable.espresso));
        items.add(new Item("Nescafe", getActivity().getString(R.string.description_nescafe),R.drawable.nescafe));
        items.add(new Item("Cappuccino", getActivity().getString(R.string.description_cappuccino),R.drawable.cappucino));
        items.add(new Item("Macchiato", getActivity().getString(R.string.description_macchiato),R.drawable.macchiato));
        items.add(new Item("Iced coffee", getActivity().getString(R.string.description_iced_coffee),R.drawable.icedcoffee));
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleRecyclerViewAdapter(getActivity(), items));
    }


}

