package com.capgemini.Model;

public class Canoe {
    private String canoeId;
    private String canoeType;
    private String numberOfTheSeats;
    private String timeOfTheMinimumTrip;
    private String tripPrice;

    public Canoe(String canoeId, String canoeType, String numberOfTheSeats, String timeOfTheMinimumTrip, String tripPrice) {
        this.canoeId = canoeId;
        this.canoeType = canoeType;
        this.numberOfTheSeats = numberOfTheSeats;
        this.timeOfTheMinimumTrip = timeOfTheMinimumTrip;
        this.tripPrice = tripPrice;
    }

    @Override
    public String toString() {
        return "Canoe{" +
                "canoeId='" + canoeId + '\'' +
                ", canoeType='" + canoeType + '\'' +
                ", numberOfTheSeats='" + numberOfTheSeats + '\'' +
                ", timeOfTheMinimumTrip='" + timeOfTheMinimumTrip + '\'' +
                ", tripPrice='" + tripPrice + '\'' +
                '}';
    }

    public String getCanoeId() {
        return canoeId;
    }
    public void setCanoeId(String canoeId) {
        this.canoeId = canoeId;
    }
    public String getCanoeType() {
        return canoeType;
    }
    public void setCanoeType(String canoeType) {
        this.canoeType = canoeType;
    }
    public String getNumberOfTheSeats() {
        return numberOfTheSeats;
    }
    public void setNumberOfTheSeats(String numberOfTheSeats) {
        this.numberOfTheSeats = numberOfTheSeats;
    }
    public String getTimeOfTheMinimumTrip() {
        return timeOfTheMinimumTrip;
    }
    public void setTimeOfTheMinimumTrip(String timeOfTheMinimumTrip) {
        this.timeOfTheMinimumTrip = timeOfTheMinimumTrip;
    }
    public String getTripPrice() {
        return tripPrice;
    }
    public void setTripPrice(String tripPrice) {
        this.tripPrice = tripPrice;
    }
}