package com.hostel.dao;

import com.hostel.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class RoomBookingDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoomBookingDAO.class);

    public boolean bookRoom(int studentId, int roomId){
            String insert = "INSERT INTO StudentRoom (student_id, room_id) VALUES (?, ?)";
            String update = "UPDATE Room SET status = 'Occupied' WHERE room_id = ?";

            try (Connection conn = DBUtil.getConnection())
            {
                System.out.println("Inside bookRoom()");
                // Insert into StudentRoom
                try (PreparedStatement ps = conn.prepareStatement(insert)) {
                    System.out.println("Got DB connection");

                    // STEP 1: Insert into StudentRoom
                    System.out.println("Preparing StudentRoom insert...");
                    ps.setInt(1, studentId);
                    ps.setInt(2, roomId);
                    int inserted= ps.executeUpdate();
                    System.out.println("StudentRoom inserted rows: " + inserted);
                    logger.info("Inserted into StudentRoom");
                }
                catch (SQLException e) {
                    System.err.println(" SQLException in bookRoom(): " + e.getMessage());
                    System.err.println("SQLState: " + e.getSQLState());
                    System.err.println("ErrorCode: " + e.getErrorCode());
                    e.printStackTrace();
                    return false;
                }

                // Update Room status
                System.out.println("Preparing Room update...");
                try (PreparedStatement ps = conn.prepareStatement(update)) {
                    ps.setInt(1, roomId);
                    ps.executeUpdate();
                    logger.info("Updated Room Status");
                }

                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}