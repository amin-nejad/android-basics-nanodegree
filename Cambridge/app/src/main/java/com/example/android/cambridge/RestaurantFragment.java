package com.example.android.cambridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantFragment extends Fragment {
    public RestaurantFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> Items = new ArrayList<Item>();
        Items.add(new Item(getString(R.string.restaurant_1a), getString(R.string.restaurant_1b)));
        Items.add(new Item(getString(R.string.restaurant_2a), getString(R.string.restaurant_2b)));
        Items.add(new Item(getString(R.string.restaurant_3a), getString(R.string.restaurant_3b)));
        Items.add(new Item(getString(R.string.restaurant_4a), getString(R.string.restaurant_4b)));
        Items.add(new Item(getString(R.string.restaurant_5a), getString(R.string.restaurant_5b)));
        Items.add(new Item(getString(R.string.restaurant_6a), getString(R.string.restaurant_6b)));
        Items.add(new Item(getString(R.string.restaurant_7a), getString(R.string.restaurant_7b)));
        Items.add(new Item(getString(R.string.restaurant_8a), getString(R.string.restaurant_8b)));
        ItemAdapter adapter = new ItemAdapter(getActivity(), Items, R.color.category_restaurants);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}