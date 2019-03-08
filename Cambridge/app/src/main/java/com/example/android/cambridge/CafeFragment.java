package com.example.android.cambridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CafeFragment extends Fragment {
    public CafeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> Items = new ArrayList<Item>();
        Items.add(new Item(getString(R.string.cafe_1a), getString(R.string.cafe_1b)));
        Items.add(new Item(getString(R.string.cafe_2a), getString(R.string.cafe_2b)));
        Items.add(new Item(getString(R.string.cafe_3a), getString(R.string.cafe_3b)));
        Items.add(new Item(getString(R.string.cafe_4a), getString(R.string.cafe_4b)));
        Items.add(new Item(getString(R.string.cafe_5a), getString(R.string.cafe_5b)));
        ItemAdapter adapter = new ItemAdapter(getActivity(), Items, R.color.category_cafes);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}