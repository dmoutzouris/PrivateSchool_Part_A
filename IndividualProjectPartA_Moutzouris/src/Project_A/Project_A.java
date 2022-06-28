/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project_A;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author dim
 */
public class Project_A {
    private static ArrayList<Trainer> trainers = new ArrayList();
    private static ArrayList<Student> students = new ArrayList();
    private static ArrayList<Assignment> assignments = new ArrayList();
    private static ArrayList<Course> courses = new ArrayList();
    private static ArrayList<StudentsOfCourse> studentsOfCourses = new ArrayList();
    private static ArrayList<TrainersOfCourse> trainersOfCourses = new ArrayList();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("*** Menu ***");
            System.out.println("1. new student");
            System.out.println("2. new trainer");
            System.out.println("3. new assignment");
            System.out.println("4. new course");
            System.out.println("5. add trainer to course");
            System.out.println("6. add assignment to course");
            System.out.println("7. add student to course");
            System.out.println("8. list students ");
            System.out.println("9. list trainers ");
            System.out.println("10. list assignments ");
            System.out.println("11. list courses ");
            System.out.println("12. list students per course");
            System.out.println("13. list trainers per course");
            System.out.println("0. Exit");
            
            System.out.println("> Enter choice: ");
            choice = input.nextInt();
            
