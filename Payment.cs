package movie_ticket;

public class Payment {
    
    private float seat_price;
    private int seat_amount;
    private String payer_name;
    private String payer_email;
    private String film_date;
    private String reservation_date;
    private String status;
    private float tax;

    public Payment(float seat_price, int seat_amount, String payer_name, String payer_email, String film_date, String reservation_date, String status, float tax) {
        this.seat_price = seat_price;
        this.seat_amount = seat_amount;
        this.payer_name = payer_name;
        this.payer_email = payer_email;
        this.film_date = film_date;
        this.reservation_date = reservation_date;
        this.status = status;
        this.tax = tax;
    }

    // Getters
    public float getSeatPrice() {
        return seat_price;
    }

    public int getSeatAmount() {
        return seat_amount;
    }

    public String getPayerName() {
        return payer_name;
    }

    public String getPayerEmail() {
        return payer_email;
    }

    public String getFilmDate(String film_date1) {
        return film_date;
    }

    public String getReservationDate() {
        return reservation_date;
    }

    public String getStatus() {
        return status;
    }

    public float getTax() {
        return tax;
    }

    // Setters
    public void setSeatPrice(float seat_price) {
        this.seat_price = seat_price;
    }

    public void setSeatAmount(int seat_amount) {
        this.seat_amount = seat_amount;
    }

    public void setPayerName(String payer_name) {
        this.payer_name = payer_name;
    }

    public void setPayerEmail(String payer_email) {
        this.payer_email = payer_email;
    }

    public void setFilmDate(String film_date) {
        this.film_date = film_date;
    }

    public void setReservationDate(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public String generateReceipt(String movie_name ,String film_date, String reservation_date, int seat_amount, float seat_price, float tax, String payer_name, String payer_email, String status, String seats, float deposit) {
    
    float subtotal = seat_price * seat_amount;
    float total_tax = tax * subtotal;
    float total = subtotal + total_tax;
    if(total > deposit)
    {
        return "you don't have enough money";
    }
    else{
    StringBuilder receiptBuilder = new StringBuilder();
    receiptBuilder.append("============================================\n");
    receiptBuilder.append("            MOVIE TICKET RECEIPT\n");
    receiptBuilder.append("============================================\n");
    
    receiptBuilder.append("Cinema: Our movie SoftWare\n");
    receiptBuilder.append("Movie: ").append(movie_name).append("\n");
    receiptBuilder.append("Film Date: ").append(film_date).append("\n");
    receiptBuilder.append("Reservation Date: ").append(reservation_date).append("\n");
    receiptBuilder.append("Number of Tickets: ").append(seat_amount).append("\n");
    receiptBuilder.append("Seat Numbers: ").append(seats).append("\n");
    receiptBuilder.append("--------------------------------------------\n");
    
    receiptBuilder.append("Seat Price: $").append(seat_price).append("\n");
    receiptBuilder.append("Subtotal: $").append(subtotal).append("\n");
    receiptBuilder.append("Tax: $").append(tax).append("\n");
    receiptBuilder.append("Total: $").append(total).append("\n");
    receiptBuilder.append("--------------------------------------------\n");
    
    receiptBuilder.append("Payer Name: ").append(payer_name).append("\n");
    receiptBuilder.append("Payer Email: ").append(payer_email).append("\n");
    receiptBuilder.append("Status: ").append(status).append("\n");

    return receiptBuilder.toString();
}
    }
    
}