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

        avatars.add("https://lh4.googleusercontent.com/proxy/Adcgt_KoWBO_hG2Ab16HvMSAHiZ9fAFFGv-ikLU6jPfPnxst2yVgKPCnyWCi13OWea9gZ5M0XYdO46iC9dftdNi8aAl-GUnI42Ysc_0DMWU");
        names.add("Good life inc");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQciI3q9T5j9BXd0gTJ6c3BZkhVWHQY9eFcupbg1e2fWetI0jQm&usqp=CAU");
        descriptions.add(" ");
        liked.add(false);

        avatars.add("https://sun9-68.userapi.com/c837430/v837430209/3a2e2/jQTKdB5nWds.jpg");
        names.add("SPORT & FITNESS");
        images.add("https://sun2.dataix-kz-akkol.userapi.com/c857120/v857120216/16ac60/M77uLj4yMxU.jpg");
        descriptions.add("Уилл Смит даже в свои 50 - топ \uD83D\uDCAA\uD83C\uDFFB Держит свое тело в хорошей форме!");
        liked.add(false);

        avatars.add("https://astellia595964941.files.wordpress.com/2019/10/assassin_icon.png?w=1024");
        names.add("Astellia");
        images.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQaJMpy5kFjgF0ImHr6Vw-ktGba3ePBGdpSWKwMOQFMW14v52JK&usqp=CAU");
        descriptions.add("Сколько у вас астелов ?" +
                "Какой астел по вашему самый сильный?");
        liked.add(false);

        avatars.add("https://sun9-35.userapi.com/c824203/v824203220/17e7d7/K2FvORqT7_E.jpg?ava=1");
        names.add("Душа Пацана");
        images.add("https://scontent-atl3-1.cdninstagram.com/v/t51.2885-15/e35/29715844_466461680438733_8318886172386394112_n.jpg?_nc_ht=scontent-atl3-1.cdninstagram.com&_nc_cat=109&_nc_ohc=qTIqCs1AQfYAX9TS1V7&oh=4a6e3a5698bdceee7017529aaa3a131e&oe=5EBDD09E");
        descriptions.add("");
        liked.add(false);

        avatars.add("https://sun9-56.userapi.com/c847020/v847020673/1c60ff/6Tr_gvLabOk.jpg");
        names.add("Elation");
        images.add("https://sun9-28.userapi.com/c857228/v857228940/178244/73zVaFtyVmE.jpg");
        descriptions.add("");
        liked.add(false);

        avatars.add("https://sun9-51.userapi.com/miixNPgPpCL5OAxDzh3zp_HFSzhzkP4px0oi6Q/027tGG393V8.jpg?ava=1");
        names.add("ЗЛОЙ НЕГР");
        images.add("https://lastmag.ru/wp-content/uploads/2019/05/bran-1.jpg");
        descriptions.add(" ");
        liked.add(false);

        avatars.add("https://sun9-66.userapi.com/c855228/v855228498/1a4656/nS7ihS-kZpo.jpg");
        names.add("E L E G A N T");
        images.add("https://sun1.dataix-kz-akkol.userapi.com/c635105/v635105578/205a0/kcslbQW4OXE.jpg");
        descriptions.add("");
        liked.add(false);

        avatars.add("https://sun9-40.userapi.com/c617928/v617928644/bc3f/myEKiulbEEg.jpg");
        names.add("UFC");
        images.add("https://sun2.dataix-kz-akkol.userapi.com/sWSmOtnI0EgU-YItyxnt5vEwFFt4avI5Dtt4iw/JrySXFatpFI.jpg");
        descriptions.add("");
        liked.add(false);

        avatars.add("https://sun9-26.userapi.com/c849536/v849536351/179124/houEASyBIPw.jpg");
        names.add("C H I C A G O");
        images.add("https://sun2.dataix-kz-akkol.userapi.com/c857328/v857328400/17e0e1/WwlFTXqbdns.jpg");
        descriptions.add("\uD83D\uDC4F\uD83C\uDFFB\uD83D\uDC4F\uD83C\uDFFB\uD83D\uDC4F\uD83C\uDFFB");
        liked.add(false);

        avatars.add("https://lh4.googleusercontent.com/proxy/Adcgt_KoWBO_hG2Ab16HvMSAHiZ9fAFFGv-ikLU6jPfPnxst2yVgKPCnyWCi13OWea9gZ5M0XYdO46iC9dftdNi8aAl-GUnI42Ysc_0DMWU");
        names.add("Good life inc");
        images.add("https://pp.vk.me/c636224/v636224690/15fdb/_yaAUvW3UD0.jpg");
        descriptions.add("");
        liked.add(false);
    }
}


