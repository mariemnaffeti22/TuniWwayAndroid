package com.example.tuniwwayandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private List<Tour> tourList;

    public TourAdapter(List<Tour> tourList) {
        this.tourList = tourList;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);
        holder.tvDestination.setText(tour.getDestination());
        holder.tvDate.setText("📅 " + tour.getDate());
        holder.tvPrix.setText(tour.getPrix() + " TND");
        holder.tvNomGuide.setText("👤 " + tour.getNomGuide());

        // Charger l'image


        holder.imgTour.setImageResource(tour.getImageRes());

        // Clic sur un item → remet le prix à 0
        holder.itemView.setOnClickListener(v -> {
            holder.tvPrix.setText("0.0 TND");
        });
    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        TextView tvDestination, tvDate, tvPrix, tvNomGuide;
        ImageView imgTour;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDestination = itemView.findViewById(R.id.tvDestination);
            tvDate        = itemView.findViewById(R.id.tvDate);
            tvPrix        = itemView.findViewById(R.id.tvPrix);
            tvNomGuide    = itemView.findViewById(R.id.tvNomGuide);
            imgTour       = itemView.findViewById(R.id.imgTour);
        }
    }
}