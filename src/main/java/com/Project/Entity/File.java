package com.Project.Entity;

import javax.persistence.*;

@Entity

public class File {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    //@Column(length = 1024,nullable = false)
    private String name;
    //@Column(name = "dms_path",length = 1024,nullable = false)
    private String dmsPath;
    //@Column(name = "file_size",nullable = false)
    private Long fileSize;
    //@Column(name = "desc",nullable = false)
    private String desc;
    @ManyToOne
    private User user;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDmsPath() {
        return dmsPath;
    }

    public void setDmsPath(String dmsPath) {
        this.dmsPath = dmsPath;
    }
    public Long getFileSize() {
        return fileSize;
    }
    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dmsPath='" + dmsPath + '\'' +
                ", fileSize=" + fileSize +
                ", desc='" + desc + '\'' +
                ", user=" + user +
                '}';
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
