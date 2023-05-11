package BAI_3;
import java.util.Scanner;
class aptech{
    private String checkHDSE;
    private double final_Grade;
    private boolean violate;

    private boolean exams;

    public aptech(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sinh viên có đăng ký khoá học nào ?");
        checkHDSE = scanner.nextLine();

        System.out.println("Nhập điểm tổng kết (0 - 10) : ");
        final_Grade = scanner.nextDouble();

        System.out.println("Sinh viên có vi phạm nội quy trung tâm không ? (true or false)");
        violate = scanner.nextBoolean();

        System.out.println("Sinh viên có thi lại kỳ thi nào không ?");
        exams = scanner.nextBoolean();

        if ((checkHDSE.equals("HDSE")) && (final_Grade >= 7.5) && (violate) && (exams) ) {
            System.out.println("Sinh viên đạt học bổng");
        }
        else {
            System.out.println("Sinh viên không đạt được học bổng");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        aptech sv = new aptech();
    }
}