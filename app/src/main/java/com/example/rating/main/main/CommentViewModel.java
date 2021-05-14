package com.example.rating.main.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.rating.R;

import java.util.ArrayList;
import java.util.List;

public class CommentViewModel extends ViewModel {
    private final MutableLiveData<List<Comment>> mutableLiveData;

    public CommentViewModel() {
        mutableLiveData = new MutableLiveData<>();
        List<Comment> comments = new ArrayList<>();
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 4,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1,"I am very satisfied with this product ",false,false,null,null));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 4,true,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false,false, null, null));
        comments.add(new Comment(R.drawable.avt2, "Park H***", "06-04-2021 11:36", 5, false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1,"Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come out haha. It’s like famine and then feast and dresses HAPPY SPRING!", true,false, null,null));
        comments.add(new Comment(R.drawable.avt3, "Kim*******", "06-04-2021 11:36", 3,true,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "Every spring I start going through dress withdrawals and go crazy over all the pretty spring dresses that come",false,true, "Angela Soraphiare Shop", "Hi, thank you for feedback"));
        comments.add(new Comment(R.drawable.avt4, "Kim Joong***", "06-04-2021 11:36", 4,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, false, null, null));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 2,true,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, false,null, null));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 3,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, false, null, null));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 4,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, true,"Angela Soraphiare Shop", "Hi, thank you for feedback"));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 5,true,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, false,null, null));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 3,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, true,"Angela Soraphiare Shop", "Hi, thank you for feedback"));
        comments.add(new Comment(R.drawable.avt1,"Kim Joong***", "06-04-2021 11:36", 2,false,R.drawable.iv1, R.drawable.iv2,R.drawable.iv3,R.drawable.iv4,R.drawable.iv1, "I am very satisfied with this product ",false, false, null, null));
        mutableLiveData.setValue(comments);
    }
    public LiveData<List<Comment>> getListCommentLiveData() {
        return mutableLiveData;
    }
}
