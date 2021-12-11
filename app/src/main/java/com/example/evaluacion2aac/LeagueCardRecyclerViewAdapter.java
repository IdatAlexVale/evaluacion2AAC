package com.example.evaluacion2aac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacion2aac.network.ImageRequester;
import com.example.evaluacion2aac.network.LeagueEntry;

import java.util.List;

public class LeagueCardRecyclerViewAdapter extends RecyclerView.Adapter<LeagueCardViewHolder> {
    private List<LeagueEntry> leagueList;
    private ImageRequester imageRequester;

    LeagueCardRecyclerViewAdapte(List<LeagueEntry> leagueList){
        this.leagueList = leagueList;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public LeagueCardViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.league_card, parent, false);
        return new LeagueCardViewHolder(layoutView);
    }

    @Override
    public  void onBindViewHolder(@NonNull LeagueCardViewHolder holder, int position){
        if (leagueList != null & position < leagueList.size()){
            LeagueEntry league = leagueList.get(position);
            holder.leagueTitle.setText(league.title);
            holder.leaguePrice.setText(league.price);
            imageRequester.setImageFromUrl(holder.leagueImage, league.url);
        }
    }
    @Override
    public int getItemCount(){
        return leagueList.size();
    }
}
