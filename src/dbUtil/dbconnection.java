package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
    public static final String SQCONN ="jdbc:sqlite:school.sqlite";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;



    }//getConnection





}//class