package Project_A;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dim
 */
public class StudentsOfCourse {
    private Course course;
    private ArrayList<Student> students;
    
    public StudentsOfCourse(Course course){
        this.course = course;
        students = new ArrayList();
    }
    
    public void addStudent(Student student){
        students.add(student);
    }
    
    public String getCourseTitle(){
        return course.getTitle();
    }
    
    public Course getCourse(){
        return course;
    }
    
    public ArrayList<Student> getAllStudents(){
        return students;
    }
    
    
}
