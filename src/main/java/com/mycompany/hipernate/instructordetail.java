/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hipernate;

import jakarta.persistence.*;
import org.hibernate.annotations.GeneratedColumn;

/**
 *
 * @author BM
 */

@Entity
@Table(name="instructor_detail")


public class instructordetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       
   @Column(name="id")
    int id; 
    
    
       @Column(name="youtube_channel")

    String youtubechannel;
    
       
       @Column(name = "hobby")
       String hobby;

    public int getId() {
        return id;
    }


    @OneToOne(cascade =  {CascadeType.ALL},fetch = FetchType.LAZY)
    @JoinColumn (name = "id")

    private Instructor instructor;



    public instructordetail() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubechannel() {
        return youtubechannel;
    }

    public void setYoutubechannel(String youtubechannel) {
        this.youtubechannel = youtubechannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public instructordetail(int id, String youtubechannel, String hobby) {
        this.id = id;
        this.youtubechannel = youtubechannel;
        this.hobby = hobby;
    }

    public instructordetail(String youtubechannel, String hobby) {
        this.youtubechannel = youtubechannel;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "instructordetail{" + "id=" + id + ", youtubechannel=" + youtubechannel + ", hobby=" + hobby + '}';
    }
       
       
       
}
