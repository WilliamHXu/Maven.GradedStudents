package io.zipcoder;

import java.util.*;

public class Classroom {
    private Student[] students;

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom(Integer maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom() {
        this(30);
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Student student : students){
            sum += student.getAverageExamScore();
        }
        return sum/students.length;
    }

    public void addStudent(Student student){
        boolean inserted = false;
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = student;
                inserted = true;
                break;
            }
        }
        if (!inserted) {
            Student[] tempArray = Arrays.copyOf(students, students.length + 1);
            tempArray[tempArray.length - 1] = student;
        }
    }

    public void clear(){
        students = new Student[students.length];
    }

    public void removeStudent(String firstName, String lastName){
        ArrayList<Student> newStudents = new ArrayList<>();
        newStudents.addAll(Arrays.asList(students));
        for (Student student : students){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                newStudents.remove(student);
            }
        }
        Student[] returnStudents = new Student[newStudents.size()];
        this.students = newStudents.toArray(returnStudents);
    }

    public Student[] getStudentsByScore(){
        ArrayList<Student> scoredStudents = new ArrayList<>(Arrays.asList(students));
        GradeComparator gradeComparator = new GradeComparator();
        scoredStudents.sort(gradeComparator);
        Student[] students1 = new Student[scoredStudents.size()];
        return scoredStudents.toArray(students1);
    }

    public HashMap<Student, String> getGradeBook(){
        HashMap<Student, String> gradeBook = new HashMap<>();
        Student[] orderedStudents = getStudentsByScore();
        for (int i = 0; i < orderedStudents.length; i++) {
            Double percentile = (double)(i+1)/orderedStudents.length;
            String grade;
            if (percentile > .9){
                grade = "A";
            }
            else if (percentile > .71) {
                grade = "B";
            }
            else if (percentile > .5) {
                grade = "C";
            }
            else if (percentile > .11) {
                grade = "D";
            }
            else {
                grade = "F";
            }
            gradeBook.put(orderedStudents[i], grade);
        }
        return gradeBook;
    }


}
