package dev.sadovnikov.testott;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RecyclerView rvTours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTours = findViewById(R.id.rv_tours);
        rvTours.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        loadTours();
//        loadFlights();
//        loadHotels();
//        loadCompanies();
    }

    @SuppressLint("StaticFieldLeak")
    private void loadTours() {
        new AsyncTask<Void, Void, ArrayList<Tour>>() {
            @Override
            protected ArrayList<Tour> doInBackground(Void... voids) {
                Log.d(TAG, "loadTour doInBackground: ");
                HttpClient httpClient = new HttpClient();
                try {
                    ArrayList<Hotel> hotels = httpClient.readHotelsInfo();
                    ArrayList<Flight> flights = httpClient.readFlightsInfo();
                    ArrayList <Company> companies = httpClient.readCompaniesInfo();
                    ArrayList<Tour> tours = TourMaker.makeTours(hotels, flights);
                    Log.d(TAG, "doInBackground: tours = " + tours);
                    return tours;
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Tour> tours) {
                super.onPostExecute(tours);
                Log.d(TAG, "loadTours onPostExecute() returned: " + tours);
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void loadFlights() {
        new AsyncTask<Void, Void, ArrayList<Flight>>() {
            @Override
            protected ArrayList<Flight> doInBackground(Void... voids) {
                Log.d(TAG, "loadFlights doInBackground: ");
                HttpClient httpClient = new HttpClient();
                try {
                    return httpClient.readFlightsInfo();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Flight> flights) {
                super.onPostExecute(flights);
                Log.d(TAG, "loadFlights onPostExecute() returned: " + flights);
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void loadHotels() {
        new AsyncTask<Void, Void, ArrayList<Hotel>>() {
            @Override
            protected ArrayList<Hotel> doInBackground(Void... voids) {
                Log.d(TAG, "loadHotels doInBackground: ");
                HttpClient httpClient = new HttpClient();
                try {
                    return httpClient.readHotelsInfo();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Hotel> hotels) {
                super.onPostExecute(hotels);
                Log.d(TAG, "loadHotels onPostExecute() returned: " + hotels);
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void loadCompanies() {
        new AsyncTask<Void, Void, ArrayList<Company>>() {
            @Override
            protected ArrayList<Company> doInBackground(Void... voids) {
                Log.d(TAG, "loadCompanies doInBackground: ");
                HttpClient httpClient = new HttpClient();
                try {
                    return httpClient.readCompaniesInfo();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Company> companies) {
                super.onPostExecute(companies);
                Log.d(TAG, "loadCompanies onPostExecute() returned: " + companies);
            }
        }.execute();
    }


}
