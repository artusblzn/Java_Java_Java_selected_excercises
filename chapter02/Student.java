/**
 * EXERCISE 2.2 Now suppose the professor in the previous exercise decides to automate the
 * transaction of looking up a student’s grade and has asked you to design a program to perform this
 * task. The program should let a student type in his or her name and ID number and the program then
 * should display his or her grades for the semester, with a final average. Suppose there are five
 * quiz grades, three exams, and two programming exercise grades. Identify the objects in this
 * program and the type of messages that would be passed among them. (Hint: The grades themselves
 * are just data values, not objects.)
 */

/*
 * I decided to not just identify objects but to create part of the actual program. Every student
 * object will have its name, id and three array of grades. As it is just a chapter 2 exercise, I'll
 * not bring more complexity than it is asked for. Another modification is that will not create any
 * user interface and getters because I'm using automated tests.
 */
package chapter02;

import java.util.Arrays;

public class Student {

    private int id;
    private String name;
    private double quizGrades[];
    private double examGrades[];
    private double exerciseGrades[];

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.quizGrades = new double[5];
        this.examGrades = new double[3];
        this.exerciseGrades = new double[2];
    }

    // I know that would be correct to test the parameter length and raise an exception if greater
    // than the array size but let's make it simpler.
    // I don't test if a grade is negative for simplicity matters too.
    public void setQuizGrades(double[] quizGrades) {
        // Note that I clone the array because an Array in Java is and object. Therefore we receive
        // a pointer to that object. The problem here is that we can't control if the array is
        // modified outside our class. Then I copy the Array for security reasons.
        this.quizGrades = quizGrades.clone();

    }

    public void setExamGrades(double[] examGrades) {
        this.examGrades = examGrades.clone();
    }

    public void setExerciseGrades(double[] exerciseGrades) {
        this.exerciseGrades = exerciseGrades.clone();
    }

    public double calculateAverageGrade() {
        double sumOfGrades = Arrays.stream(this.quizGrades).sum()
                + Arrays.stream(this.examGrades).sum() + Arrays.stream(this.exerciseGrades).sum();
        double numOfGrades =
                this.quizGrades.length + this.examGrades.length + this.exerciseGrades.length;

        return sumOfGrades / numOfGrades;
    }


}
