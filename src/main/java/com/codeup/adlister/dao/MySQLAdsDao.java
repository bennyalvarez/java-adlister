package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private static Connection conn;

    public MySQLUsersDao(Config config) {
        if (conn == null) {
            try {
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(
                        config.getUrl(),
                        config.getUser(),
                        config.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException("Error connecting to the database!", e);
            }
        }
    }

    @Override
    public User findByUsername(String username) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE username = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                users.add(new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.get(0);
    }

    @Override
    public Long insert(User user) {
        String queryString = "INSERT INTO users(username, email, password) VALUES (?, ?, ?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Error creating new user", throwables);
        }
    }
}

//package com.codeup.adlister.dao;
//
//import com.codeup.adlister.models.Ad;
//import com.mysql.cj.jdbc.Driver;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MySQLAdsDao implements Ads {
//    private Connection connection = null;
//
//    public MySQLAdsDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database!", e);
//        }
//    }
//
//    @Override
//    public List<Ad> all() {
//        Statement stmt = null;
//        try {
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ads");
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
//
//    @Override
//    public Long insert(Ad ad) {
//        String sql = "INSERT INTO ads(title, description, user_id) VALUES (?, ?, ?);";
//        try {
//            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); //allows you to see the ad after being created.
//            stmt.setString(1, ad.getTitle());
//            stmt.setString(2, ad.getDescription());
//            stmt.setLong(3, ad.getUserId());
//            stmt.executeUpdate();
//            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating a new ad.", e);
//        }
//    }
//
////    @Override
////    public Ad getOne(long id) {
////        String sql = "SELECT * FROM ads WHERE id = ?;"
////          try {
////              PreparedStatement stmt = connection.prepareStatement(sql);
////              stmt.setLong(1, id);
////              ResultSet rs = stmt.executeQuery();
////              rs.next();
////              return extractAd(rs);
////          } catch (SQLException e) {
////              e.printStackTrace();
////          }
////          return new Ad();
////    }
//
//    private String createInsertQuery(Ad ad) {
//        return "INSERT INTO ads(user_id, title, description) VALUES "
//                + "(" + ad.getUserId() + ", "
//                + "'" + ad.getTitle() +"', "
//                + "'" + ad.getDescription() + "')";
//    }
//
//    private Ad extractAd(ResultSet rs) throws SQLException {
//        return new Ad(
//                rs.getLong("id"),
//                rs.getLong("user_id"),
//                rs.getString("title"),
//                rs.getString("description")
//        );
//    }
//
//    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
//        List<Ad> ads = new ArrayList<>();
//        while (rs.next()) {
//            ads.add(extractAd(rs));
//        }
//        return ads;
//    }
//
//    @Override
//    public List<Ad> searchByTitle(String query) {
//        String sql = "SELECT * FROM ads WHERE title LIKE ?;";
//        String searchTermWithWildcards = "%" + query + "%";
//        PreparedStatement stmt = null;
//        try {
//            stmt = connection.prepareStatement(sql);
//            stmt.setString(1, searchTermWithWildcards);
//            ResultSet rs = stmt.executeQuery();
//            return createAdsFromResults(rs);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error retrieving all ads.", e);
//        }
//    }
//}