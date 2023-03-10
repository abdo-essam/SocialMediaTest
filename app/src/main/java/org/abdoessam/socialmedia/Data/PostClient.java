package org.abdoessam.socialmedia.Data;

import org.abdoessam.socialmedia.Model.Post;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/" ;
    private IPost postInterface;
    private static PostClient INSTANCE;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        postInterface = retrofit.create(IPost.class);
    }

    public static PostClient getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new PostClient();

        return INSTANCE;
    }

    public Single<List<Post>> getPosts(){
        return postInterface.getPosts();
    }


}
