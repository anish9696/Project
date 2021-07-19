package com.Project.DocumentDao;

import java.util.Date;

public interface UserDto {
    Long getId();
    void setId(Long id);
    String getUsername();
    void setUsername(String username);
    String getPasswordHash();
    void setPasswordHash(String passwordHash);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getEmail();
    void setEmail(String email);
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
    String getFileName();
    void setFileName(String fileName);
    Date getBirthDate();
    void setBirthDate(Date birthDate);
}
