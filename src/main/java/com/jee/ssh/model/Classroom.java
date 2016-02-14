package com.jee.ssh.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZSt on 2016/2/14.
 */

@Entity
@Table(name = "classroom")
public class Classroom {

    private int id;
    private String name;
    private int grade;
    private Set<Student> students;
    private Special special;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @OneToMany(mappedBy = "classroom")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToOne
    @JoinColumn(name = "special_id")
    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }
}
