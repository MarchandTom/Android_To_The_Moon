package com.example.tothemoon;


public class Flight {
    private String country;
    private String capitalCity;
    private String departureDate;
    private double price;

    public Flight(String country, String capitalCity, String departureDate, double price) {
        this.country = country;
        this.capitalCity = capitalCity;
        this.departureDate = departureDate;
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "country='" + country + '\'' +
                ", capitalCity='" + capitalCity + '\'' +
                ", departureDate=" + departureDate +
                ", price=" + price +
                '}';
    }
}


