package com.example.rating.main.main;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rating.R;

import java.util.List;

class FilterVH extends RecyclerView.ViewHolder {

    public RatingBar rbFiveStar;
    public RatingBar rbFourStar;
    public RatingBar rbThreeStar;
    public RatingBar rbTwoStar;
    public RatingBar rbOneStar;
    public FilterVH(@NonNull View itemView) {
        super(itemView);
        rbFiveStar = itemView.findViewById(R.id.rb_rating_star_five);
        rbFourStar = itemView.findViewById(R.id.rb_rating_star_four);
        rbThreeStar = itemView.findViewById(R.id.rb_rating_star_three);
        rbTwoStar = itemView.findViewById(R.id.rb_rating_star_two);
        rbOneStar = itemView.findViewById(R.id.rb_rating_star_one);
    }
}

class CommentVH extends RecyclerView.ViewHolder {
    public ImageView ivAvt;
    public TextView tvName;
    public TextView tvDateTime;
    public RatingBar rbStarRating;
    public TextView tvComment;
    public TextView tvShopName;
    public TextView tvReply;
    public ConstraintLayout clReply;
    public CommentVH(@NonNull View itemView) {
        super(itemView);

        ivAvt = itemView.findViewById(R.id.iv_avt);
        tvName = itemView.findViewById(R.id.tv_name);
        tvDateTime = itemView.findViewById((R.id.tv_date));
        rbStarRating = itemView.findViewById(R.id.rb_star_rating_bar);
        tvComment = itemView.findViewById(R.id.tv_comment);
        tvShopName = itemView.findViewById(R.id.tv_shop_name);
        tvReply = itemView.findViewById(R.id.tv_reply);
        clReply = itemView.findViewById(R.id.cl_reply);
    }
}

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Comment> comments;
    Activity activity;
    private int view_type_filter=1;
    private int view_type_comment=0;

    public CommentAdapter(List<Comment> comments, Activity activity) {
        this.comments = comments;
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return view_type_filter;
        }
        return view_type_comment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == view_type_filter) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rating_star, parent,false);
            return new FilterVH(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent,false);
            return new CommentVH(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CommentVH) {
            Comment comment = comments.get(position);
            CommentVH commentVH = (CommentVH) holder;
            commentVH.ivAvt.setImageResource(comment.getAvt());
            commentVH.rbStarRating.setRating(comment.getRatingStar());
            commentVH.tvDateTime.setText(comment.getDateTime());
            commentVH.tvName.setText(comment.getName());
            commentVH.tvComment.setText(comment.getComment());
            if(comment.isClReplay()) {
                commentVH.clReply.setVisibility(View.VISIBLE);
            } else {
                commentVH.clReply.setVisibility(View.GONE);
            }
            commentVH.tvShopName.setText(comment.getShopName());
            commentVH.tvReply.setText(comment.getReply());
        } else if(holder instanceof FilterVH) {
            FilterVH filterVH = (FilterVH) holder;
            filterVH.rbFiveStar.setRating(5);
            filterVH.rbFourStar.setRating(4);
            filterVH.rbThreeStar.setRating(3);
            filterVH.rbTwoStar.setRating(2);
            filterVH.rbOneStar.setRating(1);
        }
    }

    @Override
    public int getItemCount() {
        if(comments!=null) {
            return comments.size();
        }
        return 0;
    }
}
