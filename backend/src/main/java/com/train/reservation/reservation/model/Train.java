package com.train.reservation.reservation.model;

public class Train {
    String trainName;
    String trainNumber;
    DepartureTime departureTime;
    SeatsAvailable seatsAvailable;
    Price price;

    public int getDelayedBy() {
        return delayedBy;
    }

    public void setDelayedBy(int delayedBy) {
        this.delayedBy = delayedBy;
    }

    int delayedBy;

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    public SeatsAvailable getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(SeatsAvailable seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
