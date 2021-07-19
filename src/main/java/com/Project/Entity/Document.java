package com.Project.Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Document {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name ="uuid", strategy="uuid2")
    private String id;
    private String docName;
    private String docDesc;
    @Lob
    private byte[] data;

    public Document( String docName, String docDesc,byte[] data) {
        this.docName = docName;
        this.docDesc = docDesc;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public byte[] getData() {
        return data;
    }

    public Document(String id, String docName, String docDesc, byte[] data) {
        this.id = id;
        this.docName = docName;
        this.docDesc = docDesc;
        this.data = data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getDocDesc() {
        return docDesc;
    }

    public void setDocDesc(String docDesc) {
        this.docDesc = docDesc;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docName='" + docName + '\'' +
                ", docDesc='" + docDesc + '\'' +
                '}';
    }

    public Document() {
        super();
    }
}
