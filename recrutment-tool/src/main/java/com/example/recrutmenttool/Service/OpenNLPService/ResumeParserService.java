package com.example.recrutmenttool.Service.OpenNLPService;

import com.example.recrutmenttool.exceptions.IncorrectFileFormat;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

@Service
public class ResumeParserService {
    public String readUploadedFile(MultipartFile resumeFile, MultipartFile jobDescription){
        if (resumeFile == null || jobDescription == null){
            throw new RuntimeException("Make sure both the file are present");
        } else if (!resumeFile.getContentType().equalsIgnoreCase("application/pdf")) {
            throw new IncorrectFileFormat("Only PDF files are accepted");
        }

        String resumeText = "";
        String jobDescText = "";
        double matchPercentage = 0;
        try{
            resumeText =  parsePDF(resumeFile);
            jobDescText = parsePDF(jobDescription);
            matchPercentage = matchPercentage(resumeText.toLowerCase(), jobDescText.toLowerCase());
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String formattedMatchPercentage = decimalFormat.format(matchPercentage);

        System.out.println(formattedMatchPercentage);

        return "matchPercentage = " + String.valueOf(formattedMatchPercentage);
    }

    public String parsePDF(MultipartFile file) throws IOException {
        String sentences;
        // Process the PDF file
        PDDocument document = PDDocument.load(file.getInputStream());
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);


        return text;
    }

    public double matchPercentage(String resumeText, String jobDescriptionText) {
//        creating Standford NLP pipeLine
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

//        Creating annotation objects for resume and job description text
        Annotation resumeAnnotation = new Annotation(resumeText);
        Annotation jobDescriptionAnnotation = new Annotation(jobDescriptionText);

//        Processing the text with the pipeline
        pipeline.annotate(resumeAnnotation);
        pipeline.annotate(jobDescriptionAnnotation);

//        generating tokens from the annotation objects
        List<CoreLabel> resumeWords = resumeAnnotation.get(CoreAnnotations.TokensAnnotation.class);
        List<CoreLabel> jobDescriptionWords = jobDescriptionAnnotation.get(CoreAnnotations.TokensAnnotation.class);

//        Calculate the number of matching words
        int matchingWords = 0;
        for (CoreLabel resumeWord : resumeWords) {
            if (jobDescriptionText.contains(resumeWord.originalText())) {
                matchingWords++;
            }
        }

//        Calculate match percentage
        int totalWords = resumeWords.size();
        return (double) matchingWords / totalWords * 100;

    }
}

