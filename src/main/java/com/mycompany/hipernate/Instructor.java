/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hipernate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BM
 */

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")

    private String lastName;

    @Column(name = "email")

    private String email;

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    @OneToOne(cascade =  {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn (name = "instructor_detail_id")

    instructordetail instructordetail;


    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
            course.setInstructor(this); // Set the instructor for the course
        }
    }


    public Instructor(String firstName, String lastName, String email, com.mycompany.hipernate.instructordetail instructordetail, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.instructordetail = instructordetail;
        this.courses = courses;
    }

    public com.mycompany.hipernate.instructordetail getInstructordetail() {
        return instructordetail;
    }

    public void setInstructordetail(com.mycompany.hipernate.instructordetail instructordetail) {
        this.instructordetail = instructordetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Instructor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




}
