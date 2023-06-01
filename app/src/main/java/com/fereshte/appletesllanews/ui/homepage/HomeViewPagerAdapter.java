package com.fereshte.appletesllanews.ui.homepage;

import com.fereshte.appletesllanews.ui.newspage.NewsFragment;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomeViewPagerAdapter extends FragmentStateAdapter {

    private final int tabNumbers = 2;

    public HomeViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        return NewsFragment.getInstance(i);
    }

    @Override
    public int getItemCount() {
        return tabNumbers;
    }
}
