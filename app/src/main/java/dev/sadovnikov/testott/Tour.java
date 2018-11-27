package dev.sadovnikov.testott;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Tour {
    //long id;
    private Hotel hotel;
    private ArrayList<Flight> flights;


    Tour(Hotel hotel, ArrayList<Flight> flight) {
        this.hotel = hotel;
        this.flights = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    @NonNull
    @Override
    public String toString() {
        return "Tour{" +
                "hotel=" + hotel +
                ", flights=" + flights +
                '}';
    }
}
