package com.example.rating.main.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.example.rating.R;

public class MainActivity extends AppCompatActivity {
    private RatingBar rbFiveStar;
    private RatingBar rbFourStar;
    private RatingBar rbThreeStar;
    private RatingBar rbTwoStar;
    private RatingBar rbOneStar;
    private RecyclerView rvComment;
    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRatingBar();
        rvComment = findViewById(R.id.rv_comment);
        setRecyclerViewComment();
    }

    private void setRecyclerViewComment() {
        rvComment.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvComment.setLayoutManager(linearLayoutManager);

        CommentViewModel commentViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) new CommentViewModel(getApplication())).get(CommentViewModel.class);
        commentViewModel.getListCommentLiveData().observe(this, comments -> {
            commentAdapter = new CommentAdapter(comments, (CommentAdapter.ItemClickListener) getApplication());
            rvComment.setAdapter(commentAdapter);
        });
    }

    private void setRatingBar() {
        rbFiveStar = findViewById(R.id.rb_rating_star_five);
        rbFourStar = findViewById(R.id.rb_rating_star_four);
        rbThreeStar = findViewById(R.id.rb_rating_star_three);
        rbTwoStar = findViewById(R.id.rb_rating_star_two);
        rbOneStar = findViewById(R.id.rb_rating_star_one);
        rbFiveStar.setRating(5);
        rbFourStar.setRating(4);
        rbThreeStar.setRating(3);
        rbTwoStar.setRating(2);
        rbOneStar.setRating(1);
    }
}