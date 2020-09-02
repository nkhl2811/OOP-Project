package model;

public class User {
    public User(String userName, String password, String walletBalance, String phoneNumber, String email,String status) {
        this.userName = userName;
        this.password = password;
        this.walletBalance = walletBalance;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
    }

    String userName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String status;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String password;
    String walletBalance;
    String phoneNumber;
    String email;
}
