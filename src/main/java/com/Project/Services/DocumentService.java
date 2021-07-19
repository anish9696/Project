package com.Project.Services;

import com.Project.Entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface DocumentService {
    public Stream<Document> getDocuments();

    public Document getDocument(String docId);

    public Document addDocument(Document document);

    public Document updateDocument(Document document);

    public void deleteDocument(String docId);

    public default Document add(MultipartFile file) throws IOException {
        return null;
    }

    //Document getDocument(String docId);
}
