//Faizaan Khan 3 May 2023

package vzap.com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Question 1   Total 10 marks

public class MySQL_Connection {

    // Database URL, username, and password
    private Connection connection;

    public MySQL_Connection() {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Establishes a connection to the database
    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

