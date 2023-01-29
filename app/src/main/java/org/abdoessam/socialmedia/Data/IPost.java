package org.abdoessam.socialmedia.Data;

import org.abdoessam.socialmedia.Model.Post;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;


public interface IPost {
    @GET("posts")
    public Call<List<Post>> getPosts() ;

}
