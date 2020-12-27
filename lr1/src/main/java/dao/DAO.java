package dao;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.xdevapi.Statement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
    /*protected DataSource ds = new MysqlDataSource();
    protected String user = "root";
    protected String password = "inu07040";*/

    protected static final String url = "jdbc:mysql://localhost:3306/graduate2?serverTimezone=Europe/Moscow&useSSL=FALSE";
    protected static final String user = "root";
    protected static final String password = "inu07040";

}


