package com.example.matchup.adapter;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matchup.R;
import com.example.matchup.data.Datasource;
import com.example.matchup.model.Game;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView location;
        TextView host;
        TextView skill;
        TextView distance;
        ImageView img;
        Button join;

        public ItemViewHolder(View view) {
            super(view);
            this.title = view.findViewById(R.id.item_title);
            this.location = view.findViewById(R.id.item_location);
            this.host = view.findViewById(R.id.item_host);
            this.skill = view.findViewById(R.id.item_skill);
            this.distance = view.findViewById(R.id.item_distance);
            this.img = view.findViewById(R.id.item_image);
            this.join = view.findViewById(R.id.join);

            this.join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String joinedTxt = join.getText().toString();

                    if (joinedTxt.equals("JOINED")) {
                        join.setText("JOIN");
                        join.setBackgroundColor(Color.parseColor("#54CED6"));

                        String gameName = title.getText().toString();
                        ArrayList<Game> games = Datasource.allGamesList;
                        for (Game game: games) {
                            if (game.title.equals(gameName)) {
                                game.joined = false;
                            }
                        }
                    } else {
                        join.setText("JOINED");
                        join.setBackgroundColor(Color.GRAY);

                        String gameName = title.getText().toString();
                        ArrayList<Game> games = Datasource.allGamesList;
                        for (Game game : games) {
                            if (game.title.equals(gameName)) {
                                game.joined = true;
                            }
                        }
                    }
                }
            });
        }
    }

    public List<Game> dataset;
    public Context context;
    public ItemAdapter(List<Game> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Game item = dataset.get(position);
        holder.title.setText(item.title);
        holder.location.setText(item.location);
        holder.host.setText(item.host);
        holder.skill.setText(item.skillLevel);
        holder.distance.setText(String.valueOf(item.distance));

        if (item.joined) {
            holder.join.setText("JOINED");
            holder.join.setBackgroundColor(Color.GRAY);
        } else {
            holder.join.setText("JOIN");
            holder.join.setBackgroundColor(Color.parseColor("#54CED6"));
        }

        switch (item.type) {
            case "soccer":
                holder.img.setImageResource(R.drawable.soccer);
                break;
            case "basketball":
                holder.img.setImageResource(R.drawable.basketball);
                break;
            case "volleyball":
                holder.img.setImageResource(R.drawable.volleyball);
                break;
            default:
                holder.img.setImageResource(R.drawable.tennis);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
