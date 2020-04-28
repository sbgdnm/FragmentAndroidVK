package com.example.vkfragmentlike;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numberOfTabs;
    BottomNavigationView bottomNavigationView;

    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
//                BadgeDrawable badge = bottomNavigationView.findViewById(R.id.bottomNavigationView).getOrCreateBadge(menuItemId);
//                badge.setVisible(true);
                return new HomeFragment();
            case 1:
                return new FavoriteFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public int getItemPosition(Object object) {
    // POSITION_NONE makes it possible to reload the PagerAdapter
        return POSITION_UNCHANGED;
    }

    public String getFragmentTag(int viewPagerId, int fragmentPosition) {
        // This is the format in which FragmentStatePagerAdapter internally set's  the fragment tag.
        return "android:switcher:" + viewPagerId + ":" + fragmentPosition;
    }
}
