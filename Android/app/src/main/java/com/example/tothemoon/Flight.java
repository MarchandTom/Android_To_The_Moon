package com.example.tothemoon;


public class Flight {
    private String PlaceId;
    private String PlaceName;
    private String CountryId;
    private String RegionId;
    private String CityId;
    private String CountryName;
    private Integer MaxPrice;

    public Flight(){
    }

    public Flight(String PlaceId, String PlaceName, String CountryId, String RegionId, String CityId, String CountryName, Integer MaxPrice ) {
        this.PlaceId = PlaceId;
        this.PlaceName = PlaceName;
        this.CountryId = CountryId;
        this.RegionId = RegionId;
        this.CityId = CityId;
        this.CountryName = CountryName;
        this.MaxPrice = MaxPrice;
    }

    public String getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(String placeId) {
        this.PlaceId = placeId;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        this.PlaceName = placeName;
    }

    public String getCountryId() {
        return CountryId;
    }

    public void setCountryId(String countryId) {
        this.CountryId = countryId;
    }

    public String getRegionId() {
        return RegionId;
    }

    public void setRegionId(String regionId) {
        this.RegionId = regionId;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        this.CityId = cityId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        this.CountryName = countryName;
    }

    public Integer getMaxPrice() {
        return MaxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.MaxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "placeId='" + PlaceId + '\'' +
                ", placeName='" + PlaceName + '\'' +
                ", countryId='" + CountryId + '\'' +
                ", regionId='" + RegionId + '\'' +
                ", cityId='" + CityId + '\'' +
                ", countryName='" + CountryName + '\'' +
                ", maxPrice=" + MaxPrice +
                '}';
    }

    public String toJson() {
        return "{'placeId':'"+ PlaceId +"',"
                +"'placeName':'"+ PlaceName +"',"+
                "'countryId':'"+ CountryId +"',"+
                "'regionId':'"+ RegionId +"',"+
                "'cityId':'"+ CityId +"',"+
                "'countryName':'"+ CountryName +"',"+
                "'maxPrice':'"+ MaxPrice +"'}";

    }

}


