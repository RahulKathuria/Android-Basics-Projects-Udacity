package com.example.android.miwok;

/**
 * Created by Rk on 05-11-2016.
 */
public class ReportCard {
    /**
     * Declaring private variables
     * */
    private String S_grade;

    private int S_marks;

    /**
     * Getting the input for the construtor
     * */
    public ReportCard(int marks , String grade){
            S_marks = marks;
            S_grade = grade;
    }


    /**
     *returning the values
     * @return
     */

    public int getStudentMarks() {
        return S_marks;
    }
    public String getStudentGrade() {
        return S_grade;
    }
    public void setStudentMarks(int marks){
        this.S_marks= marks;

    }
    public void setStudentGrade(String grade) {
        this.S_grade = grade;
    }
    @Override
    public String toString(){
        return "You have scored "+S_marks+"\nhaving "+S_grade;
    }
}
