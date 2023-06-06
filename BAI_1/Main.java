package BAI_1;
 
import java.util.Scanner;

class sinhVien {
    private String name;
    private int age;
    private String address;
    private double salary; // tiền lương
    private double total_working_hour; // tổng số giờ làm việc

    public sinhVien() {
        name = "";
        age = 0;
        address = "";
        salary = 0;
        total_working_hour = 0;
    }

    public sinhVien(String name, int age, String address, double salary, double total_working_hour) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.total_working_hour = total_working_hour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getTotal_working_hour() {
        return total_working_hour;
    }

    public void setTotal_working_hour(double total_working_hour) {
        this.total_working_hour = total_working_hour;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name : ");
        name = scanner.nextLine();
        System.out.print("Enter age : ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter address : ");
        address = scanner.nextLine();
        System.out.print("Enter salary : ");
        salary = scanner.nextDouble();
        System.out.print("Enter total working hour : ");
        total_working_hour = scanner.nextDouble();

        scanner.close();
    }

    public void outPut() {
        System.out.println("Information of student : ");

        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Address : " + address);
        System.out.println("Salary : " + salary);
        System.out.println("Total working hour : " + total_working_hour);
    }

    public void bonus_calculate() {
        if (total_working_hour >= 200) {
            System.out.println("Bonus : " + salary * 0.2);
        } else if (total_working_hour < 200 && total_working_hour >= 100) {
            System.out.println("Bonus : " + salary * 0.1);
        } else if (total_working_hour < 100) {
            System.out.println("Bonus : " + salary);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        sinhVien sv1 = new sinhVien();  // full constructor
        sinhVien sv2 = new sinhVien();  // incomplete constructor

        sv1.inputInfo();
        sv1.outPut();
        sv1.bonus_calculate();

        sv2.setName("Trinh Minh Duc");
        sv2.setAge(20);
        sv2.setAddress("Ha Noi");
        sv2.setSalary(20000);
        sv2.setTotal_working_hour(10);

        System.out.println("Name : " + sv2.getName());
        System.out.println("Age : " + sv2.getAge());
        System.out.println("Address : " + sv2.getAddress());
        System.out.println("Salary : " + sv2.getSalary());
        System.out.println("Total working hour " + sv2.getTotal_working_hour());
        sv2.bonus_calculate();

    }
}
