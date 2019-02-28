package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ClassroomTest {

    @Test
    public void constructorTest(){
        Classroom classroom = new Classroom();
        Student[] expected = new Student[30];
        Student[] actual = classroom.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        Classroom classroom = new Classroom(20);
        Student[] expected = new Student[20];
        Student[] actual = classroom.getStudents();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void constructorTest3(){
        Double[] exams = {20.0};
        Student student1 = new Student("Will", "Xu", exams);
        Student student2 = new Student("Wil", "Xu", exams);
        Student student3 = new Student("Wi", "Xu", exams);
        Student[] students = {student1, student2, student3};
        Classroom classroom = new Classroom(students);
        Student[] actual = classroom.getStudents();

        Assert.assertArrayEquals(students, actual);
    }

    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Double expected = 125.0;
        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        classroom.clear();
        Double[] examScores = { 100.0, 150.0, 250.0, 0.00 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        String expected1 = "[null]";
        String expected2 = "[Student Name: Leon Hunter\n" +
                "Average Score: 125\n" +
                "Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 150\n" +
                " \tExam 3 -> 250\n" +
                " \tExam 4 -> 0\n]";

        Assert.assertEquals(expected1, preEnrollmentAsString);
        Assert.assertEquals(expected2, postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        classroom.removeStudent("Leon", "Hunter");
        Student[] postRemoval = classroom.getStudents();


        // Then
        String postRemovalAsString = Arrays.toString(postRemoval);

        String expected1 = "[]";
        String expected2 = "[Student Name: Leon Hunter\n" +
                "Average Score: 125\n" +
                "Exam Scores:\n" +
                " \tExam 1 -> 100\n" +
                " \tExam 2 -> 150\n" +
                " \tExam 3 -> 250\n" +
                " \tExam 4 -> 0\n]";

        Assert.assertEquals(expected1, postRemovalAsString);
        Assert.assertEquals(expected2, postEnrollmentAsString);
    }

    @Test
    public void getStudentsByScoreTest(){
        // : Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 100.0, 150.0, 250.0, 100.0 };
        Double[] examScores3 = { 90.0, 150.0, 250.0, 20.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student2 = new Student("Will", "Xu", examScores2);
        Student student3 = new Student("Grace", "Bell", examScores3);

        // When
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        Student[] expected2 = {student, student2, student3};
        Student[] actual2 = classroom.getStudents();

        Student[] expected = {student, student3, student2};
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertArrayEquals(expected, actual);
        Assert.assertArrayEquals(expected2, actual2);
    }

    @Test
    public void getGradeBookTest(){
        // : Given
        int maxNumberOfStudents = 3;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] examScores2 = { 100.0, 150.0, 250.0, 100.0 };
        Double[] examScores3 = { 90.0, 150.0, 250.0, 20.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student student2 = new Student("Will", "Xu", examScores2);
        Student student3 = new Student("Grace", "Bell", examScores3);

        // When
        classroom.addStudent(student);
        classroom.addStudent(student2);
        classroom.addStudent(student3);

        Student[] expected = {student, student3, student2};
        Student[] actual = classroom.getStudentsByScore();

        HashMap<Student, String> expected2 = new HashMap<>();
        expected2.put(student, "D");
        expected2.put(student3, "C");
        expected2.put(student2, "A");

        HashMap<Student, String> actual2 = classroom.getGradeBook();

        Assert.assertArrayEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }



}
