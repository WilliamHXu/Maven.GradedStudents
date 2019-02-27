package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName, Double[] examScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        return examScores.size();
    }

    public String getExamScores(){
        String scores = "Exam Scores:\n";
        for (int i = 0; i < examScores.size(); i++){
            scores += " \tExam " + (i+1) + " -> " + examScores.get(i).intValue() + "\n";
        }
        return scores;
    }

    public void addExamScore(Double examScore){
        examScores.add(examScore);
    }

    public void setExamScores(int examNumber, Double newScore) {
        examScores.remove(examNumber-1);
        examScores.add(examNumber-1, newScore);
    }

    public Double getAverageExamScore(){
        Double sum = 0.0;
        for (Double score : examScores){
            sum += score;
        }
        return sum/examScores.size();
    }

    public String toString(){
        String string = "Student Name: " + firstName + " " + lastName + "\n" +
                "Average Score: " + getAverageExamScore().intValue() + "\n" +
                getExamScores();
        return string;
    }

}
