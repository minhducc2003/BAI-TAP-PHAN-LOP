package BAI_7;

import java.util.Scanner;

class Fraction {
    private int tuSo; // tử số
    private int mauSo; // mẫu số

    public Fraction() {
        // hàm tạo không đối
    }

    public Fraction(int tuSo, int mauSo) {
        // hàm tạo 2 đối số
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tử số: ");
        tuSo = scanner.nextInt();
        System.out.print("Nhập mẫu số: ");
        mauSo = scanner.nextInt();
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }

    public void rutGon() {
        int ucln = timUCLN(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
    }

    public int timUCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return timUCLN(b, a % b);
    }

    public Fraction add(Fraction other) {
        int newTuSo = this.tuSo * other.mauSo + this.mauSo * other.tuSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Fraction(newTuSo, newMauSo);
    }

    public Fraction subtract(Fraction other) {
        int newTuSo = this.tuSo * other.mauSo - this.mauSo * other.tuSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Fraction(newTuSo, newMauSo);
    }

    public Fraction multiply(Fraction other) {
        int newTuSo = this.tuSo * other.tuSo;
        int newMauSo = this.mauSo * other.mauSo;
        return new Fraction(newTuSo, newMauSo);
    }

    public Fraction divide(Fraction other) {
        int newTuSo = this.tuSo * other.mauSo;
        int newMauSo = this.mauSo * other.tuSo;
        return new Fraction(newTuSo, newMauSo);
    }
}

public class Main {
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction();
        fraction1.input();
        System.out.println("Phân số 1: " + fraction1);

        Fraction fraction2 = new Fraction();
        fraction2.input();
        System.out.println("Phân số 2: " + fraction2);

        fraction1.rutGon();
        fraction2.rutGon();

        System.out.println("Phân số 1 sau khi rút gọn: " + fraction1);
        System.out.println("Phân số 2 sau khi rút gọn: " + fraction2);

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Tổng: " + sum);

        Fraction difference = fraction1.subtract(fraction2);
        System.out.println("Hiệu: " + difference);

        Fraction product = fraction1.multiply(fraction2);
        System.out.println("Tích: " + product);

        Fraction quotient = fraction1.divide(fraction2);
        System.out.println("Thương: " + quotient);
    }
}
