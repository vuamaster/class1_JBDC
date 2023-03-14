package bai1;

import bai1.dao.EmployeesDAO;
import bai1.model.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    static  EmployeesDAO employeesDAO =new EmployeesDAO();
    static  List<Employees> employeesList = new ArrayList<>();
    public static void mainMenu(){
        System.out.println("----QUẢN LÝ NHÂN SỰ----");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Danh sách nhân viên");
        System.out.println("3. Tìm kiếm nhân viên theo tên");
        System.out.println("4. cập nhật thông tin nhân viên");
        System.out.println("5. Xóa nhân viên theo mã");
        System.out.println("6. Lọc ra top 5 lương cao nhất");
        System.out.println("7. In ra trung bình mức lương của nhân viên nữ");
        System.out.println("8. Thoát");
    }
    public static void themnhanvien(Scanner in){
        Employees tmp = new Employees();
        System.out.print("nhập tên: ");
        tmp.setFullname(in.nextLine());
        System.out.print("nhập city: ");
        tmp.setCity(in.nextLine());
        System.out.print("nhập email: ");
        tmp.setEmail(in.nextLine());
        System.out.print("nhập phone: ");
        tmp.setPhone(in.nextLine());
        System.out.print("nhập gới tính ( 0-nữ, 1- nam) :");
        tmp.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập lương: ");
        tmp.setSalary(Integer.parseInt(in.nextLine()));
        employeesDAO.insert(tmp);
    }
    public static void main(String[] args) {
        List<Employees> employeesList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int option = -1;
        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());
            }
            catch (Exception e){
                System.out.println("nhập sai định dạng!");
                continue;
            }
            if (option<1 || option>8){
                System.out.println("lựa chọn ko hợp lệ");
                continue;
            }
            switch (option){
                case 1:
                    themnhanvien(in);
                    break;
                case 2:
                    List<Employees> list = employeesDAO.getAll();
                    System.out.println(list);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }
        }while (option != 8);
    }
}
