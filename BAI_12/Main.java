package BAI_12;

import java.util.Scanner;

class Polygon {
    protected int numSides; // số cạnh
    protected double[] sideLengths; // độ dài các cạnh

    public Polygon(int numSides) {
        this.numSides = numSides;
        this.sideLengths = new double[numSides];
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numSides; i++) {
            System.out.print("Nhập độ dài cạnh thứ " + (i + 1) + ": ");
            double length = scanner.nextDouble();
            sideLengths[i] = length;
        }
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        for (double length : sideLengths) {
            perimeter += length;
        }
        return perimeter;
    }

    public double calculateArea() {
        return 0; // implement in subclasses
    }
}

class Parallelogram extends Polygon {
    protected double base; // đáy
    protected double height; // chiều cao

    public Parallelogram(double base, double height) {
        super(4);
        this.base = base;
        this.height = height;
        sideLengths[0] = base;
        sideLengths[2] = base;
        sideLengths[1] = height;
        sideLengths[3] = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(double length, double width) {
        super(length, width);
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chiều dài hình chữ nhật: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng hình chữ nhật: ");
        double width = scanner.nextDouble();

        Rectangle rectangle = new Rectangle(length, width);
        System.out.println("Chu vi hình chữ nhật: " + rectangle.calculatePerimeter());
        System.out.println("Diện tích hình chữ nhật: " + rectangle.calculateArea());

        System.out.print("Nhập cạnh hình vuông: ");
        double side = scanner.nextDouble();

        Square square = new Square(side);
        System.out.println("Chu vi hình vuông: " + square.calculatePerimeter());
        System.out.println("Diện tích hình vuông: " + square.calculateArea());

        scanner.close();
    }
}

