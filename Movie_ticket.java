package movie_ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movie_ticket {

    private static List<Movies> movies = new ArrayList<>();

    // admin login
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password123";
    private static final String ADMIN_EMAIL = "admin@admin.com";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Movies movie1 = new Movies("The Matrix", 10.0f, "2023-05-15");
                Movies movie2 = new Movies("Star Wars: Episode IV - A New Hope", 12.0f, "2023-05-16");
                Movies movie3 = new Movies("The Godfather", 8.0f, "2023-05-17");
                Movies movie4 = new Movies("The Shawshank Redemption", 7.5f, "2023-05-18");
                Movies movie5 = new Movies("The Dark Knight", 9.0f, "2023-05-19");
                Movies movie6 = new Movies("The Lord of the Rings: The Fellowship of the Ring", 11.0f, "2023-05-20");
                Movies movie7 = new Movies("Forrest Gump", 8.5f, "2023-05-21");
                Movies movie8 = new Movies("The Silence of the Lambs", 7.0f, "2023-05-22");

                Movies.addMovie(movies, movie1);
                Movies.addMovie(movies, movie2);
                Movies.addMovie(movies, movie3);
                Movies.addMovie(movies, movie4);
                Movies.addMovie(movies, movie5);
                Movies.addMovie(movies, movie6);
                Movies.addMovie(movies, movie7);
                Movies.addMovie(movies, movie8);
        System.out.println("Welcome to the movie ticket system!");
        System.out.println("Do you want to log in like Admin or user?");
        System.out.println("1. Log in");
        int choice = input.nextInt();

        if (choice == 1) {

            System.out.println("Enter your username: ");
            String username = input.next();
            System.out.println("Enter your Email: ");
            String email = input.next();
            System.out.println("Enter your password: ");
            String password = input.next();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD) && email.equals(ADMIN_EMAIL)) {
                System.out.println("Welcome, admin!");
            System.out.println("What would you like to do?");
            System.out.println("1. Add a new movie");
            System.out.println("2. Remove a movie");
            System.out.println("3. Delete a movie");
            int adminChoice = input.nextInt();

            if (adminChoice == 1) {
                System.out.println("Enter the movie name: ");
                String movieName = input.next();
                System.out.println("Enter the seat price: ");
                float seatPrice = input.nextFloat();
                System.out.println("Enter the date (yyyy-mm-dd): ");
                String date = input.next();
                Movies movie = new Movies(movieName, seatPrice, date);
                Movies.addMovie(movies, movie);
                System.out.println("Movie added successfully!");
            } else if (adminChoice == 2) {
                String[] movieDetails = getMovieDetails();
                String movieName = movieDetails[0];
                float seatPrice = Float.parseFloat(movieDetails[1]);
                String movieDate = movieDetails[2];
                Movies movieToRemove = null;

                for (Movies movie : movies) {
                    if (movie.getName().equals(movieName) && movie.getSeatPrice() == seatPrice && movie.getDate().equals(movieDate)) {
                        movieToRemove = movie;
                        break;
                    }
                }

                if (movieToRemove != null) {
                    Movies.removeMovie(movies, movieToRemove);
                    System.out.println("Movie removed successfully!");
                } else {
                    System.out.println("Movie not found!");
                }
            } else if (adminChoice == 3) {
                String[] movieDetails = getMovieDetails();
                String movieName = movieDetails[0];
                float seatPrice = Float.parseFloat(movieDetails[1]);
                String movieDate = movieDetails[2];
                int movieIndex = -1;

                for (int i = 0; i < movies.size(); i++) {
                    Movies movie = movies.get(i);
                    if (movie.getName().equals(movieName) && movie.getSeatPrice() == seatPrice && movie.getDate().equals(movieDate)) {
                        movieIndex = i;
                        break;
                    }
                }

                if (movieIndex != -1) {
                    Movies.deleteMovie(movies, movieIndex);
                    System.out.println("Movie deleted successfully!");
                } else {
                    System.out.println("Movie not found!");
                }
            }
        } else {
                
                float deposit = 0.0f;
                customer c = new customer(username, email, password, deposit);
                c.setuserName(username);
                c.setPassword(password);
                c.setEmail(email);
                System.out.println("how many money you have ?");
                deposit = input.nextFloat();
                c.setDeposit(deposit);

                String[] movieDetails = getMovieDetails();
                String movieName = movieDetails[0];
                float seatPrice = Float.parseFloat(movieDetails[1]);
                String movieDate = movieDetails[2];
                System.out.println("Movie name: " + movieName);
                System.out.println("Seat price: $" + seatPrice);
                System.out.println("Date: " + movieDate);

                Seats seat = new Seats("B12");
                System.out.println("Welcome, " + username + "!");
                System.out.println("plz choose your seats");
                seat.reserveSeats();
                int seat_amount = seat.getSeatsCount();
                String payer_name = username;
                String payer_email = email;

                LocalDateTime currentDate = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String reservation_date = formatter.format(currentDate);

                String status = "paid";
                float tax = 0.1f;

                Payment pay = new Payment(seatPrice, seat_amount, payer_name, payer_email, movieDate, reservation_date, status, tax);
                String recipt = pay.generateReceipt(movieName, movieDate, reservation_date, seat_amount, seatPrice, tax, payer_name, payer_email, status, seat.seats_number, deposit);
                System.out.println(recipt);

                String receipt = ReceiptGUI.generateReceipt(movieName, movieDate, reservation_date, seat_amount, seatPrice, tax, payer_name, payer_email, status, seat.seats_number, deposit);
                ReceiptGUI receiptGUI = new ReceiptGUI(receipt);
            }
        } else {
            System.out.println("Invalid choice!");
        }

    }

    public static String[] getMovieDetails() {
        int i = 1;
        System.out.println("List of all movies:");
        for (Movies movie : movies) {
            System.out.println("******************************************");
            System.out.println(i + ": ");
            System.out.println("Movie name: " + movie.getName());
            System.out.println("Seat price: $" + movie.getSeatPrice());
            System.out.println("Date: " + movie.getDate());
            i++;
            System.out.println();
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the movie you want to choose:");
        int movieNumber = input.nextInt();

        if (movieNumber < 1 || movieNumber > movies.size()) {
            System.out.println("Invalid movie number!");
            return null;
        }

        Movies chosenMovie = movies.get(movieNumber - 1);
        String movieName = chosenMovie.getName();
        float seatPrice = chosenMovie.getSeatPrice();
        String movieDate = chosenMovie.getDate();

        String[] movieDetails = { movieName, String.valueOf(seatPrice), movieDate };
        return movieDetails;
    }
}