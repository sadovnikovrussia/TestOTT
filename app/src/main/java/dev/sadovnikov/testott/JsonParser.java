package dev.sadovnikov.testott;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

class JsonParser {
    private static final String TAG = "JsonParser";

    ArrayList<Flight> getFlights(String response) throws JSONException {
        JSONArray flightsJsonArray = new JSONObject(response).getJSONArray("flights");
        ArrayList<Flight> flights = new ArrayList<>();
        for (int i = 0; i < flightsJsonArray.length(); i++) {
            JSONObject flightJson = (JSONObject) flightsJsonArray.get(i);
            long id = flightJson.getLong("id");
            long companyId = flightJson.getLong("companyId");
            String departure = flightJson.getString("departure");
            String arrival = flightJson.getString("arrival");
            long price = flightJson.getLong("price");
            flights.add(new Flight(id, companyId, departure, arrival, price));
        }
        return flights;
    }

    ArrayList<Hotel> getHotels(String response) throws JSONException {
        JSONArray hotelsJsonArray = new JSONObject(response).getJSONArray("hotels");
        ArrayList<Hotel> hotels = new ArrayList<>();
        for (int i = 0; i < hotelsJsonArray.length(); i++) {
            JSONObject hotelJson = (JSONObject) hotelsJsonArray.get(i);
            long id = hotelJson.getLong("id");
            JSONArray flightsIdsArray = hotelJson.getJSONArray("flights");
            ArrayList<Long> flightsId = new ArrayList<>();
            for (int j = 0; j < flightsIdsArray.length(); j++) {
                flightsId.add((long) flightsIdsArray.getInt(j));
            }
            String name = hotelJson.getString("name");
            long price = hotelJson.getLong("price");
            hotels.add(new Hotel(id, flightsId, name, price));
        }
        return hotels;
    }

    ArrayList<Company> getCompanies(String response) throws JSONException {
        JSONArray companiesJsonArray = new JSONObject(response).getJSONArray("companies");
        ArrayList<Company> companies = new ArrayList<>();
        for (int i = 0; i < companiesJsonArray.length(); i++) {
            JSONObject companyJson = (JSONObject) companiesJsonArray.get(i);
            long id = companyJson.getLong("id");
            String name = companyJson.getString("name");
            companies.add(new Company(id, name));
        }
        return companies;
    }
}
