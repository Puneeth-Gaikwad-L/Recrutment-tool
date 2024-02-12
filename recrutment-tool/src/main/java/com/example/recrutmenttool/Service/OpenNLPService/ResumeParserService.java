package com.example.recrutmenttool.Service.OpenNLPService;

import com.example.recrutmenttool.models.Resume;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ResumeParserService {

    @Autowired
    private SentenceModel sentenceModel;

    @Autowired
    private TokenizerModel tokenizerModel;

    @Autowired
    private POSModel posModel;

    @Autowired
    private TokenNameFinderModel nerPersonModel;

    public Resume parseResume(String resumeText) {
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(sentenceModel);
        TokenizerME tokenizer = new TokenizerME(tokenizerModel);
        POSTaggerME posTagger = new POSTaggerME(posModel);
        NameFinderME nerPersonNameFinder = new NameFinderME(nerPersonModel);

        String[] sentences = sentenceDetector.sentDetect(resumeText);
        Resume parsedResume = new Resume();

        for (String sentence : sentences) {
            // Tokenization
            String[] tokens = tokenizer.tokenize(sentence);

            // Part-of-speech tagging
            String[] posTags = posTagger.tag(tokens);

            // Named Entity Recognition (NER) for person names
            Span[] nameSpans = nerPersonNameFinder.find(tokens);

            // Process posTags and nameSpans and populate Resume fields based on your requirements
            // Example: identify and store part-of-speech tags, person names, etc.
        }

        return parsedResume;
    }
}

