package BAI_9;

import java.util.Scanner;

class Vecto {
    private double x1; // Hoành độ đầu
    private double y1; // Tung độ đầu
    private double x2; // Hoành độ cuối
    private double y2; // Tung độ cuối

    // Constructors
    public Vecto() {
    }

    public Vecto(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Getters and Setters
    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    // Kiểm tra hai vecto có bằng nhau không
    public boolean isEqual(Vecto other) {
        return (this.x1 == other.x1 && this.y1 == other.y1 && this.x2 == other.x2 && this.y2 == other.y2);
    }

    // Tính góc giữa hai vecto (trong đơn vị radian)
    public double calculateAngle(Vecto other) {
        double dotProduct = this.x1 * other.x1 + this.y1 * other.y1 + this.x2 * other.x2 + this.y2 * other.y2;
        double magnitude1 = Math.sqrt(this.x1 * this.x1 + this.y1 * this.y1 + this.x2 * this.x2 + this.y2 * this.y2);
        double magnitude2 = Math.sqrt(other.x1 * other.x1 + other.y1 * other.y1 + other.x2 * other.x2 + other.y2 * other.y2);
        double cosTheta = dotProduct / (magnitude1 * magnitude2);
        return Math.acos(cosTheta);
    }

    // Tính module của vecto
    public double calculateMagnitude() {
        double magnitude = Math.sqrt((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1));
        return magnitude;
    }

    // Kiểm tra hai vecto có cùng phương không
    public boolean areParallel(Vecto other) {
        double crossProduct = (this.x2 - this.x1) * (other.y2 - other.y1) - (this.y2 - this.y1) * (other.x2 - other.x1);
        return (crossProduct == 0);
    }

    // Cộng hai vecto
    public Vecto add(Vecto other) {
        double newX1 = this.x1 + other.x1;
        double newY1 = this.y1 + other.y1;
        double newX2 = this.x2 + other.x2;
        double newY2 = this.y2 + other.y2;
        return new Vecto(newX1, newY1, newX2, newY2);
    }

    // Trừ hai vecto
    public Vecto subtract(Vecto other) {
        double newX1 = this.x1 - other.x1;
        double newY1 = this.y1 - other.y1;
        double newX2 = this.x2 - other.x2;
        double newY2 = this.y2 - other.y2;
        return new Vecto(newX1, newY1, newX2, newY2);
    }

    // Nhân vecto với một số
    public Vecto multiply(double number) {
        double newX1 = this.x1 * number;
        double newY1 = this.y1 * number;
        double newX2 = this.x2 * number;
        double newY2 = this.y2 * number;
        return new Vecto(newX1, newY1, newX2, newY2);
    }

    // In thông tin của vecto
    public void display() {
        System.out.println("Hoành độ đầu: " + this.x1);
        System.out.println("Tung độ đầu: " + this.y1);
        System.out.println("Hoành độ cuối: " + this.x2);
        System.out.println("Tung độ cuối: " + this.y2);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vecto 1:");
        System.out.print("Hoành độ đầu: ");
        double x1_1 = scanner.nextDouble();
        System.out.print("Tung độ đầu: ");
        double y1_1 = scanner.nextDouble();
        System.out.print("Hoành độ cuối: ");
        double x2_1 = scanner.nextDouble();
        System.out.print("Tung độ cuối: ");
        double y2_1 = scanner.nextDouble();
        Vecto vecto1 = new Vecto(x1_1, y1_1, x2_1, y2_1);

        System.out.println("Nhập vecto 2:");
        System.out.print("Hoành độ đầu: ");
        double x1_2 = scanner.nextDouble();
        System.out.print("Tung độ đầu: ");
        double y1_2 = scanner.nextDouble();
        System.out.print("Hoành độ cuối: ");
        double x2_2 = scanner.nextDouble();
        System.out.print("Tung độ cuối: ");
        double y2_2 = scanner.nextDouble();
        Vecto vecto2 = new Vecto(x1_2, y1_2, x2_2, y2_2);

        System.out.println("Thông tin của vecto 1:");
        vecto1.display();
        System.out.println("Thông tin của vecto 2:");
        vecto2.display();

        System.out.println("Hai vecto có bằng nhau không? " + vecto1.isEqual(vecto2));
        System.out.println("Góc giữa hai vecto: " + vecto1.calculateAngle(vecto2));
        System.out.println("Module của vecto 1: " + vecto1.calculateMagnitude());
        System.out.println("Module của vecto 2: " + vecto2.calculateMagnitude());
        System.out.println("Hai vecto có cùng phương không? " + vecto1.areParallel(vecto2));

        System.out.println("Tổng hai vecto:");
        Vecto sum = vecto1.add(vecto2);
        sum.display();

        System.out.println("Hiệu hai vecto:");
        Vecto difference = vecto1.subtract(vecto2);
        difference.display();

        System.out.print("Nhập số để nhân vecto 2: ");
        double number = scanner.nextDouble();
        System.out.println("Tích hai vecto:");
        Vecto product = vecto2.multiply(number);
        product.display();

        scanner.close();
    }
}
