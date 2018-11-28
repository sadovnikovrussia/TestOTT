package dev.sadovnikov.testott;

import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

class HttpClient {
    private static final String TAG = "HttpClient";
    private static final String GET = "GET";

    private final JsonParser jsonParser;

    HttpClient() {
        jsonParser = new JsonParser();
    }

    ArrayList<Flight> readFlightsInfo() throws IOException, JSONException {
        Log.d(TAG, "readFlightsInfo: ");
        String requestFlightsUrl = "https://api.myjson.com/bins/zqxvw";

        URL url = new URL(requestFlightsUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.connect();

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream;
        BufferedReader bufferedReader;
        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        ArrayList<Flight> flights = jsonParser.getFlights(json);
        Log.d(TAG, "readFlightsInfo() returned: " + flights);

        return flights;
    }

    ArrayList<Hotel> readHotelsInfo() throws IOException, JSONException {
        Log.d(TAG, "readHotelsInfo: ");
        String requestHotelsUrl = "https://api.myjson.com/bins/12q3ws";

        URL url = new URL(requestHotelsUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.connect();

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream;
        BufferedReader bufferedReader;
        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        ArrayList<Hotel> hotels = jsonParser.getHotels(json);
        Log.d(TAG, "readHotelsInfo() returned: " + hotels);

        return hotels;
    }
    
    ArrayList<Company> readCompaniesInfo() throws IOException, JSONException {
        Log.d(TAG, "readCompaniesInfo: ");
        String requestHotelsUrl = "https://api.myjson.com/bins/8d024";

        URL url = new URL(requestHotelsUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.connect();

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream;
        BufferedReader bufferedReader;
        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        ArrayList<Company> companies = jsonParser.getCompanies(json);
        Log.d(TAG, "readCompaniesInfo() returned: " + companies);

        return companies;
    }

    ArrayList<Company> loadCompaniesById() throws IOException, JSONException {
        Log.d(TAG, "readCompaniesInfo: ");
        String requestHotelsUrl = "https://api.myjson.com/bins/8d024";

        URL url = new URL(requestHotelsUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.connect();

        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream;
        BufferedReader bufferedReader;
        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        String json = stringBuilder.toString();
        ArrayList<Company> companies = jsonParser.getCompanies(json);
        Log.d(TAG, "readCompaniesInfo() returned: " + companies);

        return companies;
    }

}
