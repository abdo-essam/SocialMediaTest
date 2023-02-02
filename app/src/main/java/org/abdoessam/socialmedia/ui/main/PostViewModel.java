package org.abdoessam.socialmedia.ui.main;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import org.abdoessam.socialmedia.Data.PostClient;
import org.abdoessam.socialmedia.Model.Post;
import java.util.List;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.schedulers.Schedulers;


public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";
    MutableLiveData<List<Post>> postsMutableLiveData = new MutableLiveData<>();
    public void getPosts(){
        Single<List<Post>> observable = PostClient.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(value-> postsMutableLiveData.setValue(value) , error -> Log.d(TAG,"getPosts"+error));
}}
