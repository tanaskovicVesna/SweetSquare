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

public class BeverageListFragment  extends Fragment {
    ArrayList<Item> items;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_list, container, false);

        items = new ArrayList<>();
        items.add(new Item("Lemonade", getActivity().getString(R.string.description_lemonade),R.drawable.lemonade));
        items.add(new Item("Cola", getActivity().getString(R.string.description_cola),R.drawable.cola));
        items.add(new Item("Juice", getActivity().getString(R.string.description_juice),R.drawable.juice));
        items.add(new Item("Water", getActivity().getString(R.string.description_water),R.drawable.water));
        items.add(new Item("Tea", getActivity().getString(R.string.description_tea),R.drawable.tea));
        items.add(new Item("Schnapps", getActivity().getString(R.string.description_schnapps),R.drawable.schnapps));
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleRecyclerViewAdapter(getActivity(), items));
    }


}
