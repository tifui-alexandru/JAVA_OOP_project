package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbConnection {
    private static Connection con = null;
    private static DbConnection stingleInstance = null;

    DbConnection() {
        String url = "jdbc:mysql://localhost:3306/alex";
        String user = "alex";
        String pass = "alex";
        try {
            con = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DbConnection getInstance() {
        if (stingleInstance == null)
            stingleInstance = new DbConnection();
        return stingleInstance;
    }

    public static void insert(String tableName, List<String> dataList) {
        Statement statement = null;
        String data = String.join(", ", dataList);

        try {
            statement = con.createStatement();
            String query = String.format("insert into %s values (%s)", tableName, data);
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<List<String>> readAll(String tableName) {
        try {
            String query = String.format("select data from %s", tableName);
            ResultSet res = con.prepareStatement(query).executeQuery();

            List<List<String>> retVal = new ArrayList<>();
            while(res.next()) {
                String line = res.getString("data");
                List <String> listLine = Arrays.asList(line.split(", "));
                retVal.add(listLine);
            }

            return retVal;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static List<String> readOne(String tableName, String id) {
        try {
            String query = String.format("select data from %s", tableName);
            var res = con.prepareStatement(query).executeQuery();

            while(res.next()) {
                String line = res.getString("data");
                List <String> listLine = Arrays.asList(line.split(", "));
                if (listLine.get(0).equals(id))
                    return listLine;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return new ArrayList<>();
    }

    public static void update(String tableName, String id, List<String> newData) {
        Statement statement = null;
        String oldData = String.join(", ", readOne(tableName, id));

        try {
            statement = con.createStatement();
            String query = String.format("alter table %s set data = %s where data = %s", tableName, oldData, newData);
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void detede(String tableName, String id) {
        Statement statement = null;
        String data = String.join(", ", readOne(tableName, id));

        try {
            statement = con.createStatement();
            String query = String.format("delete from %s where data = %s", tableName, data);
            statement.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
