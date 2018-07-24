package com.example.android.sweetsquare.activities;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.sweetsquare.R;


/**
 * Created by Tanaskovic on 4/12/2018.
 */

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "sweety_name";
    public static final String EXTRA_DESCRIPTION = "sweety_description";
    public static final String EXTRA_IMAGE = "-1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final String name = intent.getStringExtra(EXTRA_NAME);
        final String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        final  int image = intent.getIntExtra(EXTRA_IMAGE,0 );

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(name);
        TextView textView = (TextView)findViewById(R.id.description);
        textView.setText(description);
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(image).into(imageView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }
    
}
