package com.Project.Controller;

import com.Project.DocumentDao.DocumentDao;
import com.Project.Entity.Document;
import com.Project.Entity.User;
import com.Project.Services.DocumentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MyController.class)
@WithMockUser
public class MyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    DocumentDao documentDao;
    @MockBean
    private DocumentService documentService;
    @Test
    void getDocuments() {
        List<Document> list = new ArrayList<Document>();
        Document document1 = new Document("1","anishkumar.pdf","about anish kumar","anishkumar.pdf".getBytes(StandardCharsets.UTF_8));
        list.add(document1);
        when(documentDao.getById(document1.getId())).thenReturn((Document) list);
        List<Document> documents = (List<Document>) documentService.getDocuments();
        assertEquals(1,documents.size());
        verify(documentDao,times(1)).findAll();


    }

    @Test
    void getDocument() {
       when(documentDao.getById("1")).thenReturn(new Document("anishkumar.pdf","about anish kumar","anishkumar.pdf".getBytes(StandardCharsets.UTF_8)));
       Document document = documentDao.getById("1");
       assertEquals("anishkumar.pdf",document.getDocName());
       assertEquals("about anish kumar",document.getDocDesc());
       assertEquals("anishkumar.pdf".getBytes(StandardCharsets.UTF_8),document.getData());
    }

    @Test
    void addDocument() {

        Document document = new Document("1","anishkumar.pdf","about anish kumar","anishkumar.pdf".getBytes(StandardCharsets.UTF_8));
        documentDao.save(document);
        verify(documentDao,times(1)).save(document);
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void addNewUser() {
    }
}