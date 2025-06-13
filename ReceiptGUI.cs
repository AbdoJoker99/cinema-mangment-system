/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movie_ticket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class ReceiptGUI {

    private JFrame frame;
    private JPanel panel;
    private JTextArea receiptTextArea;

    public ReceiptGUI(String receipt) {
        frame = new JFrame("Receipt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        receiptTextArea = new JTextArea();
        receiptTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        receiptTextArea.setEditable(false);
        receiptTextArea.setText(receipt);

        JScrollPane scrollPane = new JScrollPane(receiptTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));

        panel.add(scrollPane, BorderLayout.CENTER);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static String generateReceipt(String movie_name ,String film_date, String reservation_date, int seat_amount, float seat_price, float tax, String payer_name, String payer_email, String status, String seats, float deposit) {
    
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
