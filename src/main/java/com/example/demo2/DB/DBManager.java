package com.example.demo2.DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskListDb?userUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean addTask(Tasks tasks) {
        int rows = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" + "INSERT INTO tasks(id,name,date,priority,description)" + "VALUES(NULL,?,?,?,?)" + "");
            preparedStatement.setString(1, tasks.getName());
            preparedStatement.setString(2, tasks.getDate());
            preparedStatement.setString(3, tasks.getPriority());
            preparedStatement.setString(4, tasks.getDescription());
            rows = preparedStatement.executeUpdate();
            preparedStatement.close();


        } catch (Exception e) {

        }
        return rows > 0;
    }

    public static boolean editTask(Tasks tasks) {

        int row = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" + "UPDATE tasks  SET  name=? ,date=?,priority=?,description=? WHERE  id=?");

            preparedStatement.setString(1, tasks.getName());
            preparedStatement.setString(2, tasks.getDate());
            preparedStatement.setString(3, tasks.getPriority());
            preparedStatement.setString(4, tasks.getDescription());
            preparedStatement.setLong(5, tasks.getId());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public static boolean deleteTask(Tasks tasks) {

        int row = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("" + "DELETE  FROM tasks WHERE id=?");


            preparedStatement.setLong(1, tasks.getId());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public static ArrayList<Tasks> getTasks() {
        ArrayList<Tasks> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT  id,name,date,priority,description FROM tasks");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                tasks.add(new Tasks(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("date"),
                        resultSet.getString("priority"),
                        resultSet.getString("description")
                ));

            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static Tasks getTask(Long id) {
        Tasks task = null;
        try {
            PreparedStatement statement = connection.prepareStatement("" + "SELECT  id,name,date,priority,description FROM tasks WHERE id=? LIMIT 1" + "");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task = new Tasks(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("date"),
                        resultSet.getString("priority"),
                        resultSet.getString("description")
                );

            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }


}
