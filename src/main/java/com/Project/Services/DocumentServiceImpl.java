package com.Project.Services;

import com.Project.DocumentDao.DocumentDao;
import com.Project.Entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@Service
public class DocumentServiceImpl implements DocumentService {

//    List<Document> list;
    @Autowired
    private DocumentDao documentDao;

    public DocumentServiceImpl() {
    }

    @Override
    public Stream<Document> getDocuments() {
        return documentDao.findAll().stream();
    }

    @Override
    public Document getDocument(String docId) {
        return documentDao.findById(docId).get();
    }


    public Document add(MultipartFile file) throws IOException
    {
        String docName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(docName,file.getContentType(),file.getBytes());
        return documentDao.save(document);
    }

    @Override
    public Document addDocument(Document document) {
        documentDao.save(document);
        return document;
    }

    @Override
    public Document updateDocument(Document document) {
        documentDao.save(document);
        return document;
    }

    @Override
    public void deleteDocument(String id) {
        documentDao.deleteById(id);
        //documentDao.delete();
    }
}
