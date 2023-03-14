package bai1.model;

public class Employees {
    private long id;
    private String fullname;
    private String city;
    private String email;
    private String phone;
    private int gender;
    private int salary;

    public Employees() {
    }

    public Employees(String fullname, String city, String email, String phone, int gender, int salary) {
        this.fullname = fullname;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
    }

    public Employees(long id, String fullname, String city, String email, String phone, int gender, int salary) {
        this.id = id;
        this.fullname = fullname;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees[" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ']';
    }
}
