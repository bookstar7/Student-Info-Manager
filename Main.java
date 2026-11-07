package mngStudentScore;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String stdName;
    private String stdId;
    private String subName;
    private String subScore;

    public Student(String stdName, String stdId, String subName, String subScore){
        this.stdName = stdName;
        this.stdId = stdId;
        this.subName = subName;
        this.subScore = subScore;
    }

    public String getName(){
        return this.stdName;
    }
    public String getId(){
        return this.stdId;
    }
    public String getScore(){
        return this.subScore;
    }
    public String getSubName(){
        return this.subName;
    }

    public void setName(String stdName) {this.stdName = stdName;}
    public void setId(String stdId) {this.stdId = stdId;}
    public void setScore(String subScore){this.subScore = subScore;}
    public void setSubName(String subName){this.subName = subName;}

    @Override
    public String toString(){
        return "이름 : " + this.stdName + "\n학번 : " + this.stdId + "\n과목 : " + this.subName + "\n성적 : " + this.subScore;
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }

    public Student findStudentByName(String name){
        for(Student s : students){
            if(s.getName().equals(name)) return s;
        }
        return null;
    }

    public boolean removeStudentByName(String name){
        Student stdInfo = findStudentByName(name);
        if(stdInfo != null) {students.remove(stdInfo); return true;}
        else return false;
    }

    public boolean modifyStudentByName(String name){
        Student stdInfo = findStudentByName(name);
        if(stdInfo != null) {


            return true;}
        else{ return false;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        StudentManager stdManager = new StudentManager();

        while(true){
            System.out.println("==========학생 성적 관리 프로그램===========");
            System.out.println("학생 정보 추가 a(add)\n학생 정보 조회 f(find)\n학생 정보 수정 m(modify)\n학생 정보 삭제 d(delete)\n종료 e(any)");
            String act = inputData.nextLine();

            if(act.equals("a")){
                System.out.println("학생 이름을 입력하세요.");
                String studentName = inputData.nextLine();
                System.out.println(studentName + "의 학번을 입력하세요.");
                String studentId = inputData.nextLine();
                System.out.println("과목명을 입력하세요.");
                String subjectName = inputData.nextLine();
                System.out.println(studentName + "의 " + subjectName + " 과목 성적을 입력하세요.");
                String subjectScore = inputData.nextLine();
                System.out.println("이름 : " + studentName + "\n학번 : " + studentId + "\n과목명 : " + subjectName + "\n성적 : " + subjectScore + "\n 위의 정보가 맞습니까? (y/n)");
                String answer = inputData.nextLine();

                if(answer.equals("y")) {
                    Student s = new Student(studentName, studentId, subjectName, subjectScore);
                    stdManager.addStudent(s);

                    System.out.println("저장되었습니다.");
                }
                else System.out.println("취소되었습니다.");
            }
            else if (act.equals("m")) {
                System.out.println("수정 할 학생 이름을 입력하세요.");
                String findName = inputData.nextLine();
                Student s = stdManager.findStudentByName(findName);
                if(s!=null){
                    System.out.println("이름 : ");
                    String modName = inputData.nextLine();
                    System.out.println("학번 : ");
                    String modID = inputData.nextLine();
                    System.out.println("과목 : ");
                    String modSub = inputData.nextLine();
                    System.out.println("성적 : ");
                    String modScore = inputData.nextLine();
                    s.setName(modName);
                    s.setId(modID);
                    s.setSubName(modSub);
                    s.setScore(modScore);
                    System.out.println("변경되었습니다.");
                }
                else{
                    System.out.println("존재하지 않는 학생입니다.");
                }
            }
            else if(act.equals("d")){
                System.out.println("삭제 할 학생 이름을 입력하세요.");
                String findName = inputData.nextLine();
                if(stdManager.removeStudentByName(findName)){
                    System.out.println("학생 정보가 삭제되었습니다.");
                }
                else{
                    System.out.println("학생 정보를 찾을 수 없습니다.");
                }
            }
            else if(act.equals("f")){
                System.out.println("조회 할 학생 이름을 입력하세요.");
                String findName = inputData.nextLine();
                Student s = stdManager.findStudentByName(findName);
                if (s==null)
                    System.out.println("학생 정보를 찾을 수 없습니다.");
                else
                    System.out.println(s.toString());

            }
            else{
                System.out.println("프로그램 종료");
                break;
            }

        }
    }
}
