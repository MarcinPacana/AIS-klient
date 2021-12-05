package pl.marcin.aisklient.model;

public class Point {

    private double x;
    private double y;
    private String name;
    private String destinationName;
    private Double destinationX;
    private Double destinationY;
    private String shipType;
    private Integer mmsi;
    private String country;


    public Point(double x, double y, String name, String destinationName, String shipType, Integer mmsi, String country) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.destinationName = destinationName;
        this.shipType = shipType;
        this.mmsi = mmsi;
        this.country = country;
    }

    public Point(double x, double y, String name, String destinationName, Double destinationX, Double destinationY, String shipType) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.destinationName = destinationName;
        if (destinationX == null || destinationY == null) {
            this.destinationX = x;
            this.destinationY = y;
        } else {
            this.destinationX = destinationX;
            this.destinationY = destinationY;
        }
        this.shipType = shipType;
    }

    public int getMmsi() {
        return mmsi;
    }

    public void setMmsi(int mmsi) {
        this.mmsi = mmsi;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public double getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(Double destinationX) {
        if (destinationX == null) {
            this.destinationX = this.x;
        } else {
            this.destinationX = destinationX;
        }
    }

    public double getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(Double destinationY) {
        if (destinationY == null) {
            this.destinationY = this.y;
        } else {
            this.destinationY = destinationY;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
