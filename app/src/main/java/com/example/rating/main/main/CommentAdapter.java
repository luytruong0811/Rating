package com.example.rating.main.main;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public ConstraintLayout clAll, clComment, clMedia, clOneStar, clTwoStar, clThreeStar, clFourStar, clFiveStar;
    public TextView tvAmountAll, tvAll, tvAmountComment, tvComment, tvAmountMedia, tvMedia, tvAmountOneStar,tvAmountTwoStar, tvAmountThreeStar, tvAmountFourStar, tvAmountFiveStar ;
    public FilterVH(@NonNull View itemView) {
        super(itemView);
        rbFiveStar = itemView.findViewById(R.id.rb_rating_star_five);
        rbFourStar = itemView.findViewById(R.id.rb_rating_star_four);
        rbThreeStar = itemView.findViewById(R.id.rb_rating_star_three);
        rbTwoStar = itemView.findViewById(R.id.rb_rating_star_two);
        rbOneStar = itemView.findViewById(R.id.rb_rating_star_one);
        clAll = itemView.findViewById(R.id.cl_all);
        tvAmountAll = itemView.findViewById(R.id.tv_all_amount);
        tvAll = itemView.findViewById(R.id.tv_all);
        clComment = itemView.findViewById(R.id.cl_comment);
        tvAmountComment = itemView.findViewById(R.id.tv_comment_amount);
        tvComment = itemView.findViewById(R.id.tv_comment);
        clMedia = itemView.findViewById(R.id.cl_media);
        tvAmountMedia = itemView.findViewById(R.id.tv_media_amount);
        tvMedia = itemView.findViewById(R.id.tv_media);
        clOneStar = itemView.findViewById(R.id.one_star);
        clTwoStar = itemView.findViewById(R.id.two_star);
        clThreeStar = itemView.findViewById(R.id.three_star);
        clFourStar = itemView.findViewById(R.id.four_star);
        clFiveStar = itemView.findViewById(R.id.five_star);
        tvAmountOneStar = itemView.findViewById(R.id.tv_one_star_amount);
        tvAmountTwoStar = itemView.findViewById(R.id.tv_two_star_amount);
        tvAmountThreeStar = itemView.findViewById(R.id.tv_three_star_amount);
        tvAmountFourStar = itemView.findViewById(R.id.tv_four_star_amount);
        tvAmountFiveStar = itemView.findViewById(R.id.tv_five_star_amount);
    }
}

class CommentVH extends RecyclerView.ViewHolder {
    public ImageView ivAvt;
    public TextView tvName;
    public TextView tvDateTime;
    public RatingBar rbStarRating;
    public LinearLayout lnImage;
    public ImageView ivImage1;
    public ImageView ivImage2;
    public ImageView ivImage3;
    public ImageView ivImage4;
    public ImageView ivImage5;
    public TextView tvComment;
    public TextView tvSeeMore;
    public TextView tvShopName;
    public TextView tvReply;
    public ConstraintLayout clReply;
    public CommentVH(@NonNull View itemView) {
        super(itemView);

        ivAvt = itemView.findViewById(R.id.iv_avt);
        tvName = itemView.findViewById(R.id.tv_name);
        tvDateTime = itemView.findViewById((R.id.tv_date));
        rbStarRating = itemView.findViewById(R.id.rb_star_rating_bar);
        lnImage = itemView.findViewById(R.id.ln_image);
        ivImage1 = itemView.findViewById(R.id.iv_image1);
        ivImage2 = itemView.findViewById(R.id.iv_image2);
        ivImage3 = itemView.findViewById(R.id.iv_image3);
        ivImage4 = itemView.findViewById(R.id.iv_image4);
        ivImage5 = itemView.findViewById(R.id.iv_image5);
        tvComment = itemView.findViewById(R.id.tv_comment);
        tvSeeMore = itemView.findViewById(R.id.tv_see_more);
        tvShopName = itemView.findViewById(R.id.tv_shop_name);
        tvReply = itemView.findViewById(R.id.tv_reply);
        clReply = itemView.findViewById(R.id.cl_reply);
    }
}

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Comment> comments;
    Activity activity;
    private final int view_type_filter = 1;
    private final int view_type_comment = 0;

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
            if(comment.isLnImage()) {
                commentVH.lnImage.setVisibility(View.VISIBLE);
            } else {
                commentVH.lnImage.setVisibility(View.GONE);
            }
            commentVH.ivImage1.setImageResource(comment.getImage1());
            commentVH.ivImage2.setImageResource(comment.getImage2());
            commentVH.ivImage3.setImageResource(comment.getImage3());
            commentVH.ivImage4.setImageResource(comment.getImage4());
            commentVH.ivImage5.setImageResource(comment.getImage5());
            if(comment.isSeeMore()) {
                SpannableString content = new SpannableString("See more");
                content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
                commentVH.tvSeeMore.setText(content);
                commentVH.tvSeeMore.setVisibility(View.VISIBLE);
            } else {
                commentVH.tvSeeMore.setVisibility(View.GONE);
            }
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

            filterVH.clAll.setOnClickListener(v -> {
                filterVH.clAll.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAll.setTextColor(Color.WHITE);
                filterVH.tvAmountAll.setTextColor(Color.WHITE);

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clComment.setOnClickListener(v -> {
                filterVH.clComment.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvComment.setTextColor(Color.WHITE);
                filterVH.tvAmountComment.setTextColor(Color.WHITE);

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clMedia.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvMedia.setTextColor(Color.WHITE);
                filterVH.tvAmountMedia.setTextColor(Color.WHITE);

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clOneStar.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAmountOneStar.setTextColor(Color.WHITE);

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clTwoStar.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAmountTwoStar.setTextColor(Color.WHITE);

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clThreeStar.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAmountThreeStar.setTextColor(Color.WHITE);

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clFourStar.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAmountFourStar.setTextColor(Color.WHITE);

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFiveStar.setTextColor(Color.parseColor("#000000"));
            });

            filterVH.clFiveStar.setOnClickListener(v -> {
                filterVH.clMedia.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvMedia.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountMedia.setTextColor(Color.parseColor("#000000"));

                filterVH.clAll.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAll.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountAll.setTextColor(Color.parseColor("#000000"));

                filterVH.clComment.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvComment.setTextColor(Color.parseColor("#000000"));
                filterVH.tvAmountComment.setTextColor(Color.parseColor("#000000"));

                filterVH.clFiveStar.setBackgroundResource(R.drawable.custom_selected);
                filterVH.tvAmountFiveStar.setTextColor(Color.WHITE);

                filterVH.clTwoStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountTwoStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clThreeStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountThreeStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clFourStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountFourStar.setTextColor(Color.parseColor("#000000"));

                filterVH.clOneStar.setBackgroundResource(R.drawable.custom_category);
                filterVH.tvAmountOneStar.setTextColor(Color.parseColor("#000000"));
            });

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
