package dev.sadovnikov.testott;

import java.util.ArrayList;

public class TourMaker {

    public static ArrayList<Tour> makeTours(ArrayList<Hotel> hotels, ArrayList<Flight> flights, ArrayList<Company> companies) {
        ArrayList<Tour> tours = new ArrayList<>();
        for (Hotel hotel : hotels) {
            ArrayList<Flight> flightArrayList = new ArrayList<>();
            for (Flight flight : flights){
                if (hotel.getFlightsIds().contains(flight.getId())){
                    flightArrayList.add(flight);
                }
            }
            tours.add(new Tour(hotel, flightArrayList));
        }
        return tours;
    }
}
