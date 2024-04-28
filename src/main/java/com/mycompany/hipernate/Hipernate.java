/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hipernate;

 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author BM
 */


public class Hipernate {

    public static void main(String[] args) {
        
        
        
  SessionFactory sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Instructor.class).addAnnotatedClass(Student.class).
        addAnnotatedClass(instructordetail.class) // Assuming this is the correct class name for InstructorDetail
          .addAnnotatedClass(Course.class).buildSessionFactory();

Session session = sessionFactory.openSession();

try {
    // Start a transaction
    session.beginTransaction();

    
//    instructordetail d=new instructordetail( "youtube", "play");
//
//    Instructor instructor=new Instructor("ahmed", "sabry", "ahm@gmail.com", d);

//
//    Instructor instructorToUpdate = session.get(Instructor.class, 4);
//
//
//    session.remove(instructorToUpdate);
//
//    session.getTransaction().commit();


//    instructordetail instructorToUpdate = session.get(instructordetail.class, 2);
//
//
//    System.out.println(instructorToUpdate);


    //many to many from course to add student
    Instructor instructor=session.get(Instructor.class, 8);

    Course course=new Course("php",instructor);


    //System.out.println(instructor.getCourses());


    //  Student student=new Student("ahmed","ali","ahmed@gmail.com");


    Student student1=session.get(Student.class,1);


    Student student=new Student("ahmed","ali","as@gmail.com");


    course.addStudent(student1);

    session.persist(course);

////many to many from student to add course
//    Instructor instructor=session.get(Instructor.class, 8);
//    //System.out.println(instructor.getCourses());
//
//    //  Student student=new Student("ahmed","ali","ahmed@gmail.com");
//
//    Student student1=session.get(Student.class,1);
//
//List<Course> courses=new ArrayList<>(Arrays.asList(new Course("jv2",instructor),new Course("jv22",instructor)));
//
//student1.addcourses(courses);
//
//    session.persist(student1);


//
//     Instructor instructor=session.get(Instructor.class, 8);
//    //System.out.println(instructor.getCourses());
//
//    Student student=new Student("ahmed","ali","ahmed@gmail.com");
//
//
//
//    Course course=new Course("orm relations",instructor);
//
//    student.addcourse(course);
////    Course course2=new Course("typescript",instructor);
////    Course course3=new Course("udemy",instructor);
////
////
//
//     session.persist(student);

    System.out.println("inserted");

//
//
//
//
//    session.persist(course2);
//    session.persist(course3);

    session.getTransaction().commit();


//    // Retrieve the instructor you want to update
//    Instructor instructorToUpdate = session.get(Instructor.class, 1);
//
//    // Update the instructor's properties
//    System.out.print(instructorToUpdate);
//  
//
//    // Commit the transaction to save the changes to the database
//    session.getTransaction().commit();
            
            
//update
//            in.setId(1); // Setting the ID for demonstration purposes
//            int instructorId = in.getId();
//
//            session.beginTransaction();
//            Instructor instructorToUpdate = session.get(Instructor.class, instructorId);
//            instructorToUpdate.setEmail("ahmd@example.com");
//            session.getTransaction().commit();





            //delete

//            session.beginTransaction();
//            Instructor instructorToDelete = session.get(Instructor.class, instructorId); // Load the instructor object
//            session.delete(instructorToDelete); // Delete the instructor
//            session.getTransaction().commit();



//
//            session.beginTransaction();
//            List<Instructor> instructors = session.createQuery("from Instructor where firstName=:firstName", Instructor.class).setParameter("firstName","ahmed").getResultList();
//            session.getTransaction().commit();
//            
//              
//            for (Instructor instructor : instructors) {
//                // Print instructor details in table format
//                System.out.printf("| %-18s | %-10s | %-9s |\n", instructor.getEmail(), instructor.getFirstName(), instructor.getLastName());
//            }
//
//
//
//
//            // Save the employee
//            session.persist(in);
//
//            // Print success message
//            System.out.println("Instructor update successfully!");

        } finally {
            // Close session and session factory
            session.close();
            sessionFactory.close();
        }
    }

    
}
