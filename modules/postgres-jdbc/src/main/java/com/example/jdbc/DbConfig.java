package com.example.jdbc;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;


public class DbConfig {
public static DataSource dataSource() {
String url = System.getenv().getOrDefault("JDBC_URL", "jdbc:postgresql://localhost:5432/appdb");
String user = System.getenv().getOrDefault("JDBC_USER", "appuser");
String pass = System.getenv().getOrDefault("JDBC_PASS", "apppass");


HikariConfig cfg = new HikariConfig();
cfg.setJdbcUrl(url);
cfg.setUsername(user);
cfg.setPassword(pass);
cfg.setMaximumPoolSize(5);
return new HikariDataSource(cfg);
}
}
