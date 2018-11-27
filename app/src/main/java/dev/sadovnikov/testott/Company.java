package dev.sadovnikov.testott;

import android.support.annotation.NonNull;

public class Company {
    long id;
    String name;

    Company(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
