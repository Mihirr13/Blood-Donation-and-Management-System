package com.blood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blood.model.Officer;
import com.blood.util.DBUtil;

public class OfficerDAO {
    public static Officer validateOfficer(String email, String password) {
        Officer officer = null;

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT * FROM officer WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                officer = new Officer();
                officer.setId(rs.getInt("id"));
                officer.setName(rs.getString("name"));
                officer.setEmail(rs.getString("email"));
                officer.setCampName(rs.getString("camp_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return officer;
    }
}
