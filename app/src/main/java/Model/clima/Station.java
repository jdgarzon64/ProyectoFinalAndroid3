package Model.clima;

public class Station {
    private String brand;
    private String country;
    private String created;
    private String createdLocale;
    private double latitude;
    private String location;
    private double longitude;
    private String model;
    private String name;
    private String state;
    private String station;
    private String timezone;

    public Station(String brand, String country, String created, String createdLocale, double latitude, String location, double longitude, String model, String name, String state, String station, String timezone) {
        this.brand = brand;
        this.country = country;
        this.created = created;
        this.createdLocale = createdLocale;
        this.latitude = latitude;
        this.location = location;
        this.longitude = longitude;
        this.model = model;
        this.name = name;
        this.state = state;
        this.station = station;
        this.timezone = timezone;
    }

    public Station() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String value) {
        this.brand = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String value) {
        this.created = value;
    }

    public String getCreatedLocale() {
        return createdLocale;
    }

    public void setCreatedLocale(String value) {
        this.createdLocale = value;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double value) {
        this.latitude = value;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String value) {
        this.location = value;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double value) {
        this.longitude = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String value) {
        this.state = value;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String value) {
        this.station = value;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String value) {
        this.timezone = value;
    }
}
