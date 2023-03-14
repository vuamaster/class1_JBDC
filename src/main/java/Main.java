import dao.PersonDAO;
import model.Person;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
        //lay ra toan bo nguoi
        List<Person> list = personDAO.getAll();
        System.out.println(list);
        // them 1 nguoi vao database
       /* Person p = new Person();
        p.setName("Hoang van giang");
        p.setAddress("BN");
        p.setPhone("099997876");
        p.setEmail("ggg@gmail.com");

        personDAO.insert(p);*/
        /*Scanner in = new Scanner(System.in);
        Person tmp = new Person();
        System.out.print("nhap id can cap nhat : ");
        long id = Long.parseLong(in.nextLine());
        personDAO.delete(id);*/
      /*  System.out.print("Nhap ten: ");
        tmp.setName(in.nextLine());
        System.out.print("Nhap dia chi: ");
        tmp.setAddress(in.nextLine());
        System.out.print("Nhap sdt: ");
        tmp.setPhone(in.nextLine());
        System.out.print("Nhap email: ");
        tmp.setEmail(in.nextLine());
        in.close();
        personDAO.update(tmp, id);*/
    }
}
