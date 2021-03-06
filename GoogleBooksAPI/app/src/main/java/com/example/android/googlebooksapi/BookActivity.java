package com.example.android.googlebooksapi;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity
        implements LoaderCallbacks<List<Book>>{

    /**
     * Constant value for the Book loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private int Book_LOADER_ID = 1;

    /** Adapter for the list of Books */
    private BookAdapter mAdapter;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        // Find a reference to the {@link ListView} in the layout
        ListView BookListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        BookListView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes an empty list of Books as input
        mAdapter = new BookAdapter(this, new ArrayList<Book>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        BookListView.setAdapter(mAdapter);

        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected Book.
        BookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current Book that was clicked on
                Book currentBook = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri BookUri = Uri.parse(currentBook.getUrl());

                // Create a new intent to view the Book URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, BookUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected() && getUserInput()!= null && !getUserInput().matches("")) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(Book_LOADER_ID, null, this);
        } else if (networkInfo == null || !networkInfo.isConnected()){
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_search_request);
        }
    }
    public String getUserInput() {
        EditText searchText = (EditText) findViewById(R.id.search_field);
        String search = searchText.getText().toString();
        return search;
    }

    private String getUrlForHttpRequest() {
        final String baseUrl = "https://www.googleapis.com/books/v1/volumes?q=";
        String formatUserInput = getUserInput().trim().replaceAll("\\s+","+");
        String resultCap = "&maxResults=20";
        String url = baseUrl + formatUserInput+resultCap;
        return url;
    }

    @Override
    public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new BookLoader(this, getUrlForHttpRequest());
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> Books) {

    // Get a reference to the ConnectivityManager to check state of network connectivity
    ConnectivityManager connMgr = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE);
    // Get details on the currently active default data network
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

    if (networkInfo == null || !networkInfo.isConnected()){
        // Otherwise, display error
        // First, hide loading indicator so error message will be visible
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Update empty state with no connection error message
        mEmptyStateTextView.setText(R.string.no_internet_connection);
    } else {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Update empty state with no connection error message
        mEmptyStateTextView.setText(R.string.nothing_found);
    }

        // Clear the adapter of previous Book data
        mAdapter.clear();

        // If there is a valid list of {@link Book}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (Books != null && !Books.isEmpty()) {
            mAdapter.addAll(Books);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }


    public void submit (View view){
        mAdapter.clear();
        LoaderManager loaderManager = getLoaderManager();
        Book_LOADER_ID += 1;
        loaderManager.initLoader(Book_LOADER_ID, null, this);
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.VISIBLE);
        mEmptyStateTextView.setText("");
    }

}
