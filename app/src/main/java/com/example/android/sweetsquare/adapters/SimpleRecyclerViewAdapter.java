package com.example.android.sweetsquare.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.sweetsquare.R;
import com.example.android.sweetsquare.activities.DetailActivity;
import com.example.android.sweetsquare.model.Item;


import java.util.List;

import static android.media.CamcorderProfile.get;


/**
 * Created by Tanaskovic on 4/13/2018.
 */

public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<SimpleRecyclerViewAdapter.ViewHolder> {

    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private List<Item> mValues;



    public static class ViewHolder extends RecyclerView.ViewHolder {
        public String mBoundString;
        public String mBoundDescription;
        public int mBoundImage;

        public final View mView;
        public final ImageView mImageView;
        public final TextView mTextView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.avatar);
            mTextView = (TextView) view.findViewById(android.R.id.text1);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }

    public SimpleRecyclerViewAdapter(Context context, List<Item> items) {
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, mTypedValue, true);
        mBackground = mTypedValue.resourceId;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mBoundString = mValues.get(position).getName();
        holder.mBoundDescription= mValues.get(position).getDescription();
        holder.mBoundImage=  mValues.get(position).getImage();
        holder.mTextView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_NAME, holder.mBoundString);
                intent.putExtra(DetailActivity.EXTRA_DESCRIPTION, holder.mBoundDescription);

                intent.putExtra(DetailActivity.EXTRA_IMAGE, holder.mBoundImage);
                context.startActivity(intent);
            }
        });

       Glide.with(holder.mImageView.getContext())
             .load(mValues.get(position).getImage()) //imageURL
             .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}


