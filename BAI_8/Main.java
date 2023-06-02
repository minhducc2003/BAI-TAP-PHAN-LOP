package BAI_8;

import java.util.Scanner;

class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newRealPart = this.realPart + other.realPart;
        double newImaginaryPart = this.imaginaryPart + other.imaginaryPart;
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newRealPart = this.realPart - other.realPart;
        double newImaginaryPart = this.imaginaryPart - other.imaginaryPart;
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newRealPart = this.realPart * other.realPart - this.imaginaryPart * other.imaginaryPart;
        double newImaginaryPart = this.realPart * other.imaginaryPart + this.imaginaryPart * other.realPart;
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double divisor = other.realPart * other.realPart + other.imaginaryPart * other.imaginaryPart;
        double newRealPart = (this.realPart * other.realPart + this.imaginaryPart * other.imaginaryPart) / divisor;
        double newImaginaryPart = (this.imaginaryPart * other.realPart - this.realPart * other.imaginaryPart) / divisor;
        return new ComplexNumber(newRealPart, newImaginaryPart);
    }

    @Override
    public String toString() {
        if (imaginaryPart >= 0) {
            return realPart + " + " + imaginaryPart + "i";
        } else {
            return realPart + " - " + (-imaginaryPart) + "i";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập phần thực của số phức 1: ");
        double realPart1 = scanner.nextDouble();

        System.out.println("Nhập phần ảo của số phức 1: ");
        double imaginaryPart1 = scanner.nextDouble();

        System.out.println("Nhập phần thực của số phức 2: ");
        double realPart2 = scanner.nextDouble();

        System.out.println("Nhập phần ảo của số phức 2: ");
        double imaginaryPart2 = scanner.nextDouble();

        ComplexNumber complex1 = new ComplexNumber(realPart1, imaginaryPart1);
        ComplexNumber complex2 = new ComplexNumber(realPart2, imaginaryPart2);

        ComplexNumber sum = complex1.add(complex2);
        ComplexNumber difference = complex1.subtract(complex2);
        ComplexNumber product = complex1.multiply(complex2);
        ComplexNumber quotient = complex1.divide(complex2);

        System.out.println("Tổng hai số phức: " + sum);
        System.out.println("Hiệu hai số phức: " + difference);
        System.out.println("Tích hai số phức: " + product);
        System.out.println("Thương hai số phức: " + quotient);
    }
}
