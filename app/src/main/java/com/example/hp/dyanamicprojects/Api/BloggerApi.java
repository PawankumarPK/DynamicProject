package com.example.hp.dyanamicprojects.Api;

/*
created by PAWAN KUMAR
*/


import com.example.hp.dyanamicprojects.PostList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerApi {

    private static final String key = "AIzaSyBFu7whp8jeFS3KynBnxpW_0F0wMJkI5E4";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/6505351807608278713/posts/";

    public static PostService postService = null;

    public static PostService getService(){
        if (postService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService{
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }

}
