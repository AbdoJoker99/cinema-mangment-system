package movie_ticket;

public class customer {
    private String userName;
    private String email;
    private String password;
    private float deposit;

    public customer(String userName, String email,  String password, float deposit) {
        this.userName = userName;

        this.email = email;
        this.password = password;
        this.deposit=deposit;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getDeposit() {
        return deposit;
    }
 
    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }
    
}
