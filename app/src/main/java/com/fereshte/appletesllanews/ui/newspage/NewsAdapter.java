package com.fereshte.appletesllanews.ui.newspage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fereshte.appletesllanews.data.local.model.ArticlesObjectModel;
import com.fereshte.appletesllanews.databinding.ItemNewsBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final Context context;
    private final List<ArticlesObjectModel> list;

    public NewsAdapter(Context context, List<ArticlesObjectModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemNewsBinding binding = ItemNewsBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        holder.itemBinding.setArticles(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ItemNewsBinding itemBinding;
        public ViewHolder(ItemNewsBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }
    }

}
