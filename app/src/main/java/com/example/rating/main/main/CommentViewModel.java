package com.example.rating.main.main;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rating.R;

import java.util.ArrayList;
import java.util.List;

public class CommentViewModel extends ViewModel {
    private MutableLiveData<List<Comment>> mutableLiveData;
    private List<Comment> comments;

    public CommentViewModel() {
        mutableLiveData = new MutableLiveData<>();
        comments = new ArrayList<>();
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 4, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt2, "Park H***", "06-04-2021 11:36", 5, "Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING! \n" +
                "See more"));
        comments.add(new Comment(R.drawable.avt3, "Kim*******", "06-04-2021 11:36", 3, "Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come"));
        comments.add(new Comment(R.drawable.avt4, "Kim Joong***", "06-04-2021 11:36", 4, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 2, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 3, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 4, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 5, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 3, "I am very satisfied with this product "));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 2, "I am very satisfied with this product "));
        mutableLiveData.setValue(comments);
    }
    public LiveData<List<Comment>> getListCommentLiveData() {
        return mutableLiveData;
    }
}
