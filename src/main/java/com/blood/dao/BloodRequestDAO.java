package com.blood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.blood.util.DBUtil;

public class BloodRequestDAO {
    public static boolean requestBlood(String name, String email, String phone,
            String bloodGroup, String location) {
        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO blood_request (name, email, phone, bloodGroup, location) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, bloodGroup);
            ps.setString(5, location);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