            switch (choice){
                case 1: addStudent(); break;
                case 2: addTrainer(); break;  
                case 3: addAssignment(); break; 
                case 4: addCourse(); break; 
                case 5: addTrainerToCourse(); break; 
                case 6: addAssignmentToCourse(); break; 
                case 7: addStudentToCourse(); break; 
                case 8: 
                    System.out.println("Students:");
                    listStudents();
                    break; 
                case 9: 
                    System.out.println("Trainers:");
                    listTrainers();
                    break; 
                case 10: 
                    System.out.println("Assignments:");
                    listAssignments();
                    break; 
                case 11: 
                    System.out.println("Courses:");
                    listCourses();
                    break; 
                case 12: listStudentsPerCourses(); break; 
                case 13: listTrainersPerCourses(); break; 
            }
        } while (choice != 0);
        
    }
    
    private static void listTrainersPerCourses(){
        if (trainersOfCourses == null){
            System.out.println("No trainers in any course!");
            return;
        }
        
        for (TrainersOfCourse toc : trainersOfCourses){
            System.out.println("Course: " + toc.getCourseTitle());
            ArrayList<Trainer> trainers = toc.getAllTrainers();
            for (Trainer trainer : trainers){
                System.out.println("  :: " + trainer.getFirstName() + " " + trainer.getLastName());
            }
        }
        System.out.println("");
    }
    
    private static void listStudentsPerCourses(){
        if (studentsOfCourses == null){
            System.out.println("No students in any course!");
            return;
        }
        
        for (StudentsOfCourse soc : studentsOfCourses){
            System.out.println("Course: " + soc.getCourseTitle());
            ArrayList<Student> students = soc.getAllStudents();
            for (Student student : students){
                System.out.println("  :: " + student.getFirstName() + " " + student.getLastName());
            }
        }
        System.out.println("");
    }
    
    
    
    private static void addStudentToCourse(){
        Scanner input = new Scanner(System.in);
        String another;
        Course course;
        Student student;
        StudentsOfCourse studentOfCourse;
        
        if (courses.isEmpty()){
            System.out.println("No courses exist!");
            return;
        }
        
        if (students.isEmpty()){
            System.out.println("No students exist!");
            return;
        }
        
        do{
            System.out.println("Choose course");
            course = pickCourse();
            
            System.out.println("Choose student");
            student = pickStudent();
            
            course.addStudent(student);
            
            studentOfCourse = null;
            for (StudentsOfCourse sof : studentsOfCourses){
                if (sof.getCourse() == course){
                    studentOfCourse = sof;
                    break;
                }
            }
            
            if (studentOfCourse == null){
                studentOfCourse = new StudentsOfCourse(course);
                studentsOfCourses.add(studentOfCourse);
            }
            
            studentOfCourse.addStudent(student);
            
            
            System.out.println("Student added to course, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));   
        
    }
    
    private static void listStudents(){
        int c = 0;
        
        if (students.isEmpty()){
            System.out.println("No students available!");
        }
        else{
            for (Student student: students){
                c++;
                System.out.println(c + ". " + student.getFirstName() + " " + student.getLastName());
            }
        }
    }
    
    private static Student pickStudent(){
        Scanner input = new Scanner(System.in);
        Student student;
        int n;
        
        if (students.isEmpty()){
            System.out.println("No student available!");
            return null;
        }
        
        do{
            System.out.println("\n\nThe students are:");
            listStudents();
         
            System.out.println("Enter student number: ");
            n = input.nextInt();
        } while (n < 1 || n > students.size());
        
        n--;
        
        return students.get(n);
    }
    
    private static void addAssignmentToCourse(){
        Scanner input = new Scanner(System.in);
        String another;
        Course course;
        Assignment assignment;
        
        if (assignments.isEmpty()){
            System.out.println("No assignments exist to assign!");
            return;
        }
        
        if (courses.isEmpty()){
            System.out.println("No courses exist!");
            return;
        }
        
        do{
            System.out.println("Choose course");
            course = pickCourse();
            
            System.out.println("Choose assignment");
            assignment = pickAssignment();
            
            course.addAssignment(assignment);
        
            System.out.println("Assignment added to course, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));   
        
    }
    
    private static void addTrainerToCourse(){
        Scanner input = new Scanner(System.in);
        String another;
        Course course;
        Trainer trainer;
        TrainersOfCourse trainerOfCourse;
        
        if (courses.isEmpty()){
            System.out.println("No courses exist!");
            return;
        }
        
        if (trainers.isEmpty()){
            System.out.println("No trainers exist!");
            return;
        }
        
        do{
            System.out.println("Choose course");
            course = pickCourse();
            
            System.out.println("Choose trainer");
            trainer = pickTrainer();
            
            course.addTrainer(trainer);
            
            trainerOfCourse = null;
            for (TrainersOfCourse toc: trainersOfCourses){
                if (toc.getCourse() == course){
                    trainerOfCourse = toc;
                    break;
                }
            }
            
            if (trainerOfCourse == null){
                trainerOfCourse = new TrainersOfCourse(course);
                trainersOfCourses.add(trainerOfCourse);
            }
            
            
            trainerOfCourse.addTrainer(trainer);
            
            
            System.out.println("Trainer added to coures, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));   
        
    }
    
    private static void addCourse(){
        Scanner input = new Scanner(System.in);
        String title, stream, type, another;
        String start_date_string, end_date_string; 
        LocalDateTime subDateTime;
        Course newCourse;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        
        do{
            System.out.println("Title: ");
            title = input.next();

            System.out.println("Stream: ");
            stream = input.next();
            
            System.out.println("Type: ");
            type = input.next();

            System.out.println("Start date time: ");
            start_date_string = input.next();

            System.out.println("End date time: ");
            end_date_string = input.next();
            
            newCourse = new Course();
            
            newCourse.setTitle(title);
            newCourse.setStream(stream);
            newCourse.setType(type);
            newCourse.setStart_date(LocalDate.parse(start_date_string, formatter));
            newCourse.setEnd_date(LocalDate.parse(end_date_string, formatter));
            
            courses.add(newCourse);
        
            System.out.println("Course added, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));    
    }
    
    private static void listCourses(){
        int c = 0;
        
        if (courses.isEmpty()){
            System.out.println("No courses available!");
        }
        else{
            for (Course course : courses){
                c++;
                System.out.println(c + ". " + course.getTitle());
            }
        }
    }
    
    private static void listTrainers(){
        int c = 0;
        
        if (trainers.isEmpty()){
            System.out.println("No trainers available!");
        }
        else{
            for (Trainer trainer : trainers){
                c++;
                System.out.println(c + ". " + trainer.getFirstName() + " " + trainer.getLastName() + " (" + trainer.getSubject() + ")");
            }
        }
    }
    
    private static void listAssignments(){
        int c = 0;
        
        if (assignments.isEmpty()){
            System.out.println("No assignment available!");
        }
        else{
            for (Assignment assignment : assignments){
                c++;
                System.out.println(c + ". " + assignment.getTitle());
            }
        }
    }
    
    private static Assignment pickAssignment(){
        Scanner input = new Scanner(System.in);
        Assignment assignment;
        int n;
        
        if (assignments.isEmpty()){
            System.out.println("No assignment available!");
            return null;
        }
        
        do{
            System.out.println("\n\nThe assignments are:");
            listAssignments();
         
            System.out.println("Enter assignment number: ");
            n = input.nextInt();
        } while (n < 1 || n > assignments.size());
        
        n--;
        
        return assignments.get(n);
    }
    
    private static Trainer pickTrainer(){
        Scanner input = new Scanner(System.in);
        Trainer trainer;
        int n;
        
        if (trainers.isEmpty()){
            System.out.println("No trainers available!");
            return null;
        }
        
        do{
            System.out.println("\n\nThe trainers are:");
            listTrainers();
          
            System.out.println("Enter trainer number: ");
            n = input.nextInt();
        } while (n < 1 || n > trainers.size());
        
        n--;
        
        return trainers.get(n);
    }
    
    private static Course pickCourse(){
        Scanner input = new Scanner(System.in);
        Course course;
        int n;
        
        if (courses.isEmpty()){
            System.out.println("No courses available!");
            return null;
        }
        
        do{
            System.out.println("\n\nThe courses are:");
            listCourses();
            System.out.println("Enter course number: ");
            n = input.nextInt();
        } while (n < 1 || n > courses.size());
        
        n--;
        
        return courses.get(n);
    }
    
    private static void addAssignment(){
        Scanner input = new Scanner(System.in);
        String title, description, subDateTimeString, another;
        int oralMark, totalMark; 
        LocalDateTime subDateTime;
        Assignment newAssignment;
        Course course;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        
        do{
            System.out.println("Choose course of the assignment");
            course = pickCourse();
            
            
            System.out.println("Title: ");
            title = input.next();

            System.out.println("Description: ");
            description = input.next();

//            System.out.println("sub date time: ");
//            subDateTimeString = input.next();
            
            newAssignment = new Assignment();
            
            newAssignment.setTitle(title);
            newAssignment.setDescription(description);
            
            assignments.add(newAssignment);
        
            if (course != null) {
                course.addAssignment(newAssignment);
                System.out.println("Assignment added to course, add another? (Y/N)");
            }
            else {
                System.out.println("Assignment added (to no course), add another? (Y/N)");
            }
            
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));    
    }
    
    private static void addStudent(){
        Scanner input = new Scanner(System.in);
        String firstName, lastName;
        String dob, another;
        LocalDate dateOfBirth;
        int tuitionFees;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        
        do{
            System.out.println("Name: ");
            firstName = input.next();

            System.out.println("Surname: ");
            lastName = input.next();

            System.out.println("Date of birth (eg 12/12/2000): ");
            dob = input.next();

            System.out.println("Tuition fees: ");
            tuitionFees = input.nextInt();


            dateOfBirth = LocalDate.parse(dob, formatter);

            students.add(new Student(firstName, lastName, dateOfBirth, tuitionFees));
        
            System.out.println("Student added, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));    
    }
   
    private static void addTrainer(){
        Scanner input = new Scanner(System.in);
        String firstName, lastName;
        String subject, another;
        
        do{
            System.out.println("Name: ");
            firstName = input.next();

            System.out.println("Surname: ");
            lastName = input.next();

            System.out.println("Subject: ");
            subject = input.next();
            
            
            trainers.add(new Trainer(firstName, lastName, subject));
        
            System.out.println("Trainer added, add another? (Y/N)");
            another = input.next();
            
        }while (another.equalsIgnoreCase("y"));    
        
    }
    
}
