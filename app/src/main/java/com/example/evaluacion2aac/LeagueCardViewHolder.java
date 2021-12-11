package com.example.evaluacion2aac;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;

public class LeagueCardViewHolder extends RecyclerView.ViewHolder{
    public NetworkImageView leagueImage;
    public TextView leagueTitle;
    public TextView leaguePrice;

    public LeagueCardViewHolder(@NonNull View itemView){
        super(itemView);
        leagueImage = itemView.findViewById(R.id.league_image);
        leagueTitle = itemView.findViewById(R.id.league_title);
        leaguePrice = itemView.findViewById(R.id.league_price);
    }
}
