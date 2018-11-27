package dev.sadovnikov.testott;

import android.support.annotation.NonNull;

public class Flight {
    private long id;
    private long companyId;
    private String departure;
    private String arrival;
    private long price;

    Flight(long id, long companyId, String departure, String arrival, long price) {
        this.id = id;
        this.companyId = companyId;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public long getPrice() {
        return price;
    }

    @NonNull
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", price=" + price +
                '}';
    }
}
