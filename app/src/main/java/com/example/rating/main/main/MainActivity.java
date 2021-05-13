package com.example.rating.main.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rating.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvComment;
    private CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvComment = findViewById(R.id.rv_comment);
        rvComment.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        rvComment.setLayoutManager(linearLayoutManager);
        CommentViewModel commentViewModel = new ViewModelProvider(this).get(CommentViewModel.class);
        commentViewModel.getListCommentLiveData().observe(this, comments -> {
            if(commentAdapter == null) {
                commentAdapter = new CommentAdapter(comments, this);
                rvComment.setAdapter(commentAdapter);
                commentAdapter.notifyDataSetChanged();
            }
        });
    }
}