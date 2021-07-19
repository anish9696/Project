package com.Project.DocumentDao;

import java.util.Date;

public class UserDtoImpl implements UserDto{

    private Long id;
    private String username;
    private String passwordHash;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String fileName;
    private Date birthDate;

    public UserDtoImpl(Long id, String username, String passwordHash, String firstName, String lastName, String email, String phoneNumber, String fileName, Date birthDate) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.fileName = fileName;
        this.birthDate = birthDate;
    }

    public UserDtoImpl(String userName, String password, String firstName, String lastName, String phoneNumber, String email, String fileName, Date date) {
        this.username = userName;
        this.passwordHash = password;
        this.firstName =firstName;
        this.lastName = lastName;
        this.phoneNumber =phoneNumber;
        this.email = email;
        this.fileName =fileName;
        this.birthDate =date;
    }

    @Override
    public Long getId() {
        return null;
    }

    public void setId(Long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
