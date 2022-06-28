/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_A;

import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author dim
 */
public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    
    private ArrayList<Trainer> trainers;
    private ArrayList<Student> students;
    private ArrayList<Assignment> assignments;
    
    public Course(){
        trainers = new ArrayList();
        students = new ArrayList();
        assignments = new ArrayList();
    }
    
    public void addTrainer(Trainer trainer){
        trainers.add(trainer);
    }
    
    public void addStudent(Student student){
        students.add(student);
    }
    
    public void addAssignment(Assignment assignment){
        assignments.add(assignment);
    }

    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }
    
    
}
