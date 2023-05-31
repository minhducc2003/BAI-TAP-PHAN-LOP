package BAI_6;

import java.util.Scanner;

class rectangle{
    private double chieu_dai;
    private double chieu_rong;

    public double getChieu_dai() {
        return chieu_dai;
    }

    public void setChieu_dai(double chieu_dai) {
        this.chieu_dai = chieu_dai;
    }

    public double getChieu_rong() {
        return chieu_rong;
    }

    public void setChieu_rong(double chieu_rong) {
        this.chieu_rong = chieu_rong;
    }
    public void inPut(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập chiều dài : ");
            chieu_dai = scanner.nextDouble();
            System.out.print("Nhập chiều rộng : ");
            chieu_rong  = scanner.nextDouble();
            if (chieu_rong < 0 || chieu_dai < 0){
                System.out.println("Vui lòng nhập giá trị lớn hơn 0 ");
            }
        }while (chieu_rong < 0 || chieu_dai < 0);
    }
    public double dien_tich(){
        double s = chieu_dai * chieu_rong;
        return s;
    }
    public double chu_vi(){
        double p = (chieu_dai + chieu_rong) * 2;
        return p;
    }
}
public class Main {
    public static void main(String[] args) {
        rectangle cn = new rectangle();
        cn.inPut();
        System.out.println("Diện tích :  " + cn.dien_tich());
        System.out.println("Chu vi : " + cn.chu_vi());
    }
}
