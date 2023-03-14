package dao;

import connection.MyConnection;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    //xem, them, sua, xoa
    public List<Person> getAll(){
        // Bươc 1: Tạo kết nối

        // Bước 2: Chuẩn bị câu lệnh

        // Bước 3: Thực thi và xem kết quả

        // Bước 4: Đóng kết nối
        List<Person> personListe = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "Select * from persons";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Person p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                personListe.add(p);
            }
            rs.close();
            stmt.close();
            conn.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  personListe;
    }
    public Person getByID(long id) {
        //b1
        try {
            Connection conn = MyConnection.getConnection();
            // b2
            String sql = "SELECT * From `persons` Where `id`= " + id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Person p = null;
            if (rs.next()) {
                p = new Person();
                p.setId(rs.getLong("id"));
                p.setName(rs.getString("name"));
                p.setAddress(rs.getString("address"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void insert(Person p){
        try {
            // buoc 1
            Connection conn = MyConnection.getConnection();
            // buoc 2
            String sql = String.format("INSERT INTO `persons` (`name`, `address`, `phone`, `email`) VALUES ('%s', '%s', '%s', '%s')",
                    p.getName(), p.getAddress(), p.getPhone(), p.getEmail()
            );
            // buoc 3
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // buoc 4
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(Person p, long id){
        Person tmp = getByID(id);
        if (tmp == null) {
            System.out.println("Cập nhật thất bại do không có id = " + id);
            return;
        }
        // Bươc 1: Tạo kết nối
        // Bước 2: Chuẩn bị câu lệnh
        // Bước 3: Thực thi và xem kết quả
        // Bước 4: Đóng kết nối
        try {
            // Buoc 1
            Connection conn = MyConnection.getConnection();
            // Buoc 2
            String sql = String.format("UPDATE `persons` SET `name`='%s', `address`='%s', `phone`='%s', `email`='%s' WHERE `id`= %d",
                    p.getName(), p.getAddress(), p.getPhone(), p.getEmail(), id
            );

            //System.out.println(sql);

            // Buoc 3
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(long id){
        try {
            //buoc1
            Connection conn = MyConnection.getConnection();
            // buoc 2
            String sql = "DELETE FROM `persons` WHERE id = " + id;
            // buoc 3
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);
            if(rs==0){
                System.out.println("xóa thất bại!");
            }
            conn.close();
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
