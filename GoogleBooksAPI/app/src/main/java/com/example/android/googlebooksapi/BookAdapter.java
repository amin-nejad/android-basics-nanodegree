package com.example.android.googlebooksapi;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> Books) {
        super(context, 0, Books);
    }

    /**
     * Returns a list item view that displays information about the Book at the given position
     * in the list of Books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        Book currentBook = getItem(position);

        TextView yearView = (TextView) listItemView.findViewById(R.id.year);
        String formattedYear = String.valueOf(currentBook.getYear());
        yearView.setText(formattedYear);

        GradientDrawable yearCircle = (GradientDrawable) yearView.getBackground();
        int yearColor = getYearColor(currentBook.getYear());
        yearCircle.setColor(yearColor);

        String author = currentBook.getAuthor();
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(author);

        String title = currentBook.getTitle();
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(title);

        String language = currentBook.getLanguage();
        TextView languageView = (TextView) listItemView.findViewById(R.id.language);
        languageView.setText(language);

        String pages = String.valueOf(currentBook.getPages());
        pages += " pages";
        TextView pagesView = (TextView) listItemView.findViewById(R.id.pages);
        pagesView.setText(pages);

        return listItemView;
    }

    private int getYearColor(int year) {
        int yearColorResourceId;
        double yearFloor = (double) 5*Math.floor(year/5);
        int yearFloor2 = (int)yearFloor;
        switch (yearFloor2) {
            case 1975:
                yearColorResourceId = R.color.color1;
                break;
            case 1980:
                yearColorResourceId = R.color.color2;
                break;
            case 1985:
                yearColorResourceId = R.color.color3;
                break;
            case 1990:
                yearColorResourceId = R.color.color4;
                break;
            case 1995:
                yearColorResourceId = R.color.color5;
                break;
            case 2000:
                yearColorResourceId = R.color.color6;
                break;
            case 2005:
                yearColorResourceId = R.color.color7;
                break;
            case 2010:
                yearColorResourceId = R.color.color8;
                break;
            case 2015:
                yearColorResourceId = R.color.color9;
                break;
            default:
                yearColorResourceId = R.color.color10;
                break;
        }

        return ContextCompat.getColor(getContext(), yearColorResourceId);
    }
}