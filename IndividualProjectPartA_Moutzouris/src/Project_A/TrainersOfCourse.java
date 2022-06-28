/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_A;

import java.util.ArrayList;

/**
 *
 * @author dim
 */
public class TrainersOfCourse {
    private Course course;
    private ArrayList<Trainer> trainers;
    
    public TrainersOfCourse(Course course){
        this.course = course;
        trainers = new ArrayList();
    }
    
    public void addTrainer(Trainer trainer){
        trainers.add(trainer);
    }
    
    public String getCourseTitle(){
        return course.getTitle();
    }
    
    public Course getCourse(){
        return course;
    }
    
    public ArrayList<Trainer> getAllTrainers(){
        return trainers;
    }
}
