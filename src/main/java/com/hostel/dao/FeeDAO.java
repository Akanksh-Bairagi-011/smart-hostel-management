package com.hostel.dao;

import com.hostel.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeDAO {


    private static final Logger logger = LoggerFactory.getLogger(FeeDAO.class);

    public void getFeeStatus(int studentId) {
        String sql = "SELECT fee_id, amount, due_date, is_paid FROM FeeRecord WHERE student_id = ?";
        //System.out.println("inside feeStatus");
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            //System.out.println("inside connection");
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            //System.out.println("before while");

            while (rs.next()) {
                System.out.println("Fee ID: " + rs.getInt("fee_id"));
                System.out.println("Amount: ₹" + rs.getDouble("amount"));
                System.out.println("Due Date: " + rs.getDate("due_date"));
                System.out.println("Paid: " + rs.getBoolean("is_paid"));
                System.out.println("-----");
            }
//            System.out.println("op done");
            logger.info("Fee record accessed by {} ",studentId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
