/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie_ticket;

import java.util.List;

/**
 *
 * @author fast
 */
public class Movies {
    private String name;
    private float seatPrice;
    private String date;

    public Movies(String name, float seatPrice, String date) {
        this.name = name;
        this.seatPrice = seatPrice;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public float getSeatPrice() {
        return seatPrice;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeatPrice(float seatPrice) {
        this.seatPrice = seatPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static void addMovie(List<Movies> movies, Movies movie) {
    movies.add(movie);
}
    public static void removeMovie(List<Movies> movies, Movies movie) {
    movies.remove(movie);
}

public static void deleteMovie(List<Movies> movies, int index) {
    movies.remove(index);
}


}
