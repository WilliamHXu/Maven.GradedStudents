package io.zipcoder;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAverageExamScore().compareTo(student2.getAverageExamScore());
    }
}
