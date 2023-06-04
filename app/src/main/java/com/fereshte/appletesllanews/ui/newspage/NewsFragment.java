package com.fereshte.appletesllanews.ui.newspage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fereshte.appletesllanews.R;
import com.fereshte.appletesllanews.data.local.model.ArticlesObjectModel;
import com.fereshte.appletesllanews.databinding.FragmentNewsBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding mBinding;
    private NewsViewModel newsViewModel;
    private Boolean isAllNewsSet = true;
    private List<ArticlesObjectModel> list;
    private NewsAdapter adapter = new NewsAdapter(getContext(), list);

    public static Fragment getInstance(int position) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            isAllNewsSet = getArguments().getInt("position") == 0;

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentNewsBinding.inflate(inflater);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        if (isAllNewsSet)
            newsViewModel.getAppleNews(requireActivity().getResources().getString(R.string.apple));
        else
            newsViewModel.getTeslaNews(requireActivity().getResources().getString(R.string.tesla));
        observeProgressBar();
        observeRecyclerView();
    }

    private void observeProgressBar() {
        newsViewModel.getProgressVisibility().observe(requireActivity(), isVisible -> {
            if (isVisible)
                setViewsVisibility(View.VISIBLE, View.GONE);
            else
                setViewsVisibility(View.GONE, View.VISIBLE);

        });
    }

    private void setViewsVisibility(int progressbarVisibility, int recyclerVisibility) {
        mBinding.newsPb.setVisibility(progressbarVisibility);
        mBinding.newsRcv.setVisibility(recyclerVisibility);
    }

    private void observeRecyclerView() {
        newsViewModel.getArticlesList().observe(requireActivity(),
                this::setupRecyclerView);
    }

    private void setupRecyclerView(List<ArticlesObjectModel> news) {
        adapter = new NewsAdapter(getContext(), news);
        mBinding.newsRcv.setAdapter(adapter);
    }

}