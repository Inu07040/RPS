package dao;
import model.Graduate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GraduateDAO extends DAO{
    private Connection connection;

    public Graduate getOneById(int id){
        try{
            connection = DriverManager.getConnection(url, user, password);
            String selectCommand = "SELECT * FROM graduate2.Graduate WHERE id = ?";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            select.setInt(1, id);
            ResultSet result = select.executeQuery();
            result.next();
            String last_name = result.getString("last_name");
            String first_name = result.getString("first_name");
            int group_id = result.getInt("group_id");

            return new Graduate(last_name, first_name, group_id);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Graduate> getAll(){
        try{
            List<Graduate> graduateList = new ArrayList<Graduate>();
            connection = DriverManager.getConnection(url, user, password);
            String selectCommand = "SELECT * FROM graduate2.Graduate";
            PreparedStatement select = connection.prepareStatement(selectCommand);
            ResultSet result = select.executeQuery();
            while(result.next()){
                int id = result.getInt("id");
                String last_name = result.getString("last_name");
                String first_name = result.getString("first_name");
                int group_id = result.getInt("group_id");
                Graduate graduate = new Graduate(last_name, first_name, group_id);
                graduateList.add(graduate);
            }
            return graduateList;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void add(Graduate graduate){
        try{
            connection = DriverManager.getConnection(url, user, password);
            String insertCommand = "INSERT INTO graduate2.Graduate(last_name, first_name, group_id) VALUES(?,?,?)";
            PreparedStatement insert = connection.prepareStatement(insertCommand);
            insert.setString(1, graduate.getFirstName());
            insert.setString(2, graduate.getLastName());
            insert.setInt(3, graduate.getGroup_id());
            insert.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, Graduate graduate){
        try{
            connection = DriverManager.getConnection(url, user, password);
            String updateCommand = "UPDATE graduate2.Graduate SET last_name = ?, first_name = ?, group_id = ? WHERE id = ?";
            PreparedStatement update = connection.prepareStatement(updateCommand);
            update.setString(1, graduate.getFirstName());
            update.setString(2, graduate.getLastName());
            update.setInt(3, graduate.getGroup_id());
            update.setInt(4,id);
            update.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try{
            connection = DriverManager.getConnection(url, user, password);
            String deleteCommand = "DELETE FROM graduate2.Graduate WHERE id = ?";
            PreparedStatement delete = connection.prepareStatement(deleteCommand);
            delete.setInt(1, id);
            delete.execute();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}