package sample;

import dbUtil.dbconnection;
import dbUtil.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

public class loginMadel {
    Connection connection;

    public loginMadel() throws SQLException {

        this.connection = dbconnection.getConnection();

        if (this.connection == null) {
            System.exit(1);
        }
    }//loginModel
    public  boolean isDatabaseConnection(){
        return  this.connection != null;


    }
}//loginModel