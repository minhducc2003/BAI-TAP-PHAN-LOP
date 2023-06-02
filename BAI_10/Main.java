package BAI_10;

import java.util.Scanner;

class Polynomial {
    private int degree; // bậc của đa thức
    private int[] coefficients; // mảng chứa các hệ số của đa thức

    public Polynomial(int degree) {
        this.degree = degree;
        this.coefficients = new int[degree + 1]; // khởi tạo mảng hệ số với độ dài bằng (degree + 1)
    }

    public int getDegree() {
        return degree;
    }

    public int[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficient(int index, int value) {
        coefficients[index] = value;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = degree; i >= 0; i--) {
            System.out.print("Nhập hệ số cho số mũ " + i + ": ");
            int coefficient = scanner.nextInt();
            setCoefficient(i, coefficient);
        }
    }

    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(this.degree, other.degree);
        Polynomial result = new Polynomial(maxDegree);

        for (int i = 0; i <= maxDegree; i++) {
            int thisCoefficient = (i <= this.degree) ? this.coefficients[i] : 0;
            int otherCoefficient = (i <= other.degree) ? other.coefficients[i] : 0;
            result.setCoefficient(i, thisCoefficient + otherCoefficient);
        }

        return result;
    }

    public Polynomial multiply(Polynomial other) {
        int resultDegree = this.degree + other.degree;
        Polynomial result = new Polynomial(resultDegree);

        for (int i = 0; i <= this.degree; i++) {
            for (int j = 0; j <= other.degree; j++) {
                int coefficient = this.coefficients[i] * other.coefficients[j];
                int power = i + j;
                result.coefficients[power] += coefficient;
            }
        }

        return result;
    }

    public void display() {
        for (int i = degree; i >= 0; i--) {
            int coefficient = coefficients[i];
            if (coefficient != 0) {
                if (coefficient > 0 && i != degree) {
                    System.out.print(" + ");
                } else if (coefficient < 0) {
                    System.out.print(" - ");
                    coefficient = Math.abs(coefficient);
                }
                System.out.print(coefficient);
                if (i != 0) {
                    System.out.print("x^" + i);
                }
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập bậc của đa thức 1: ");
        int degree1 = scanner.nextInt();
        Polynomial polynomial1 = new Polynomial(degree1);
        polynomial1.input();

        System.out.print("Nhập bậc của đa thức 2: ");
        int degree2 = scanner.nextInt();
        Polynomial polynomial2 = new Polynomial(degree2);
        polynomial2.input();

        System.out.println("Đa thức 1: ");
        polynomial1.display();
        System.out.println("Đa thức 2: ");
        polynomial2.display();

        Polynomial sum = polynomial1.add(polynomial2);
        System.out.println("Tổng hai đa thức: ");
        sum.display();

        Polynomial product = polynomial1.multiply(polynomial2);
        System.out.println("Tích hai đa thức: ");
        product.display();

        scanner.close();
    }
}

