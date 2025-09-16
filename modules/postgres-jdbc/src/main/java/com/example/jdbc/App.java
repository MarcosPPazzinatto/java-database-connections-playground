package com.example.jdbc;


public class App {
public static void main(String[] args) throws Exception {
var ds = DbConfig.dataSource();
var dao = new UserDao(ds);
dao.initSchema();
long id = dao.insert("Alice");
System.out.println("Inserted id = " + id);
dao.listAll();
}
}
