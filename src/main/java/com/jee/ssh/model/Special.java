package com.jee.ssh.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ZSt on 2016/2/14.
 */

@Entity
@Table(name = "special")
public class Special {

    private int id;
    private String name;
    private String type;
    private Set<Classroom> classrooms;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @OneToMany(mappedBy = "special")
    @LazyCollection(LazyCollectionOption.EXTRA)
    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
