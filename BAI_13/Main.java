package BAI_13;

import java.util.Scanner;

class Point {
    protected double x; // hoành độ
    protected double y; // tung độ

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class Ellipse extends Point {
    protected double semiMajorAxis; // bán trục lớn
    protected double semiMinorAxis; // bán trục nhỏ

    public Ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis) {
        super(x, y);
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    public double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }
}

class Circle extends Ellipse {
    public Circle(double x, double y, double radius) {
        super(x, y, radius, radius);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập hoành độ tâm: ");
        double x = scanner.nextDouble();
        System.out.print("Nhập tung độ tâm: ");
        double y = scanner.nextDouble();
        System.out.print("Nhập bán trục lớn: ");
        double semiMajorAxis = scanner.nextDouble();
        System.out.print("Nhập bán trục nhỏ: ");
        double semiMinorAxis = scanner.nextDouble();

        Ellipse ellipse = new Ellipse(x, y, semiMajorAxis, semiMinorAxis);
        System.out.println("Diện tích elip: " + ellipse.calculateArea());

        System.out.print("Nhập hoành độ tâm đường tròn: ");
        x = scanner.nextDouble();
        System.out.print("Nhập tung độ tâm đường tròn: ");
        y = scanner.nextDouble();
        System.out.print("Nhập bán kính đường tròn: ");
        double radius = scanner.nextDouble();

        Circle circle = new Circle(x, y, radius);
        System.out.println("Diện tích đường tròn: " + circle.calculateArea());

        scanner.close();
    }
}

