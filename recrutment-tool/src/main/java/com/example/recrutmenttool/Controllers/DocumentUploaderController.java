package com.example.recrutmenttool.Controllers;


import com.example.recrutmenttool.Service.DocumentUploaderService;
import com.example.recrutmenttool.models.Documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentUploaderController {

    @Autowired
    private DocumentUploaderService documentUploaderService;

   @PostMapping("/save")
   public void saveDocument(@RequestBody Documents documents) throws Exception {
       documentUploaderService.saveDocument(documents);
   }


    @GetMapping("/{documentId}")
    public Documents getDocumentById(@PathVariable Integer documentId,String password) throws Exception {
        return documentUploaderService.getDocumentById(documentId,password);
    }

}
