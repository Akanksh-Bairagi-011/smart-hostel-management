package com.hostel;

import com.hostel.dao.RoomBookingDAO;
import com.hostel.dao.ComplaintDAO;
import com.hostel.dao.FeeDAO;

import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        RoomBookingDAO bookingDAO = new RoomBookingDAO();
        ComplaintDAO complaintDAO = new ComplaintDAO();
        FeeDAO feeDAO = new FeeDAO();

        // Example test data
        bookingDAO.allocateRoom(1, 101, Date.valueOf("2025-06-26"), Date.valueOf("2025-12-31"));
        complaintDAO.submitComplaint(1, "Water Issue", "No water in bathroom", "Open", Date.valueOf("2025-06-26"));
        feeDAO.getFeeRecord(1);
    }
}
