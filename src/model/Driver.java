package model;

public class Driver {
    int driver_id;
    int numRatings;
    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_phno() {
        return driver_phno;
    }

    public void setDriver_phno(String driver_phno) {
        this.driver_phno = driver_phno;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    String driver_name;
    String driver_phno;
    String rating;
    String position;
    String availability;
    public Driver(int driver_id,String driver_name,String driver_phno,String rating,String position,String availability,int numRatings)
    {
        this.driver_id = driver_id;
        this.availability = availability;
        this.driver_name = driver_name;
        this.driver_phno = driver_phno;
        this.position = position;
        this.rating = rating;
        this.numRatings = numRatings;
    }
}
