package dev.sadovnikov.testott;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ToursRvAdapter.RvToursListener,
        ChoosePriceDialogFragment.ChoosePriceDialogFragmentListener {
    private static final String TAG = "MainActivity";

    RecyclerView rvTours;
    ProgressBar progressBar;

    ArrayList<Hotel> hotels;
    ArrayList<Flight> flights;
    ArrayList <Company> companies;
    ArrayList<Tour> tours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvTours = findViewById(R.id.rv_tours);
        rvTours.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        progressBar = findViewById(R.id.progressBar);
        loadTours();
    }


    @Override
    public void onTourClick(Tour tour) {
        Log.d(TAG, "loadCompanies onPostExecute() returned: " + companies);
        ChoosePriceDialogFragment dialogFragment = new ChoosePriceDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("tour", tour);
        bundle.putSerializable("companies", companies);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getSupportFragmentManager(), "tours");

    }

    @SuppressLint("StaticFieldLeak")
    private void loadTours() {
        progressBar.setVisibility(View.VISIBLE);
        new AsyncTask<Void, Void, ArrayList<Tour>>() {
            @Override
            protected ArrayList<Tour> doInBackground(Void... voids) {
                Log.d(TAG, "loadTour doInBackground: ");
                HttpClient httpClient = new HttpClient();
                try {
                    hotels = httpClient.readHotelsInfo();
                    flights = httpClient.readFlightsInfo();
                    companies = httpClient.readCompaniesInfo();
                    tours = TourMaker.makeTours(hotels, flights, companies);
                    return tours;
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(ArrayList<Tour> tours) {
                super.onPostExecute(tours);
                progressBar.setVisibility(View.GONE);
                rvTours.setAdapter(new ToursRvAdapter(tours, MainActivity.this));
                Log.d(TAG, "loadTours onPostExecute() returned: " + tours);
            }
        }.execute();
    }

}
