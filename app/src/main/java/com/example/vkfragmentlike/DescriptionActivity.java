package com.example.vkfragmentlike;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DescriptionActivity extends AppCompatActivity {

    private CircleImageView avatarView;
    private TextView nameView;
    private ImageView imageView;
    private ImageView likeView;
    private TextView descriptionView;
    private boolean liked;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();

        String avatar = intent.getStringExtra("avatar");
        final String name = intent.getStringExtra("name");
        String image = intent.getStringExtra("image");
        String view = intent.getStringExtra("view");
        String description = intent.getStringExtra("description");
        liked = intent.getBooleanExtra("liked", false);
        position = intent.getIntExtra("position", 0);

        avatarView = findViewById(R.id.detAva);
        nameView = findViewById(R.id.detName);
        imageView = findViewById(R.id.detailedImage);
        descriptionView = findViewById(R.id.detDescription);
        likeView = findViewById(R.id.detailedLike);

        Glide.with(this)
                .asBitmap()
                .load(avatar)
                .into(avatarView);

        nameView.setText(name);

        if(liked){
            likeView.setImageResource(R.drawable.likepngheart);
            liked = true;
        }else{
            likeView.setImageResource(R.drawable.heartpng);
            liked = false;
        }

        likeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liked == false){
                    likeView.setImageResource(R.drawable.likepngheart);
                    Toast.makeText(v.getContext(), "Liked!", Toast.LENGTH_SHORT).show();
                    liked = true;
                    MainActivity.liked.set(MainActivity.names.indexOf(name), true);
                }else{
                    likeView.setImageResource(R.drawable.heartpng);
                    Toast.makeText(v.getContext(), "Unliked!", Toast.LENGTH_SHORT).show();
                    liked = false;
                    MainActivity.liked.set(MainActivity.names.indexOf(name), false);
                }
            }
        });

        Glide.with(this)
                .asBitmap()
                .load(image)
                .into(imageView);

        descriptionView.setText(description);
    }
}
