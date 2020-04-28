package com.example.vkfragmentlike;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static ArrayList<String> avatars = new ArrayList<>();
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> images = new ArrayList<>();
    public static ArrayList<String> descriptions = new ArrayList<>();
    public static ArrayList<Boolean> liked = new ArrayList<>();
    static ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        initImageBitmaps();

        initFragmentPagerAdapter();

        initBottomNavigation();
    }

    private void initFragmentPagerAdapter(){

        viewPager = findViewById(R.id.viewPager);
        PagerAdapter ViewPagerAdapter = new PagerAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(ViewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initBottomNavigation(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewPager.setCurrentItem(0);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        //if(!(selectedFragment instanceof HomeFragment)) {
                            viewPager.setCurrentItem(0);
                        //}
                        break;
                    case R.id.nav_favorite:
                        //if(!(selectedFragment instanceof FavoriteFragment)) {
                            viewPager.setCurrentItem(1);
                        //}
                        break;
                }
                return true;
            }
        });
    }

    private void ClearAllData(){
        avatars.clear();
        names.clear();
        images.clear();
        descriptions.clear();
        liked.clear();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        liked.clear();
        boolean[] likedArray = savedInstanceState.getBooleanArray("liked");
        for (int i = 0; i < likedArray.length; i++) {
            liked.add(likedArray[i]);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean[] likedArray = new boolean[10];
        for (int i = 0; i < liked.size(); i++) {
            likedArray[i] = liked.get(i);
        }
        outState.putBooleanArray("liked", likedArray);
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: ");

        ClearAllData();

        avatars.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        names.add("Profile1");
        images.add("https://rabbitsauthority.com/wp-content/uploads/2019/10/Natural-Ways-to-Get-Rid-of-Rabbits-in-the-Garden.jpg");
        descriptions.add("description1");
        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMIzuU4_yi6VFSkaB4HKgjAvlaFI829syDNo7cX0A--gOXtiDv");
        names.add("Profile2");
        images.add("https://physicsworld.com/wp-content/uploads/2019/08/unique-climate-change-800x533.jpg");
        descriptions.add("description2");
        liked.add(false);

        avatars.add("https://image.winudf.com/v2/image/Y29tLmdhbGxvc3R1ZGlvcy5idXR0ZXJmbHl3YWxscGFwZXJfc2NyZWVuXzZfMTUxNzY3MTQ0Ml8wODk/screen-6.jpg?fakeurl=1&type=.jpg");
        names.add("Profile3");
        images.add("https://www.pandotrip.com/wp-content/uploads/2018/09/Seigantoji-Pagoda-and-Nachi-Falls-in-Nacho-Japan.jpg");
        descriptions.add("description3");
        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcToho9UkmEZgSNFVcU-0vr23cNi5gdjzS16fYBn8HTbjkK-WxCj");
        names.add("Profile4");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR42tkvGLQZ0Uklh5rT_zI6NnEiutbL3smyh2MJ1IjTwdCBjgwq");
        descriptions.add("description4");
        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6rF2jBfUZFhnjwZw2sF0i95mygUpmJ6v2KKr7Zetx_9UNF6Kn");
        names.add("Profile5");
        images.add("https://www.pandotrip.com/wp-content/uploads/2018/09/Yakushima-Island-UNESCO-World-Heritage-Site-in-Japan.jpg");
        descriptions.add("description5");
        liked.add(false);

        avatars.add("https://images.pexels.com/photos/257360/pexels-photo-257360.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        names.add("Profile6");
        images.add("https://rabbitsauthority.com/wp-content/uploads/2019/10/Natural-Ways-to-Get-Rid-of-Rabbits-in-the-Garden.jpg");
        descriptions.add("description6");
        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMIzuU4_yi6VFSkaB4HKgjAvlaFI829syDNo7cX0A--gOXtiDv");
        names.add("Profile7");
        images.add("https://physicsworld.com/wp-content/uploads/2019/08/unique-climate-change-800x533.jpg");
        descriptions.add("description7");
        liked.add(false);

        avatars.add("https://image.winudf.com/v2/image/Y29tLmdhbGxvc3R1ZGlvcy5idXR0ZXJmbHl3YWxscGFwZXJfc2NyZWVuXzZfMTUxNzY3MTQ0Ml8wODk/screen-6.jpg?fakeurl=1&type=.jpg");
        names.add("Profile8");
        images.add("https://www.pandotrip.com/wp-content/uploads/2018/09/Seigantoji-Pagoda-and-Nachi-Falls-in-Nacho-Japan.jpg");
        descriptions.add("description8");

        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcToho9UkmEZgSNFVcU-0vr23cNi5gdjzS16fYBn8HTbjkK-WxCj");
        names.add("Profile9");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR42tkvGLQZ0Uklh5rT_zI6NnEiutbL3smyh2MJ1IjTwdCBjgwq");
        descriptions.add("description9");
        liked.add(false);

        avatars.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS6rF2jBfUZFhnjwZw2sF0i95mygUpmJ6v2KKr7Zetx_9UNF6Kn");
        names.add("Profile10");
        images.add("https://www.pandotrip.com/wp-content/uploads/2018/09/Yakushima-Island-UNESCO-World-Heritage-Site-in-Japan.jpg");
        descriptions.add("description10");
        liked.add(false);
    }
}


