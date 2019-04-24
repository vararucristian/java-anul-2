package controllers;

import database.Database;

import java.sql.*;

public class MovieController {
        public void create(String name,int director_id) throws SQLException {
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("insert into movies (name,director_id) values (?,?)")) {
                pstmt.setString(1, name);
                pstmt.setInt(2, director_id);
                pstmt.executeUpdate();
            }
        }
        public Integer findByName(String name) throws SQLException {
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("select id from movies where name like '" + name + "'")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        public String findById(int id) throws SQLException { return "Da"; }
    }
