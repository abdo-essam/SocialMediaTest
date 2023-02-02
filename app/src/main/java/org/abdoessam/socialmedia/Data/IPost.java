package org.abdoessam.socialmedia.Data;

import org.abdoessam.socialmedia.Model.Post;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface IPost {
    @GET("posts")
    public Single<List<Post>> getPosts() ;

}
