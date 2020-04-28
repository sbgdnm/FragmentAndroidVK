package com.example.vkfragmentlike;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private static final String TAG = "RecycleViewAdapter";

    private ArrayList<String> avatars;
    private ArrayList<String> names;
    private ArrayList<String> images;
    private ArrayList<String> descriptions;
    private ArrayList<Boolean> liked;
    private Context context;

    public RecycleViewAdapter(Context context) {
        this.context = context;
    }

    {
        avatars = MainActivity.avatars;
        names = MainActivity.names;
        images = MainActivity.images;
        descriptions = MainActivity.descriptions;
        liked = MainActivity.liked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");

        Glide.with(context)
                .asBitmap()
                .load(avatars.get(position))
                .into(holder.avatar);

        holder.name.setText(names.get(position));

        Glide.with(context)
                .asBitmap()
                .load(images.get(position))
                .into(holder.image);

        if(liked.get(position)){
            holder.like.setImageResource(R.drawable.likepngheart);
        }else{
            holder.like.setImageResource(R.drawable.heartpng);
        }

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: like");

                if(liked.get(position) == false){
                    holder.like.setImageResource(R.drawable.likepngheart);
                    Toast.makeText(v.getContext(), "Liked!", Toast.LENGTH_SHORT).show();
                    liked.set(position, true);
                    MainActivity.liked.set(position, true);
                }else{
                    holder.like.setImageResource(R.drawable.heartpng);
                    Toast.makeText(v.getContext(), "Unliked!", Toast.LENGTH_SHORT).show();
                    liked.set(position, false);
                    MainActivity.liked.set(position, false);
                }
            }
        });


        holder.description.setText(descriptions.get(position));

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: layout");

                Intent intent = new Intent(v.getContext(), DescriptionActivity.class);
                intent.putExtra("avatar", avatars.get(position));
                intent.putExtra("name", names.get(position));
                intent.putExtra("image", images.get(position));
                intent.putExtra("description", descriptions.get(position));
                intent.putExtra("liked", liked.get(position));
                intent.putExtra("position", position);

                context.startActivity(intent);
            }
        });
    }

    public void checkData(){
        avatars = MainActivity.avatars;
        names = MainActivity.names;
        images = MainActivity.images;
        descriptions = MainActivity.descriptions;
        liked = MainActivity.liked;
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView avatar;
        TextView name;
        ImageView image;
        ImageView like;

        TextView description;

        LinearLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            like = itemView.findViewById(R.id.like);
            description = itemView.findViewById(R.id.description);
            parent_layout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
