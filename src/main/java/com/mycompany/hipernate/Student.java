package com.mycompany.hipernate;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")

public class Student {


    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

            @Column(name = "id")
    int id;
    @Column(name = "first_name")

    String firstName;
    @Column(name = "last_name")

    String lastName;
    @Column(name = "email")

    String email;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course>  courses;


    public void  addcourse(Course course) {
        if (course==null) {
            courses=new ArrayList<>();
            courses.add(course);


        }

    }


    public void addcourses(List<Course> coursesToAdd) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.addAll(coursesToAdd);
    }



    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
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
