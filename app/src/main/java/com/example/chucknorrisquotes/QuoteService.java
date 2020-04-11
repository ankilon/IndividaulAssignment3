package com.example.chucknorrisquotes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteService {
    @GET("jokes/random/")
    Call<Quote> getAllQuotes();
}
