package com.myJax.persistence.connection;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
// import gov.iti.jets.TalkieApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class EntityManagerSingleton {
    // INSTANCE;

    private static EntityManagerFactory instance;
    private EntityManagerSingleton() {}

    public static EntityManagerFactory getInstance(){

        if(instance == null){
            instance = Persistence.createEntityManagerFactory("aha");
        }

        return instance;
    }

    // MysqlConnectionPoolDataSource dataSource;
    // public Connection getConnection() throws SQLException {
    //     return dataSource.getConnection();
    // }

    // EntityManagerSingleton(){
    //     try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("db.properties")) {
    //         Properties props = new Properties();
    //         props.load(inputStream);
    //         dataSource = new MysqlConnectionPoolDataSource();
    //         dataSource.setURL(props.getProperty("MYSQL_DB_URL"));
    //         dataSource.setUser(props.getProperty("MYSQL_DB_USERNAME"));
    //         dataSource.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}