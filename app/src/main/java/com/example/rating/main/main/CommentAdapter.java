package com.example.rating.main.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rating.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> comments;
    private ItemClickListener itemClickListener;

    public CommentAdapter(List<Comment> comments, ItemClickListener itemClickListener) {
        this.comments = comments;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 1;
        }
        return 2;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rating_star, parent,false);
            return new CommentViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent,false);
            return new CommentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);
        if (comment==null) {
        } else {
            holder.ivAvt.setImageResource(comment.getAvt());
            holder.rbStarRating.setRating(comment.getRatingStar());
            holder.tvDateTime.setText(comment.getDateTime());
            holder.tvName.setText(comment.getName());
            holder.tvComment.setText(comment.getComment());
        }

    }

    @Override
    public int getItemCount() {
        if(comments!=null) {
            return comments.size();
        }
        return 0;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAvt;
        private TextView tvName;
        private TextView tvDateTime;
        private RatingBar rbStarRating;
        private TextView tvComment;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAvt = itemView.findViewById(R.id.iv_avt);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDateTime = itemView.findViewById((R.id.tv_date));
            rbStarRating = itemView.findViewById(R.id.rb_star_rating_bar);
            tvComment = itemView.findViewById(R.id.tv_comment);
        }
    }

    public  interface  ItemClickListener {
        void getData(Comment comment);
    }
}
