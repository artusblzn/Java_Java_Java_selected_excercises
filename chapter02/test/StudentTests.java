package chapter02.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chapter02.Student;


public class StudentTests {

    private Student joeDoe = new Student(1, "Joe Doe");;

    @BeforeEach
    public void init() {
        double[] grades = {5.0, 8.0, 10.0, 7.0, 2.0};

        this.joeDoe.setQuizGrades(grades);
        this.joeDoe.setExamGrades(Arrays.copyOfRange(grades, 0, 3));
        this.joeDoe.setExerciseGrades(Arrays.copyOfRange(grades, 0, 2));
    }

    @Test
    public void testCalculateAverageGrade() {

        assertEquals(this.joeDoe.calculateAverageGrade(), 6.8);
    }

}
