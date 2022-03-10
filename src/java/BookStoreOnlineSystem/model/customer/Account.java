package BookStoreOnlineSystem.model.customer;

public class Account {

    private int id;
    private String username;
    private String password;
    private int card;
    private int point;
    private String status;

    public Account() {
    }

    public Account(int id, String username, String password, int card, int point, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.card = card;
        this.point = point;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
