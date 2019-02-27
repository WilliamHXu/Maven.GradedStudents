package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;


public class StudentTest {


    // Getter Tests
    @Test
    public void getNameTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        String actual = student.getFirstName();
        String actual2 = student.getLastName();

        Assert.assertEquals(firstName, actual);
        Assert.assertEquals(lastName, actual2);
    }

    @Test
    public void getNumberOfExamsTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        Integer expected = 2;
        Integer actual = student.getNumberOfExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        String expected = "Exam Scores:\n" +
                " \tExam 1 -> 70\n" +
                " \tExam 2 -> 100\n";
        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScoreTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        student.addExamScore(95.0);
        String expected = "Exam Scores:\n" +
                " \tExam 1 -> 70\n" +
                " \tExam 2 -> 100\n" +
                " \tExam 3 -> 95\n";

        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScoreTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        student.addExamScore(95.0);
        student.setExamScores(2, 80.0);
        String expected = "Exam Scores:\n" +
                " \tExam 1 -> 70\n" +
                " \tExam 2 -> 80\n" +
                " \tExam 3 -> 95\n";

        String actual = student.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        String newFirstName = "John";
        String newLastName = "Doe";
        student.setFirstName(newFirstName);
        student.setLastName(newLastName);
        String actual = student.getFirstName();
        String actual2 = student.getLastName();

        Assert.assertEquals(newFirstName, actual);
        Assert.assertEquals(newLastName, actual2);
    }

    @Test
    public void toStringTest(){
        Double[] scores = {70.0, 100.0};
        String firstName = "Will";
        String lastName = "Xu";
        Student student = new Student(firstName, lastName, scores);
        String expected = "Student Name: Will Xu\n" +
                "Average Score: 85\n" +
                "Exam Scores:\n" +
                " \tExam 1 -> 70\n" +
                " \tExam 2 -> 100\n";
        String actual = student.toString();

        Assert.assertEquals(expected, actual);
    }


}