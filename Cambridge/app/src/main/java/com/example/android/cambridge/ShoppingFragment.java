package com.example.android.cambridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingFragment extends Fragment {
    public ShoppingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> Items = new ArrayList<Item>();
        Items.add(new Item(getString(R.string.shopping_1a), getString(R.string.shopping_1b)));
        Items.add(new Item(getString(R.string.shopping_2a), getString(R.string.shopping_2b)));
        Items.add(new Item(getString(R.string.shopping_3a), getString(R.string.shopping_3b)));
        Items.add(new Item(getString(R.string.shopping_4a), getString(R.string.shopping_4b)));
        Items.add(new Item(getString(R.string.shopping_5a), getString(R.string.shopping_5b)));
        ItemAdapter adapter = new ItemAdapter(getActivity(), Items, R.color.category_shopping);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}