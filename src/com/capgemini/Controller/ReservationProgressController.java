package com.capgemini.Controller;

import com.capgemini.Model.Canoe;
import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.capgemini.Main.TEXT_RED;
import static com.capgemini.Main.TEXT_RESET;

public class ReservationProgressController {
    private Model model;

    public ReservationProgressController(Model model) {
        this.model = model;
    }

    public String costCalculating(String duration, String canoeId) {
        double price = 0;
        int intDuration = Integer.parseInt(duration.trim());
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeId().equals(canoeId)) {
                price = Double.parseDouble(canoe.getTripPrice().trim());
            }
        }
        double totalCost = intDuration * price / 30;
        return totalCost + "";
    }

    public String newIdForNewReservation() {
        int newIdForNewReservation = Integer.parseInt(model.getReservations().get(model.getReservations().size() - 1).getReservationId());
        return (newIdForNewReservation + 1) + "";

    }

    public String whichCanoeIsFree(String reservationDate, String canoeType, String startTime) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date stTime = parser.parse(startTime);
        Date endTime;
        List<Integer> rezervedCanoeId = new <Integer>ArrayList();
        for (Reservation reservation : model.getReservations()) {
            endTime = parser.parse(reservation.getEndTime());
            if (reservation.getDate().equals(reservationDate) &&
                    reservation.getCanoeType().equals(canoeType) &&
                    endTime.after(stTime)) { //datanin endtime, rezer baslangic saat sonra ise
                rezervedCanoeId.add(Integer.parseInt(reservation.getCanoeId()));
            }
        }

        Collections.sort(rezervedCanoeId);
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().trim().equals(canoeType.trim())) {
                if (rezervedCanoeId.size() == 0) {
                    return canoe.getCanoeId();
                }
                if (!rezervedCanoeId.contains(Integer.valueOf(canoe.getCanoeId()))) {
                    return canoe.getCanoeId();
                }
            }
        }
        return null;
    }

    public String defaultCanoeDuration(String canoeType) {
        String defaultCanoeDuration = "30";
        for (Canoe canoe : model.getCanoes()) {
            if (canoe.getCanoeType().equals(canoeType)) {
                return canoe.getTimeOfTheMinimumTrip().trim();
            }
        }
        return defaultCanoeDuration;
    }

    public int splitHourMinute(String hourOrMinute, String startTime) {
        int part = 0;
        if (startTime.contains(":")) {
            String[] parts = startTime.split(":");
            if (hourOrMinute.equals("H")) {
                part = Integer.parseInt(parts[0]);
            } else {
                part = Integer.parseInt(parts[1]);
            }
        }
        return part;
    }

    public String endTimeCalculating(String startTime, String duration) {
        int reservationHour = splitHourMinute("H", startTime);
        int reservationMinute = splitHourMinute("M", startTime);
        LocalTime lt = LocalTime.of(reservationHour, reservationMinute);
        lt = lt.plusMinutes(Long.parseLong(duration));
        return lt.toString();
    }

    public boolean dateChecking(String reservationDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = formatter.parse(reservationDate);
        }catch (ParseException pe){
            System.out.println(TEXT_RED +"Check your date format!!!" +TEXT_RESET);
            return false;
        }
       /* Date today = formatter.parse(LocalDate.now().toString());
        if(date.before(today)){
            System.out.println("today" + today);
            System.out.println("date" + date);
            return false;
        }*/
        return true;
    }
}
