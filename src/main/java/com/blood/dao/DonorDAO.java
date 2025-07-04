package com.blood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blood.model.Donor;
import com.blood.util.DBUtil;

public class DonorDAO {

    // Register a donor
    public static boolean registerDonor(String name, String email, String password,
            String phone, String address, String bloodGroup) {
        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO donor (name, email, password, phone, address, bloodGroup) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, bloodGroup);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Donor validateDonor(String email, String password) {
        Donor donor = null;

        try (Connection con = DBUtil.getConnection()) {
            String query = "SELECT * FROM donor WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                donor = new Donor();
                donor.setId(rs.getInt("id"));
                donor.setName(rs.getString("name"));
                donor.setEmail(rs.getString("email"));
                donor.setPhone(rs.getString("phone"));
                donor.setAddress(rs.getString("address"));
                donor.setBloodGroup(rs.getString("bloodGroup"));
                // Don't set password in model if not needed
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return donor;
    }
}
