package org.abdoessam.socialmedia.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.abdoessam.socialmedia.Data.PostClient;
import org.abdoessam.socialmedia.Model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Post>> postsMutableLiveData = new MutableLiveData<>();
    public void getPosts(){
        PostClient.getINSTANCE().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postsMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }
}
