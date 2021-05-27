package db;

import java.sql.*;

public class DbConnection {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql:// localhost:3306/org";
        String user = "alex";
        String pass = "alex";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        return con;
    }

    public static void insertData(String tableName, String data) {
        Statement statement = null;

        try {
            statement = con.createStatement();
            String query = "insert into {tableNmae} values ({data})";
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String readData(String tableName) {
        try {
            String query = "select data from {tableNmae}";
            return con.prepareStatement(query).executeQuery().getString(0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "none";
    }

    public static void updateData(String tableName, String oldData, String newData) {
        Statement statement = null;

        try {
            statement = con.createStatement();
            String query = "alter table {tableNmae} set data = {newData} where data = {oldData}";
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void detedeData(String tableName, String data) {
        Statement statement = null;

        try {
            statement = con.createStatement();
            String query = "delete from {tableNmae} where data = {data}";
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
