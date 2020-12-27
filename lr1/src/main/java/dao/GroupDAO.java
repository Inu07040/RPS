package dao;

import model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO extends DAO{
    private Connection connection;

    public Group getOneById(int id){
        try {
            connection = DriverManager.getConnection(url, user, password);
            String getCommand = "SELECT * FROM graduate2.Group WHERE id = ?";
            PreparedStatement select = connection.prepareStatement(getCommand);
            select.setInt(1, id);
            ResultSet result = select.executeQuery();
            result.next();
            String title = result.getString("title");
            String direction = result.getString("direction");
            return new Group(title, direction);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Group> getAll(){
        try {
            List<Group> groupsList = new ArrayList<Group>();
            connection = DriverManager.getConnection(url, user, password);
            String getCommand = "SELECT * FROM graduate2.Group";
            PreparedStatement select = connection.prepareStatement(getCommand);
            ResultSet result = select.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String title = result.getString("title");
                String direction = result.getString("direction");
                Group group = new Group(title, direction);
                groupsList.add(group);
            }
            return groupsList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public boolean add(Group group){
        try{
            connection = DriverManager.getConnection(url, user, password);
            String insertCommand = "INSERT INTO graduate2.Group(title, direction) VALUES(?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setString(1, group.getTitle());
            insert.setString(2, group.getDirection());
            if (insert.executeUpdate()>0) return true;
            insert.execute();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean update(int id, Group group){
        try{connection = DriverManager.getConnection(url, user, password);
            String updateCommand = "UPDATE graduate2.Group SET title = ?, direction = ? WHERE id = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setString(1,group.getTitle());
            update.setString(2,group.getDirection());
            update.setInt(5,id);
            update.execute();
            if (update.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public boolean delete(int id) {
        try{
            connection = DriverManager.getConnection(url, user, password);
            String deleteCommand = "DELETE FROM graduate2.Group WHERE id = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, id);
            delete.execute();
            if (delete.executeUpdate()>0) return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
