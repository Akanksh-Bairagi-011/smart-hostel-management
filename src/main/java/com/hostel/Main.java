package com.hostel;

import com.hostel.dao.RoomBookingDAO;
import com.hostel.dao.ComplaintDAO;
import com.hostel.dao.FeeDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        //logger.info("Print");

        // Test booking a room
        RoomBookingDAO roomDao = new RoomBookingDAO();
        boolean roomBooked = roomDao.CheckIn(101, 1);
        System.out.println("Room booking success: " + roomBooked);

        // Test submitting a complaint
        ComplaintDAO complaintDao = new ComplaintDAO();
        System.out.println("Complaint Start: " );
        boolean complaintSubmitted = complaintDao.fileComplaint(
                101,
                "Plumbing",
                "The bathroom tap is leaking constantly."
        );
        System.out.println("Complaint submission success: " + complaintSubmitted);
//
////        // Test fee record query
        FeeDAO feeDao = new FeeDAO();
        System.out.println("Fee record for student ID 101:");
        feeDao.getFeeStatus(101);
    }
}
