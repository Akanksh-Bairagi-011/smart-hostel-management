package com.hostel.dao;

import com.hostel.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class ComplaintDAO {

    private static final Logger logger = LoggerFactory.getLogger(ComplaintDAO.class);

    public boolean fileComplaint(int studentId, String complaintType, String description) {
        String sql = "INSERT INTO Complaint (student_id, complaint_type, description, status, date_filed) VALUES (?, ?, ?, 'Pending', CURRENT_DATE)";

        try (Connection conn = DBUtil.getConnection())
        {

             try(PreparedStatement ps = conn.prepareStatement(sql))
             {

                 ps.setInt(1, studentId);
                 ps.setString(2, complaintType);
                 ps.setString(3, description);

                 ps.executeUpdate();
                 logger.info("Complaint Log by {}", studentId);
                 return true;

             }
             catch (Exception ex) {
                 throw new RuntimeException(ex);
             }
        }

         catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
