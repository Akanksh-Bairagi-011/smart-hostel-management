package com.hostel.dao;

import com.hostel.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeDAO {
    public void getFeeRecord(int studentId) {
        String sql = "SELECT * FROM FEE_RECORD WHERE student_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double amount = rs.getDouble("amount");
                String dueDate = rs.getString("due_date");
                String isPaid = rs.getString("is_paid");
                System.out.println("💰 Amount: ₹" + amount + ", Due Date: " + dueDate + ", Paid: " + isPaid);
            } else {
                System.out.println("❌ No fee record found.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error fetching fee: " + e.getMessage());
        }
    }
}
