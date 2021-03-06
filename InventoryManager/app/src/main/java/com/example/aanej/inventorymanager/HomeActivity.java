package com.example.aanej.inventorymanager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.aanej.inventorymanager.data.InventoryDbHelper;
import com.example.aanej.inventorymanager.data.StockItem;

public class HomeActivity extends AppCompatActivity {

    private final static String LOG_TAG = HomeActivity.class.getCanonicalName();
    InventoryDbHelper dbHelper;
    StockCursorAdapter adapter;
    int lastVisibleItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dbHelper = new InventoryDbHelper(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.readStock();

        adapter = new StockCursorAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == 0) return;
                final int currentFirstVisibleItem = view.getFirstVisiblePosition();
                if (currentFirstVisibleItem > lastVisibleItem) {
                    fab.show();
                } else if (currentFirstVisibleItem < lastVisibleItem) {
                    fab.hide();
                }
                lastVisibleItem = currentFirstVisibleItem;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readStock());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sellOneItem(id, quantity);
        adapter.swapCursor(dbHelper.readStock());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_dummy_data:
                // add dummy data for testing
                addDummyData();
                adapter.swapCursor(dbHelper.readStock());
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Add data for demo purposes
     */
    private void addDummyData() {

        StockItem crisps = new StockItem(
                "Crisps",
                "1.50",
                196,
                getString(R.string.supplier_name_hint),
                getString(R.string.supplier_phone_hint),
                getString(R.string.hint_email_address),
                "android.resource://com.example.aanej.inventorymanager/drawable/crisps");

        StockItem iron = new StockItem(
                "Iron",
                "29.99",
                9,
                getString(R.string.supplier_name_hint),
                getString(R.string.supplier_phone_hint),
                getString(R.string.hint_email_address),
                "android.resource://com.example.aanej.inventorymanager/drawable/iron");

        StockItem tshirt = new StockItem(
                "T-Shirt",
                "11",
                55,
                getString(R.string.supplier_name_hint),
                getString(R.string.supplier_phone_hint),
                getString(R.string.hint_email_address),
                "android.resource://com.example.aanej.inventorymanager/drawable/tshirt");

        StockItem orange = new StockItem(
                "Orange",
                "5/kg",
                200,
                getString(R.string.supplier_name_hint),
                getString(R.string.supplier_phone_hint),
                getString(R.string.hint_email_address),
                "android.resource://com.example.aanej.inventorymanager/drawable/orange");

        dbHelper.insertItem(crisps);
        dbHelper.insertItem(iron);
        dbHelper.insertItem(tshirt);
        dbHelper.insertItem(orange);
    }
}

