package bai1.dao;

import bai1.connection.MyConnection;
import bai1.model.Employees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    // xem,them, sua, xoa
    public List<Employees> getAll(){
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối
        List<Employees> employeesListi = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM employees";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Employees e = new Employees();
                e.setId(rs.getLong("id"));
                e.setFullname(rs.getString("full_name"));
                e.setCity(rs.getString("city"));
                e.setEmail(rs.getString("email"));
                e.setPhone(rs.getString("phone"));
                e.setGender(rs.getInt("gender"));
                e.setSalary(rs.getInt("salary"));
                employeesListi.add(e);
            }
            conn.close();
            stmt.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return employeesListi;
    }
    public Employees getById(long id){
        try {
            //b1
            Connection conn = MyConnection.getConnection();
            //b2
            String sql = "SELECT * From employees where id = "+id;
            //b3
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Employees e =null;
            if (rs.next()){
                e = new Employees();
                e.setId(rs.getLong("id"));
                e.setFullname(rs.getString("full_name"));
                e.setCity(rs.getString("city"));
                e.setEmail(rs.getString("email"));
                e.setPhone(rs.getString("phone"));
                e.setGender(rs.getInt("gender"));
                e.setSalary(rs.getInt("salary"));
            }
            stmt.close();
            rs.close();
            conn.close();
            return e;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public  List<Employees> getBuyName(String name){
        List<Employees> employeesListi = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "SELECT * FROM employees where full_name like "+"'%"+name+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Employees e = new Employees();
                e.setId(rs.getLong("id"));
                e.setFullname(rs.getString("full_name"));
                e.setCity(rs.getString("city"));
                e.setEmail(rs.getString("email"));
                e.setPhone(rs.getString("phone"));
                e.setGender(rs.getInt("gender"));
                e.setSalary(rs.getInt("salary"));
                employeesListi.add(e);
            }
            conn.close();
            stmt.close();
            rs.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return employeesListi;
    }
    public void insert (Employees e){
        try {
            //b1
            Connection conn = MyConnection.getConnection();
            //b2
            String sql = String.format("INSERT INTO `employees` (`full_name`, `city`, `email`, `phone`, `gender`, `salary`) VALUES ('%s', '%s', '%s', '%s', '%d', '%d')",
                    e.getFullname(), e.getCity(), e.getEmail(), e.getPhone(), e.getGender(), e.getSalary()
                    );
            Statement stmt = conn.createStatement();
            int rs = stmt.executeUpdate(sql);
            if (rs == 0){
                System.out.println("thêm thất bại!");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void update(Employees e, long id){
        Employees tmp = getById(id);
        if (tmp == null){
            System.out.println("cap nhat that bai do id khong ton tai id = "+ id);
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            String sql = String.format("UPDATE `employees` SET `full_name` = '%s', `city` = '%s', `email` = '%s', `phone` = '%s', `gender` = '%d', `salary` = '%d' WHERE `id` = '%d'",
                   e.getFullname(),e.getCity(),e.getEmail(),e.getPhone(), e.getGender(), e.getSalary(), id);
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            System.out.println(rs);
            if (rs == 0){
                System.out.println("cap nhat that bai");
            }
            conn.close();
            stmt.close();
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }
    public void delete(long id){
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "DELETE FROM `employees` WHERE id = " + id;
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if (rs==0){
                System.out.println("xoa that bai");
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
