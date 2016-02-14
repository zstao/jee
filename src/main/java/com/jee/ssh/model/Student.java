package com.jee.ssh.model;

import javax.persistence.*;

/**
 * Created by ZSt on 2016/2/14.
 */

@Entity
@Table(name = "student")
class Student {
    private int id;
    private String name;
    private String sex;
    private Classroom classroom;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
