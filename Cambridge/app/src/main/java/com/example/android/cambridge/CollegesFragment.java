package com.example.android.cambridge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegesFragment extends Fragment {
    public CollegesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> Items = new ArrayList<Item>();
        Items.add(new Item(getString(R.string.college_1a), getString(R.string.college_1b), R.drawable.catz));
        Items.add(new Item(getString(R.string.college_2a), getString(R.string.college_2b), R.drawable.christs));
        Items.add(new Item(getString(R.string.college_3a), getString(R.string.college_3b), R.drawable.trinity));
        Items.add(new Item(getString(R.string.college_4a), getString(R.string.college_4b), R.drawable.kings));
        Items.add(new Item(getString(R.string.college_5a), getString(R.string.college_5b), R.drawable.sidney));
        Items.add(new Item(getString(R.string.college_6a), getString(R.string.college_6b), R.drawable.downing));
        Items.add(new Item(getString(R.string.college_7a), getString(R.string.college_7b), R.drawable.girton));
        ItemAdapter adapter = new ItemAdapter(getActivity(), Items, R.color.category_colleges);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        return rootView;
    }
}
