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

    ArrayList<Hotel> hotels;
    ArrayList<Flight> flights;
    ArrayList<Company> companies;

    public ToursRvAdapter(ArrayList<Hotel> hotels, ArrayList<Flight> flights, ArrayList<Company> companies) {
        this.hotels = hotels;
        this.flights = flights;
        this.companies = companies;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tour_card, viewGroup,false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder tourViewHolder, int i) {
        tourViewHolder.tvNameOfHotel.setText(hotels.get(i).getName());
        tourViewHolder.tvNumberOfFlights.setText(hotels.get(i).getName());
        tourViewHolder.tvNameOfHotel.setText(hotels.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder {
        CardView cvTour;
        TextView tvNameOfHotel;
        TextView tvNumberOfFlights;
        TextView tvPrice;

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            cvTour = itemView.findViewById(R.id.cv_tour);
            tvNameOfHotel = itemView.findViewById(R.id.tv_hotel_name);
            tvNumberOfFlights = itemView.findViewById(R.id.tv_number_of_flights);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }

        void bind(){

        }
    }
}
