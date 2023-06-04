package com.fereshte.appletesllanews.ui.newspage;

import android.app.Application;
import android.util.Log;
import com.fereshte.appletesllanews.R;
import com.fereshte.appletesllanews.data.local.model.ArticlesObjectModel;
import com.fereshte.appletesllanews.data.local.model.NewsModel;
import com.fereshte.appletesllanews.data.repository.NewsRepository;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends AndroidViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<List<ArticlesObjectModel>> articlesList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isProgressVisible = new MutableLiveData<>();

    public NewsViewModel(@NonNull Application application) {
        super(application);
        repository = new NewsRepository(application);
        setProgressVisibility(true);
    }
    public LiveData<List<ArticlesObjectModel>> getArticlesList() {
        return articlesList;
    }
    public void setArticlesList(List<ArticlesObjectModel> articlesList) {
        this.articlesList.setValue(articlesList);
    }
    public LiveData<Boolean> getProgressVisibility() {
        return isProgressVisible;
    }
    public void setProgressVisibility(Boolean isVisible){
        isProgressVisible.setValue(isVisible);}
    public void getAppleNews(String company) {
        getNews(company);
    }
    public void getTeslaNews(String company) {
        getNews(company);
    }
    private void getNews(String company) {
        Call<NewsModel> call =
                repository.getApiServiceData(company,
                        "2023-05-04",
                        "publishedAt",
                        getApplication().getResources().getString(R.string.api_key));
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(@NonNull Call<NewsModel> call, @NonNull Response<NewsModel> response) {
                if(response.body() != null){
                    setProgressVisibility(false);
                    setArticlesList(response.body().getArticles());
                }
            }
            @Override
            public void onFailure(@NonNull Call<NewsModel> call, @NonNull Throwable t) {
                setProgressVisibility(true);
            }
        });
    }
    
}
