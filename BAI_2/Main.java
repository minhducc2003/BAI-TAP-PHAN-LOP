package BAI_2;

import java.util.Scanner;

class student {
    private String studentCode;
    private double midden_score; //điểm trung bình
    private int age;
    private String classRoom;

    public student() {
        studentCode = "";
        midden_score = 0;
        age = 0;
        classRoom = "";
    }

    public student(String studentCode, double midden_score, int age, String classRoom) {
        if (studentCode.length() == 8) {
            this.studentCode = studentCode;
        } else {
            throw new IllegalArgumentException("Mã sinh viên phải có 8 ký tự vui lòng nhập lại");
        }
        if (midden_score >= 0.0 || midden_score <= 10.0) {
            this.midden_score = midden_score;
        } else {
            throw new IllegalArgumentException("Điểm trung bình phải từ 0,0 -> 10,0");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Tuổi phải lớn hơn hoặc bằng 18");
        }
        if (classRoom.startsWith("A") || classRoom.startsWith("C")) {
            this.classRoom = classRoom;
        } else {
            throw new IllegalArgumentException("Phòng học phải bắt đầu bằng ký tự 'A' hoặc 'C'");
        }
    }


    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        if (studentCode.length() == 8) {
            this.studentCode = studentCode;
        }
    }

    public double getMidden_score() {
        return midden_score;
    }

    public void setMidden_score(double midden_score) {
        if (midden_score >= 0.0 || midden_score <= 10.0) {
            this.midden_score = midden_score;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        }
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        if (classRoom.startsWith("A") || classRoom.startsWith("C")) {
            this.classRoom = classRoom;
        }
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập mã Sinh viên : ");
            studentCode = scanner.nextLine();

            if (studentCode.length() != 8) {
                throw new IllegalArgumentException("Vui lòng nhập mã sinh viên có độ dài bằng 8");
            }

            System.out.print("Nhập điểm trung bình : ");
            midden_score = scanner.nextDouble();

            if (midden_score <= 0 || midden_score >= 10) {
                throw new IllegalArgumentException("Vui lòng nhập điểm trung bình (0.0 < ");
            }
            System.out.print("Nhập tuổi : ");
            age = scanner.nextInt();

            if (age < 18) {
                throw new IllegalArgumentException("Vui lòng nhập tuổi lớn hơn 18");
            }
            scanner.nextLine();
            System.out.print("Nhập lớp học : ");
            classRoom = scanner.nextLine();

            if (!classRoom.startsWith("A") && !classRoom.startsWith("C")) {
                throw new IllegalArgumentException("Vui lòng nhập lớp học bắt đầu từ ký tự 'A' hoặc 'C' ");
            }


        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Lỗi " + e.getMessage());
        }
    }

    public void outPut() {
        System.out.println("Mã sinh viên : " + studentCode);
        System.out.println("Điểm trung bình : " + midden_score);
        System.out.println("Tuổi : " + age);
        System.out.println("Lớp học " + classRoom);
    }

    public void scholarship_calculte() {
        if (midden_score > 8) {
            System.out.println("Được học bổng");
        } else {
            System.out.println("Không được học bổng");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        student sv = new student();
        sv.inputInfo();
        sv.outPut();
        sv.scholarship_calculte();
    }
}