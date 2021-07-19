package com.Project.Entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String username;
    //@Column(name = "password_hash")
    private String passwordHash;
    //@Column(name ="first_name")
    private String firstName;
    //@Column(name ="last_name")
    private String lastName;
    //@Column(name ="phone_number")
    private String phoneNumber;


    //@Column()
    private String email;

    public User() {
        super();
    }

    //@Column
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    //@Temporal(TemporalType.DATE)
    private Date born;

   /* @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name ="user_role",joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name ="role_id"))
    private List<Note> roles;*/
    //@Column(name = "file_Name")
    private String fileName;


    public User(String id,Date born, String email, String fileName, String firstName, String lastName, String passwordHash, String phoneNumber, String username) {
        this.id = id;
        this.born =born;
        this.email = email;
        this.fileName =fileName;
        this.firstName =firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.phoneNumber = phoneNumber;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", born=" + born +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }
}
