package com.example.recrutmenttool.Service;


import com.example.recrutmenttool.Repositories.DocumentUploaderRepository;
import com.example.recrutmenttool.models.Documents;
import com.example.recrutmenttool.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentUploaderService {
    @Autowired
    private DocumentUploaderRepository documentUploaderRepository;

    public String saveDocument(Documents documents) throws Exception{
        if(documents.getFileSize()>5){
            throw new Exception("document file size exceed by 5mb not allowed");
        }

        documentUploaderRepository.save(documents);
        return "Uploaded";
    }

    public Documents getDocumentById(Integer documentId,String password) throws Exception{
        if(!documentUploaderRepository.existsById(documentId)){
            throw new Exception("Invalid documentId");
        }

        Optional<Documents> documentsOptional = documentUploaderRepository.findById(documentId);
        Documents documents = documentsOptional.get();
        User user = documents.getUser();
        if (user.getPassword() == password) {
                return documents;
        }
        else{
            throw new Exception("Wrong Password");
        }
    }
}
