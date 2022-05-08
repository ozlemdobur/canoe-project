package com.capgemini.Model;

public class Reservation {
    private String reservationId;
    private String roomNumber;
    private String canoeType;
    private String canoeId;
    private String date;
    private String duration;
    private String startTime;
    private String endTime;
    public Reservation() {
    }

    public Reservation(String reservationId, String roomNumber, String canoeType, String canoeId, String date, String duration,String startTime, String endTime) {
        this.reservationId = reservationId;
        this.roomNumber = roomNumber;
        this.canoeType = canoeType;
        this.canoeId = canoeId;
        this.date = date;
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", canoeType='" + canoeType + '\'' +
                ", canoeId='" + canoeId + '\'' +
                ", date='" + date + '\'' +
                ", duration='" + duration + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getCanoeType() {
        return canoeType;
    }

    public void setCanoeType(String canoeType) {
        this.canoeType = canoeType;
    }

    public String getCanoeId() {
        return canoeId;
    }

    public void setCanoeId(String canoeId) {
        this.canoeId = canoeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
