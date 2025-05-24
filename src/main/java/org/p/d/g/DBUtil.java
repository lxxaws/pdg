package org.p.d.g;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private String url;
    private String username;
    private String password;
    private String driverclass;

    public DBUtil(String url, String username, String password, String driverclass) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverclass = driverclass;
        try {
            Class.forName(driverclass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Utils.isp();
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
