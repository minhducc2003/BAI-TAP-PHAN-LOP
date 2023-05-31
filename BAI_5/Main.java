package bai5;

import java.util.Scanner;

class triangle {
    private double a, b, c;

    public void setA(double a) {
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return b;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getC() {
        return c;
    }

    public void inPut() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Nhập a : ");
            a = scanner.nextDouble();
            System.out.print("Nhập b : ");
            b = scanner.nextDouble();
            System.out.print("Nhập c : ");
            c = scanner.nextDouble();
            if (a < 0) {
                System.out.println("Vui lòng nhập a lớn hơn 0 ! ");
            }
            if (b < 0) {
                System.out.println("Vui lòng nhập b lớn hơn 0 ! ");
            }
            if (c < 0) {
                System.out.println("Vui lòng nhập c lớn hơn 0 ! ");
            }
        } while (a < 0 || b < 0 || c < 0);
    }

    public void xac_Dinh_Tam_Giac() {
        if (a == b && b == c) {
            System.out.println("Tam giác đều ");
        }
        if ((a == b && a != c) || (a == c && a != b) || (b == c && c != a)) {
            System.out.println("Tam giác cân ");
        }
        if (a != b && c != c) {
            System.out.println("Tam giác thường ");
        }
    }

    public void chu_Vi_Tam_Giac() {
        double p;
        p = a + b + c;
        System.out.println("Chu vi tam giác là : " + p);
    }

    public double dien_tich_tam_giac() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }


}

public class Main {
    public static void main(String[] args) {
        triangle tg = new triangle();
        tg.inPut();
        tg.xac_Dinh_Tam_Giac();
        tg.chu_Vi_Tam_Giac();
        System.out.println("Diện tích tam giác là: " + tg.dien_tich_tam_giac());

    }
}

