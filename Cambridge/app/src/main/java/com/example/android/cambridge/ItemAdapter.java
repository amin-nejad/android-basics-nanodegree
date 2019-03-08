package com.example.android.cambridge;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    private int mColorResourceId;

    public ItemAdapter(Context context, ArrayList<Item> Items, int colorResourceId) {
        super(context, 0, Items);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Item currentItem = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentItem.getName());
        TextView infoTextView = (TextView) listItemView.findViewById(R.id.info_text_view);
        infoTextView.setText(currentItem.getInfo());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentItem.hasImage()) {
            imageView.setImageResource(currentItem.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}