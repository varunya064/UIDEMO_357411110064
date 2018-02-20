package sample;

import dbUtil.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginMadel {
    Connection connection;

    public loginMadel()  {
        try {
            this.connection = dbconnection.getConnection();

        }catch (SQLException ex ){
            ex.printStackTrace();
        }
        if (this.connection == null) {
            System.exit(1);
        }
    }//loginModel
    public  boolean isDatabaseConnection(){
        return  this.connection != null;
    }//isData
    public boolean isLogin(String user,String pass) throws SQLException {
        PreparedStatement pr = null;
        ResultSet rs = null;
        String sql = "select * from user where username = ? and password = ?";
        try {
            pr = this.connection.prepareStatement(sql);
            pr.setString(1,user);
            pr.setString(2,pass);

            rs = pr.executeQuery();
            if (rs.next()){
                return true;

            }
            return false;
        }catch (SQLException ex){
            ex.printStackTrace();
            return  false;

        }finally {
            pr.close();
            rs.close();
        }

    }//isLogin

}//loginModel