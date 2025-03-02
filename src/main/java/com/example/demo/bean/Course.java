package com.example.demo.bean;

public class Course {
    private int courseid;
    private String coursename;

    public Course() {}

    public Course(String coursename) {
        this.coursename = coursename;
    }

    public Course(int courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    public int getCourseid() {
        return courseid;
    }

    public  void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
}
