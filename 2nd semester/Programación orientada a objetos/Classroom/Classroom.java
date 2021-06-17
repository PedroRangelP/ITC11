public class Classroom{
    public int capacity;
    public String subject;
    private Student[] students;
    private int counter;

    public Classroom(int capacity){
        this.capacity = capacity;
        students = new Student[capacity];
    }

    public void addStudent(Student s){
        students[counter] = s;
        counter++;
    }

    public int countAdults(){
        int adults = 0;
        for(int i=0; i<counter; i++){
            if(students[i].age >= 18)
                adults++;
        }
        return adults;
    }
}