package com.example.vaibhav.fromcategory;

import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarFinalValueListener;
import com.crystal.crystalrangeseekbar.widgets.CrystalRangeSeekbar;

import java.util.ArrayList;
import java.util.List;

import adapter.FromCategoryAdapter;
import model.FRomCategoryModel;


public class FromCategoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private FromCategoryAdapter fromCategoryAdapter;
    private RecyclerView recyclerview;
    private ArrayList<FRomCategoryModel> fRomCategoryModelArrayList;

    Integer img1[] = {R.drawable.ic_like_heart_outline, R.drawable.ic_like_heart_outline, R.drawable.ic_like_heart_outline, R.drawable.ic_like_heart_outline,};
    Integer img2[] = {R.drawable.shoes3, R.drawable.s6, R.drawable.s6, R.drawable.shoes3};
    String offer[] = {"75%", "25%", "30%", "25%"};
    String price[] = {"$75", "$225", "$210", "$145"};
    String shoes[] = {"Ninja high top sneackers", "Ninja high top sneackers", "Ninja high top sneackers", "Ninja high top sneackers"};

    Spinner spinner_sort_by, spinner_category, spinner_sub_category, spinner_brand, spinner_website;


    private ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    private DrawerLayout drawer;
    private android.support.v7.widget.Toolbar toolbar;
    LinearLayout linear_filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_category);

        final CrystalRangeSeekbar rangeSeekbar = (CrystalRangeSeekbar) findViewById(R.id.rangeSeekbar1);


        final TextView tvMin = (TextView) findViewById(R.id.textMin1);
        final TextView tvMax = (TextView) findViewById(R.id.textMin2);

// set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                tvMin.setText("$ " + String.valueOf(minValue));
                tvMax.setText("$ " + String.valueOf(maxValue));
            }
        });

// set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue) {
                Log.d("CRS=>", String.valueOf(minValue) + " : " + String.valueOf(maxValue));
            }
        });


        spinner_sort_by = (Spinner) findViewById(R.id.spinner_sort_by);

        //        Spinner for Sending Id

        List<String> list = new ArrayList<String>();
        list.add("Select Your Choice");
        list.add("Order by title (A-Z)");
        list.add("Order by title (A-Z)");
        list.add("Order by title (A-Z)");
        list.add("Order by title (A-Z)");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(FromCategoryActivity.this, R.layout.spinner_item, R.id.spinner_text, list);
        spinner_sort_by.setAdapter(dataAdapter);


        spinner_category = (Spinner) findViewById(R.id.spinner_category);

        //        Spinner for Sending Id

        List<String> list1 = new ArrayList<String>();
        list1.add("Select Your Category");
        list1.add("Appliances");
        list1.add("Clothes");
        list1.add("Mobile");
        list1.add("Kitchen");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(FromCategoryActivity.this, R.layout.spinner_item, R.id.spinner_text, list1);
        spinner_category.setAdapter(dataAdapter1);


        spinner_sub_category = (Spinner) findViewById(R.id.spinner_sub_category);

        //        Spinner for Sending Id

        List<String> list2 = new ArrayList<String>();
        list2.add("Select Your Sub Category");
        list2.add("ALL");
        list2.add("ALL");
        list2.add("ALL");
        list2.add("ALL");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(FromCategoryActivity.this, R.layout.spinner_item, R.id.spinner_text, list2);
        spinner_sub_category.setAdapter(dataAdapter2);


        spinner_brand = (Spinner) findViewById(R.id.spinner_brand);

        //        Spinner for Sending Id

        List<String> list3 = new ArrayList<String>();
        list3.add("Select Your Brand");
        list3.add("ALL");
        list3.add("ALL");
        list3.add("ALL");
        list3.add("ALL");

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(FromCategoryActivity.this, R.layout.spinner_item, R.id.spinner_text, list3);
        spinner_brand.setAdapter(dataAdapter3);


        spinner_website = (Spinner) findViewById(R.id.spinner_website);

        //        Spinner for Sending Id

        List<String> list4 = new ArrayList<String>();
        list4.add("Select Your WebSite");
        list4.add("ALL");
        list4.add("ALL");
        list4.add("ALL");
        list4.add("ALL");

        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(FromCategoryActivity.this, R.layout.spinner_item, R.id.spinner_text, list4);
        spinner_website.setAdapter(dataAdapter4);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        openDrawer();

        setLinear_filter();


//        recyclerview code is here

        recyclerview = findViewById(R.id.recyclerview3);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(FromCategoryActivity.this, 2);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        fRomCategoryModelArrayList = new ArrayList<>();

        for (int i = 0; i < img1.length; i++) {
            FRomCategoryModel view = new FRomCategoryModel(img1[i], img2[i], offer[i], price[i], shoes[i]);
            fRomCategoryModelArrayList.add(view);
        }
        fromCategoryAdapter = new FromCategoryAdapter(FromCategoryActivity.this, fRomCategoryModelArrayList);
        recyclerview.setAdapter(fromCategoryAdapter);







        actionBarDrawerToggle = new ActionBarDrawerToggle(FromCategoryActivity.this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };




        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        invalidateOptionsMenu();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.END)) {

            drawer.closeDrawer(Gravity.RIGHT); //OPEN Nav Drawer!
        } else {
            finish();
        }
    }

    private void setLinear_filter() {
        linear_filter = (LinearLayout) findViewById(R.id.linear_filter);
        //setActionBar(linear_filter);
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle("");

        linear_filter.findViewById(R.id.linear_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("Click", "keryu");

                if (drawer.isDrawerOpen(navigationView)) {
                    drawer.closeDrawer(navigationView);
                } else {
                    drawer.openDrawer(navigationView);

                    Log.e("abc", "abc");
                }
            }
        });
    }



    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem item){


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;


    }

    public void openDrawer(){
        drawer.openDrawer(navigationView);
    }



}











