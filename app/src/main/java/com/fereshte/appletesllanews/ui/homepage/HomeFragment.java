package com.fereshte.appletesllanews.ui.homepage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fereshte.appletesllanews.R;
import com.fereshte.appletesllanews.databinding.FragmentHomeBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(inflater);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        HomeViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        setUpViewPager();
    }

    private void setUpViewPager() {
        HomeViewPagerAdapter homeAdapter = new HomeViewPagerAdapter(this);
        mBinding.homeViewPager2.setAdapter(homeAdapter);
        new TabLayoutMediator(mBinding.homeTabs, mBinding.homeViewPager2, (tab, position) -> {
            if (position == 0)
                tab.setText(requireActivity().getResources().getString(R.string.apple));
            else tab.setText(requireActivity().getResources().getString(R.string.tesla));
        }).attach();
    }

}