package com.example.jdbc;


import javax.sql.DataSource;
import java.sql.*;


public class UserDao {
private final DataSource ds;
public UserDao(DataSource ds) { this.ds = ds; }


public void initSchema() throws SQLException {
try (Connection c = ds.getConnection(); Statement st = c.createStatement()) {
st.executeUpdate("CREATE TABLE IF NOT EXISTS app_user (id SERIAL PRIMARY KEY, name TEXT NOT NULL)");
}
}


public long insert(String name) throws SQLException {
try (Connection c = ds.getConnection(); PreparedStatement ps = c.prepareStatement(
"INSERT INTO app_user(name) VALUES (?) RETURNING id")) {
ps.setString(1, name);
try (ResultSet rs = ps.executeQuery()) {
rs.next();
return rs.getLong(1);
}
}
}


public void listAll() throws SQLException {
try (Connection c = ds.getConnection(); Statement st = c.createStatement();
ResultSet rs = st.executeQuery("SELECT id, name FROM app_user ORDER BY id")) {
while (rs.next()) {
System.out.printf("%d - %s%n", rs.getLong("id"), rs.getString("name"));
}
}
}
}
