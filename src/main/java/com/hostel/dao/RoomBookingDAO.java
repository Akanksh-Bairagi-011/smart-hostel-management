package com.hostel.dao;

import com.hostel.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class RoomBookingDAO {
    public void allocateRoom(int studentId, int roomId, Date checkinDate, Date checkoutDate) {
        String sql = "INSERT INTO ROOM_ALLOCATION (allocation_id, student_id, room_id, checkin_date, checkout_date) " +
                "VALUES (ROOM_ALLOCATION_SEQ.NEXTVAL, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setInt(2, roomId);
            ps.setDate(3, checkinDate);
            ps.setDate(4, checkoutDate);

            ps.executeUpdate();
            System.out.println("✅ Room allocated successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to allocate room: " + e.getMessage());
        }
    }
}