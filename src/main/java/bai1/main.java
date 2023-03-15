package bai1;

import bai1.dao.EmployeesDAO;
import bai1.model.Employees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class main {
    private static  EmployeesDAO employeesDAO =new EmployeesDAO();
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
        System.out.print("Nhập gới tính: nữ nhập 0, Nam nhập 1 : ");
        tmp.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập lương: ");
        tmp.setSalary(Integer.parseInt(in.nextLine()));
        employeesDAO.insert(tmp);
    }
    public static void capNhat(Scanner in){
        System.out.print("nhập id nhân viên muốn cập nhật : ");
        long id = Long.parseLong(in.nextLine());
        Employees tmp = new Employees();
        System.out.print("nhập tên: ");
        tmp.setFullname(in.nextLine());
        System.out.print("nhập city: ");
        tmp.setCity(in.nextLine());
        System.out.print("nhập email: ");
        tmp.setEmail(in.nextLine());
        System.out.print("nhập phone: ");
        tmp.setPhone(in.nextLine());
        System.out.print("Nhập gới tính: nữ nhập 0, Nam nhập 1 : ");
        tmp.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập lương: ");
        tmp.setSalary(Integer.parseInt(in.nextLine()));
        employeesDAO.update(tmp, id);
    }
    private static void option6(){
        List<Employees> employeesList3 = employeesDAO.getAll();
        System.out.printf("%-20s %-20s %-20s","Mã Nhân Viên","Tên Nhân Viên","Lương");
        System.out.println();
        employeesList3.stream()
                .sorted(Comparator.comparingDouble(Employees::getSalary).reversed())
                .limit(5)
                .forEach(employees -> System.out.printf("%-20s %-20s %-20d\n",employees.getId(),employees.getFullname(),employees.getSalary()));
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
                    //List<Employees> list = employeesDAO.getAll();
                    //cach2
                    List<Employees> employeesList1 = employeesDAO.getAll();
                    employeesList1.stream()
                            .sorted((o1, o2) -> o1.getFullname().compareTo(o2.getFullname()))
                            .forEach(employees -> System.out.println(employees));
                    break;
                case 3:
                    System.out.print("nhập tên muốn tìm kiếm: ");
                    String name = in.nextLine();
                    List<Employees> list = employeesDAO.getBuyName(name);
                    System.out.println(list);
                    break;
                case 4:
                    capNhat(in);
                    break;
                case 5:
                    System.out.print("nhập nhân viên id cần xóa : ");
                    long id = Long.parseLong(in.nextLine());
                    employeesDAO.delete(id);
                    break;
                case 6:
                    option6();
                    break;
                case 7:
                    final double[] tongluong = {0};
                    final int[] sonhanvien = {0};
                    List<Employees> employeesList2 = employeesDAO.getAll();
                    employeesList2.stream()
                            .filter(employees -> employees.getGender()==0)
                            .forEach(employees ->{
                                sonhanvien[0]++;
                                tongluong[0] = tongluong[0] + employees.getSalary();
                            } );
                    System.out.println("mức lương trung bình của nhân viên nữ là : "+tongluong[0]/sonhanvien[0]);
                    break;
                case 8:
                    break;
            }
        }while (option != 8);
        in.close();
    }
}
