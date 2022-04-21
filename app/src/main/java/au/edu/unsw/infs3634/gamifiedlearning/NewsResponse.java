package au.edu.unsw.infs3634.gamifiedlearning;

import java.util.List;

public class NewsResponse {
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }
    //fetches list list of news articles form NewsAPI
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
