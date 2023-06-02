package BAI_11;

import java.util.Scanner;

class Matrix {
    private int rows; // số hàng của ma trận
    private int columns; // số cột của ma trận
    private int[][] data; // dữ liệu của ma trận

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Nhập giá trị cho phần tử [" + i + "][" + j + "]: ");
                int value = scanner.nextInt();
                data[i][j] = value;
            }
        }
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Kích thước hai ma trận không phù hợp");
        }

        Matrix result = new Matrix(rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Kích thước hai ma trận không phù hợp");
        }

        Matrix result = new Matrix(rows, other.columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }

        return result;
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng của ma trận 1: ");
        int rows1 = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận 1: ");
        int columns1 = scanner.nextInt();
        Matrix matrix1 = new Matrix(rows1, columns1);
        matrix1.input();

        System.out.print("Nhập số hàng của ma trận 2: ");
        int rows2 = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận 2: ");
        int columns2 = scanner.nextInt();
        Matrix matrix2 = new Matrix(rows2, columns2);
        matrix2.input();

        System.out.println("Ma trận 1:");
        matrix1.display();
        System.out.println("Ma trận 2:");
        matrix2.display();

        Matrix sum = matrix1.add(matrix2);
        System.out.println("Tổng hai ma trận:");
        sum.display();

        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Tích hai ma trận:");
        product.display();

        scanner.close();
    }
}

