package com.iti.jets.sakilaJax.persistence.connection;
// import gov.iti.jets.TalkieApplication;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {
    // INSTANCE;

    private static EntityManagerFactory instance;
    private EntityManagerFactorySingleton() {}

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