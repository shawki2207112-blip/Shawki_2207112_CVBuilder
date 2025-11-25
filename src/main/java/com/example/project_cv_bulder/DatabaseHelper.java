package com.example.project_cv_bulder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {

    // Use cv.db at project root. Change path if you place it elsewhere.
    private static final String DB_URL = "jdbc:sqlite:cv.db";

    public static void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS cv (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT,
                    email TEXT,
                    phone TEXT,
                    address TEXT,
                    education TEXT,
                    skills TEXT,
                    work_exp TEXT,
                    projects TEXT
                );
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCV(String name, String email, String phone, String address,
                                String education, String skills, String workExp, String projects) {

        String sql = "INSERT INTO cv(name,email,phone,address,education,skills,work_exp,projects) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, education);
            ps.setString(6, skills);
            ps.setString(7, workExp);
            ps.setString(8, projects);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCV(int id, String name, String email, String phone, String address,
                                String education, String skills, String workExp, String projects) {

        String sql = "UPDATE cv SET name=?, email=?, phone=?, address=?, education=?, skills=?, work_exp=?, projects=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, education);
            ps.setString(6, skills);
            ps.setString(7, workExp);
            ps.setString(8, projects);
            ps.setInt(9, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCV(int id) {
        String sql = "DELETE FROM cv WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<CVModel> getAllCVs() {
        List<CVModel> list = new ArrayList<>();
        String sql = "SELECT * FROM cv";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CVModel cv = new CVModel(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("education"),
                        rs.getString("skills"),
                        rs.getString("work_exp"),
                        rs.getString("projects")
                );
                list.add(cv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
