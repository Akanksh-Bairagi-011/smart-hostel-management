package com.hostel.dao;

import com.hostel.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class ComplaintDAO {
    public void submitComplaint(int studentId, String complaintType, String description, String status, Date dateFiled) {
        String sql = "INSERT INTO COMPLAINT (complaint_id, student_id, complaint_type, description, status, date_filed) " +
                "VALUES (COMPLAINT_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ps.setString(2, complaintType);
            ps.setString(3, description);
            ps.setString(4, status);
            ps.setDate(5, dateFiled);

            ps.executeUpdate();
            System.out.println("✅ Complaint submitted successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Failed to submit complaint: " + e.getMessage());
        }
    }
}
