package dev.sadovnikov.testott;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ToursRvAdapter extends RecyclerView.Adapter<ToursRvAdapter.TourViewHolder> {
    private static final String TAG = "ToursRvAdapter";

    RvToursListener listener;
    ArrayList<Tour> tours;

    public ToursRvAdapter(ArrayList<Tour> tours, RvToursListener rvToursListener) {
        this.tours = tours;
        listener = rvToursListener;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tour_card, viewGroup,false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder tourViewHolder, int i) {
        tourViewHolder.tvNameOfHotel.setText("Отель " + "\"" + tours.get(i).getHotel().getName() + "\"");
        if (tours.get(i).getFlights().size() % 10 == 1){
            tourViewHolder.tvNumberOfFlights.setText(String.valueOf(tours.get(i).getFlights().size() + " вариант перелета"));
        } else {
            tourViewHolder.tvNumberOfFlights.setText(String.valueOf(tours.get(i).getFlights().size() + " варианта перелета"));
        }
        tourViewHolder.tvPrice.setText("от " + String.valueOf(tours.get(i).getChosenPrice()) + " р");
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {
        CardView cvTour;
        TextView tvNameOfHotel;
        TextView tvNumberOfFlights;
        TextView tvPrice;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Tour tour = tours.get(getLayoutPosition());
                    listener.onTourClick(tour);
                }
            });
            cvTour = itemView.findViewById(R.id.cv_tour);
            tvNameOfHotel = itemView.findViewById(R.id.tv_hotel_name);
            tvNumberOfFlights = itemView.findViewById(R.id.tv_number_of_flights);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }

    }

    interface RvToursListener {

        void onTourClick(Tour tour);
    }
}
