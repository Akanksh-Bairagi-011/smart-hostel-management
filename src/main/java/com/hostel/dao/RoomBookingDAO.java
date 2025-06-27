package com.hostel.dao;

import com.hostel.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class RoomBookingDAO {

    private static final Logger logger = LoggerFactory.getLogger(RoomBookingDAO.class);


    public boolean checkOutRoom(int studentId) {
        logger.info("Attempting to check out student ID {}", studentId);

        // Step 1: Find the room the student is in
        String findRoomIdSQL = "SELECT room_id FROM StudentRoom WHERE student_id = ?";
        String deleteSQL = "DELETE FROM StudentRoom WHERE student_id = ?";
        String updateRoomSQL = "UPDATE Room SET status = 'Vacant' WHERE room_id = ?";

        try (Connection conn = DBUtil.getConnection()) {

            int roomId = -1;

            // Step 1: Fetch the assigned room ID
            try (PreparedStatement ps = conn.prepareStatement(findRoomIdSQL)) {
                ps.setInt(1, studentId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    roomId = rs.getInt("room_id");
                    logger.info("Student {} is assigned to room {}", studentId, roomId);
                } else {
                    logger.warn("No room assignment found for student {}", studentId);
                    return false;
                }
            }

            // Step 2: Delete from StudentRoom
            try (PreparedStatement ps = conn.prepareStatement(deleteSQL)) {
                ps.setInt(1, studentId);
                int deleted = ps.executeUpdate();
                logger.info("Deleted {} row(s) from StudentRoom for student {}", deleted, studentId);
            }

            // Step 3: Update Room status to Vacant
            try (PreparedStatement ps = conn.prepareStatement(updateRoomSQL)) {
                ps.setInt(1, roomId);
                int updated = ps.executeUpdate();
                logger.info("Room {} status set to 'Vacant'", roomId);
            }

            return true;

        } catch (SQLException e) {
            logger.error("Error during checkout for student {}: {}", studentId, e.getMessage());
            return false;
        }
    }


    public boolean CheckIn(int studentId, int roomId){
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
                    logger.info("Checked into StudentRoom");
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