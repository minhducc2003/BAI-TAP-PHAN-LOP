package BAI_14;

import java.util.Scanner;

class Triangle {
    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

class RightTriangle extends Triangle {
    public RightTriangle(double side1, double side2) {
        super(side1, side2, Math.sqrt(side1 * side1 + side2 * side2));
    }
}

class IsoscelesTriangle extends Triangle {
    public IsoscelesTriangle(double base, double legs) {
        super(base, legs, legs);
    }
}

class EquilateralTriangle extends IsoscelesTriangle {
    public EquilateralTriangle(double side) {
        super(side, side);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập ba cạnh của tam giác:");
        double side1 = scanner.nextDouble();
        double side2 = scanner.nextDouble();
        double side3 = scanner.nextDouble();

        Triangle triangle = new Triangle(side1, side2, side3);
        System.out.println("Diện tích tam giác: " + triangle.calculateArea());
        System.out.println("Chu vi tam giác: " + triangle.calculatePerimeter());

        System.out.println("Nhập hai cạnh của tam giác vuông:");
        side1 = scanner.nextDouble();
        side2 = scanner.nextDouble();

        RightTriangle rightTriangle = new RightTriangle(side1, side2);
        System.out.println("Diện tích tam giác vuông: " + rightTriangle.calculateArea());
        System.out.println("Chu vi tam giác vuông: " + rightTriangle.calculatePerimeter());

        System.out.println("Nhập cạnh đáy và cạnh đồng dạng của tam giác cân:");
        double base = scanner.nextDouble();
        double legs = scanner.nextDouble();

        IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle(base, legs);
        System.out.println("Diện tích tam giác cân: " + isoscelesTriangle.calculateArea());
        System.out.println("Chu vi tam giác cân: " + isoscelesTriangle.calculatePerimeter());

        System.out.println("Nhập cạnh của tam giác đều:");
        double side = scanner.nextDouble();

        EquilateralTriangle equilateralTriangle = new EquilateralTriangle(side);
        System.out.println("Diện tích tam giác đều: " + equilateralTriangle.calculateArea());
        System.out.println("Chu vi tam giác đều: " + equilateralTriangle.calculatePerimeter());

        scanner.close();
    }
}

