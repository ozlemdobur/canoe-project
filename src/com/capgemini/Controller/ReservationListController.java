package com.capgemini.Controller;

import com.capgemini.Model.Model;
import com.capgemini.Model.Reservation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReservationListController {
    private Model model;

    public ReservationListController(Model model) {
        this.model = model;
    }

    public void execute() throws IOException {
        model.getReservations().toString();
        System.out.print(String.format("%-10s","ID"));
        System.out.print(String.format("%-10s","ROOM"));
        System.out.print(String.format("%-12s","CANOE ID"));
        System.out.print(String.format("%-15s","CANOE TYPE"));
        System.out.print(String.format("%-15s","DATE"));
        System.out.print(String.format("%-10s","DURATION"));
        System.out.print(String.format("%-12s","START"));
        System.out.print(String.format("%-12s","END"));
        System.out.println(String.format("%-12s","COST"));
        for(Reservation reservation :model.getReservations()){
            System.out.print(String.format("%-10s",reservation.getReservationId()));
            System.out.print(String.format("%-10s",reservation.getRoomNumber()));
            System.out.print(String.format("%-12s",reservation.getCanoeId()));
            System.out.print(String.format("%-15s",reservation.getCanoeType()));
            System.out.print(String.format("%-15s",reservation.getDate()));
            System.out.print(String.format("%-10s",reservation.getDuration()));
            System.out.print(String.format("%-12s",reservation.getStartTime()));
            System.out.print(String.format("%-12s",reservation.getEndTime()));
            System.out.println(String.format("%-12s",reservation.getCost()));
        }
       /*         + '|' +"ROOM" + '|' +"CANOE TYPE"+ '|' + "CANOE ID"+ '|' + "DATE" + '|' +
                        "DURATION" + '|' + "START" + '|' + " END "+ '|' +" COST ");
        */// return "Reservation{"
/*                " " + reservationId.substring(0,4) + '|' +
                " " + roomNumber.substring(0,4) + '|' +
                " " + canoeType.substring(0,10) + '|' +
                " " + canoeId.substring(0,8) + '|' +
                " " + date.substring(0,10) + '|' +
                " " + duration.substring(0,8) + '|' +
                " " + startTime.substring(0,5) + '|' +
                " " + endTime.substring(0,5) + '|' +*/
      /*  System.out.print( String.format("%-10s",startTime));
        System.out.print( String.format("%-10s",endTime));*/
        //" " + endTime.substring(0,6) + '|';
    }
    /*    InputStream input = new BufferedInputStream(new FileInputStream("src/com/capgemini/Model/ReservationDB"));
        byte[] buffer = new byte[8192];
        List<Reservation> titleReservationList = new <Reservation> ArrayList();
        try {
            for (int length = 0; (length = input.read(buffer)) != -1; ) {
                System.out.write(buffer, 0, length);
            }
        } finally {
            input.close();
        }
    }*/
}
