package com.example.recrutmenttool.Controllers;

import com.example.recrutmenttool.Service.OpenNLPService.ResumeParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class ResumeController {

    @Autowired
    ResumeParserService resumeParserService;

    @PostMapping("/upload")
    public ResponseEntity<String> readUploadedFile(@RequestParam("resume") MultipartFile resume, @RequestParam("Jobdesc") MultipartFile Jobdesc){

        String result = resumeParserService.readUploadedFile(resume, Jobdesc);
        return new ResponseEntity<String>(result, HttpStatus.OK);

    }
}
