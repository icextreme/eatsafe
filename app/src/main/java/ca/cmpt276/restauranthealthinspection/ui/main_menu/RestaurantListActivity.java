package ca.cmpt276.restauranthealthinspection.ui.main_menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ca.cmpt276.restauranthealthinspection.R;
import ca.cmpt276.restauranthealthinspection.model.RestaurantManager;

/**
 * Main menu display a list of restaurants and their appropriate information.
 * It will also initializes the model.
 */
public class RestaurantListActivity extends AppCompatActivity {

    private RestaurantManager restaurants;

    public static Intent makeLaunchIntent(Context context) {
        return new Intent(context, RestaurantListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        restaurants = RestaurantManager.getInstance(this);
        setupRecyclerView();
        Log.d("test", "created");
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMain);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, restaurants);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public enum HazardLevel {
        LOW, MEDIUM, HIGH
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }

    @Override
    public void onResume() {
        setupRecyclerView();
        super.onResume();
    }

    //Menu setup
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_restuarant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item_return_map) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
