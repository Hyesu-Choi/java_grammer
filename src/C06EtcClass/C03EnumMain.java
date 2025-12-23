package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {
        Object a = new String("hello"); // Object는 모든 타입의 조상 클래스임. 타입 애매할때 object하면 다 먹힌댜

//        ClassGrade를 일반문자열로 설계했을 경우 -> 데이터 종류에 대한 통제 불가
//        Student s1 = new Student("h1", "FIRST_GRADE");
//        Student s2 = new Student("h2", "first_grade");
//        Student s3 = new Student("h3", "1학년");

//        static final 변수로 설계했을 경우
//        Student s1 = new Student("h1", ClassGrade.c1);
//        Student s2 = new Student("h2", ClassGrade.c2);
//        Student s3 = new Student("h3", "1학년");  // 학년은 string으로 선언되어 있어서 final 변수여도 들어감.

//        ClassGrade를 Enum 클래스로 설계했을 경우
        Student s1 = new Student("h1", ClassGrade.FIRST_GRADE);  // 문자 넣고 싶어도 못넣음.
        Student s2 = new Student("h2", ClassGrade.SECOND_GRADE);
        Student s3 = new Student("h3", ClassGrade.THIRD_GRADE);
        System.out.println(s1);  //{name='h1', classGrade='FIRST_GRADE'}
    }
}

// class ClassGrade{
//    static final String c1="FIRST_GRADE";
//    static final String c2="SECOND_GRADE";
//    static final String c3="THIRD_GRADE";
//}

// enum 클래스는 데이터의 종류를 하나의 enum명 아래 묶는것.
enum ClassGrade{
//    enum의 변수값은 static final 변수처럼 사용
    FIRST_GRADE, SECOND_GRADE, THIRD_GRADE
}

class Student {
    private String name;
//    private String classGrade; // 학년 : FIRST_GRADE, SECOND_GRADE, THIRD_GRADE 만 있다고 가정.
    private ClassGrade classGrade;

    public Student(String name, ClassGrade classGrade) {
//    public Student(String name, String classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", classGrade='" + classGrade + '\'' +
                '}';
    }
}
