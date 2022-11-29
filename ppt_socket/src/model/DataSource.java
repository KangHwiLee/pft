package model;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {
	private static DataSource     datasource;
    private BasicDataSource ds;
	
    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("test");
        ds.setPassword("xodidrhkdakstp1!");
        ds.setUrl("jdbc:mysql://118.40.105.135:3306/snowmelting?useSSL=false&serverTimezone=UTC&autoReconnect=true&characterEncoding=utf8");        
       
     // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);
        ds.setValidationQuery("select 1"); //validationQuery:유효 검사용 쿼리
        ds.setTestWhileIdle(true);   //testWhileIdle:컨넥션이 놀고 있을때 유효성 검사를 할지 여부
        ds.setTimeBetweenEvictionRunsMillis(1000*60*20); //해당 밀리초마다 validationQuery 를 이용하여 유효성 검사 진행 
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
} 
