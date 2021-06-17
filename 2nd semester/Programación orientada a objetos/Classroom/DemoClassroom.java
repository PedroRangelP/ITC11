public class DemoClassroom{
    public static void main(String[] args){
        Student s1 = new Student();
        s1.ID = "A1650101";
        s1.age = 18;
        s1.major = "Industrial Engineering";

        Student s2 = new Student();
        s2.ID = "A1651432";
        s2.age = 19;
        s2.major = "Computer Science";

        Student s3 = new Student();
        s3.ID = "A1650839";
        s3.age = 17;
        s3.major = "Electrical Engineering";

        Classroom c = new Classroom(10);
        c.addStudent(s1);
        c.addStudent(s2);
        c.addStudent(s3);

        System.out.print("Adults ");
        System.out.println(c.countAdults());
        
    }
}