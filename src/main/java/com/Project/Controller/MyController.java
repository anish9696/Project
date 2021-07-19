package com.Project.Controller;

//import org.springframework.stereotype.Controller;
import com.Project.Entity.Document;
import com.Project.Entity.User;
import com.Project.Services.DocumentService;
import com.Project.Services.UserService;
import com.Project.message.ResponseFile;
import com.Project.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//@Controller
@RestController
public class MyController {

    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String home()
    {
        return "Welcome to Document Management System";
    }

    @GetMapping("/documents")
    public ResponseEntity<List<ResponseFile>> getDocuments()
    {
        List<ResponseFile> docs =documentService.getDocuments().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getDocName(),
                    fileDownloadUri,
                    dbFile.getDocDesc(),
                    dbFile.getData().length);

        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(docs);
    }

    @GetMapping("/documents/{docId}")
    public ResponseEntity<byte[]> getDocument(@PathVariable String docId)
    {
        Document doc = documentService.getDocument(docId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+doc.getDocName()+"\"")
                .body(doc.getData());
    }

    @PostMapping("/doc")
    public Document addDocument(@RequestBody Document document)
    {
        return this.documentService.addDocument(document);
    }

    @PutMapping("/documents")
    public Document updateDocument(@RequestBody Document document)
    {
        return this.documentService.updateDocument(document);
    }

    @DeleteMapping("/documents/{docId}")
    public ResponseEntity<HttpStatus> deleteDocument(@PathVariable String docId)
    {
        try
        {
            this.documentService.deleteDocument(docId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/documents")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file)
    {
        String message ="";
        try
        {
            documentService.add(file);
            message = "Stored the Document in Database" + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (IOException e) {
            message ="Not Stored in the database"+ file.getOriginalFilename()+"!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/users/{userId}")
            public User getUserById(@PathVariable("userId") String userId)
    {
        return userService.getUserById(userId);

    }



    @PostMapping("/users")
    public User addNewUser(@RequestBody User user )
    {
        return this.userService.addNewUser(user);
        /*String message="";
        //User u = new User(user.getUsername(),user.getPasswordHash(),user.getFirstName(),user.getLastName(),user.getPhoneNumber(),user.getEmail(),user.getBorn(),user.getFileName());
        try
        {
            userService.addNewUser(user);
            message = "User Information Successfully inserted in Database";
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
*/
    }

}
