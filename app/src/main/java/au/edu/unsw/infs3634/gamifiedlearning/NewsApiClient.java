package au.edu.unsw.infs3634.gamifiedlearning;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiClient {
    @GET("/v2/top-headlines")
    Call<NewsResponse> getNews(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey);
}
