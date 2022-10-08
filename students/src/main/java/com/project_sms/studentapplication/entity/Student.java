package com.project_sms.studentapplication.entity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GenericGenerator(name = "roll_no", strategy = "com.project_sms.studentapplication.repository.ClientIdGenerator")
    @GeneratedValue(generator = "roll_no")
    @Column(name="roll_no")
    private String rollNum;
    @Column(name="firstname" , nullable = false)
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="city")
    private String city;

    public Student(){}

    public Student(String firstName, String lastName, String email, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }

    public String getId() {
        return rollNum;
    }

    public void setId(String id) {
        this.rollNum = rollNum;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
