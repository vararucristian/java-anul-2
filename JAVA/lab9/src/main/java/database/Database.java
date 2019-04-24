package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/java?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        private static final String USER = "dba";
        private static final String PASSWORD = "sql";
        private static Connection connection = null;
        private Database() { }
        public static Connection getConnection() {
            if (connection == null) {
                createConnection();
            }
            return connection;
        }
  //  ...//Implement the method createConnection()
         //   ...//Implement the method closeConnection()
       //     ...//Implement the method commit()
     //       ...//Implement the method rollback()


    private static void createConnection() {

        try {Class.forName("com.mysql.cj.jdbc.Driver");
             connection = DriverManager.getConnection(URL, USER, PASSWORD);
             connection.setAutoCommit(false);
        } catch(ClassNotFoundException e) {System.err.print("ClassNotFoundException: " + e) ;
        } catch(SQLException e) {System.err.println("SQLException: " + e);
        }
        }

        public static void commit() {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void closeConnection() {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void rollback() {
            try {
                connection.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
