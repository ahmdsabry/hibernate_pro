package com.mycompany.hipernate;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "course")
public class Course {



    @Id
            @GeneratedValue(strategy =  GenerationType.IDENTITY)
            @Column(name = "id")
    int id;
    @Column(name = "title")

    String title;



    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinTable(name = "course_student",joinColumns = @JoinColumn(name = "course_id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    List<Student> students;


    public void  addStudent(Student student2) {
        if (student2==null) {
            students=new ArrayList<>();

            students.add(student2);

        }



    }

    @ManyToOne
      @JoinColumn( name = "instructor_id")


    Instructor instructor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course() {

    }

    public Course( String title) {

        this.title = title;
    }

    public Course(int id, String title, Instructor instructor) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
    }

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }


}
