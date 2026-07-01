package com.example.crud;

import com.example.crud.Service;
import com.example.crud.Student;

import javax.xml.transform.Result;
import java.sql.*;


public class ServiceImpl implements Service {
    @Override
    public void createDatabase(String dbname) {
        String sql = "create database if not exists " + dbname;
        try (Connection con = DBUtil.getConnectionToServer()) {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Database created or already exists");
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void createTable() {
        String db = InputUtil.getDbname();
        String sql = "CREATE TABLE `mydatabase`.`student_details` (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `regno` VARCHAR(45) NOT NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `dept` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`regno`));\n";
        try (Connection con = DBUtil.getConnectionToServer()) {
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Table Created:");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertData(Student student) {
        try (Connection con = DBUtil.getConnectionToServer()) {
            String db = InputUtil.getDbname();
            String sql = "insert into" + ".student_details values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Student.getId());
            ps.setString(2, student.getRegno());
            ps.setString(3, student.getName());
            ps.setString(4, student.getDept());
            ps.setString(5, student.getEmail());
            ps.executeUpdate();
            System.out.println("Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(String regno, String name) {

    }

    @Override
    public void update() {

    }

    @Override
    public void findAll() {
        String db = InputUtil.getDbname();
        String sql = "select * from " + db + ".student_details";
        try (Connection con = DBUtil.getConnectionToServer()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("regno") + " " + rs.getString(" name") + " " + rs.getString("dept") + " " + rs.getString("email"));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}