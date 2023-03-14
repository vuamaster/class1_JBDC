package bai1.FakeData;

import bai1.dao.EmployeesDAO;
import bai1.model.Employees;
import com.github.javafaker.Faker;

import java.util.Locale;

public class Fakedata {
    public static void main(String[] args) {
        EmployeesDAO employeesDAO = new EmployeesDAO();
        Faker faker = new Faker(new Locale("vi"));

        for (int i = 0; i < 100; i++) {
            Employees e = new Employees();
            e.setFullname(faker.name().nameWithMiddle());
            e.setCity(faker.address().cityName());
            e.setEmail("a" + faker.number().numberBetween(100,1000000) + "bkacad" + faker.number().numberBetween(100,1000000) + "@gmail.com");
            e.setPhone(faker.phoneNumber().phoneNumber());
            e.setGender(faker.number().numberBetween(0,2));
            e.setSalary(faker.number().numberBetween(1000,3000));
            employeesDAO.insert(e);
        }
    }
}
