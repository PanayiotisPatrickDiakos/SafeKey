package au.edu.unsw.infs3634.gamifiedlearning;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    static final String BASE_URL = " https://newsapi.org/";
    //Sets API values for viewholder
    public void start(String headline, String apiKey, Callback<NewsResponse> callback) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsApiClient newsApi = retrofit.create(NewsApiClient.class);

        Call<NewsResponse> call = newsApi.getNews(headline, apiKey);
        call.enqueue(callback);

    }
}