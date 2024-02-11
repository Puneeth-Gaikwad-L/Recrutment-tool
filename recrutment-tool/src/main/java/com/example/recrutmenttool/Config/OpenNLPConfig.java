package com.example.recrutmenttool.Config;

import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
public class OpenNLPConfig {

    @Value("classpath:/path/to/en-sent.bin")
    private Resource sentenceModel;

    @Value("classpath:/path/to/en-token.bin")
    private Resource tokenizerModel;

    @Value("classpath:/path/to/en-pos-maxent.bin")
    private Resource posModel;

    @Value("classpath:/path/to/en-ner-person.bin")
    private Resource nerPersonModel;

    @Bean
    public SentenceModel sentenceModel() throws IOException {
        return new SentenceModel(sentenceModel.getInputStream());
    }

    @Bean
    public TokenizerModel tokenizerModel() throws IOException {
        return new TokenizerModel(tokenizerModel.getInputStream());
    }

    @Bean
    public POSModel posModel() throws IOException {
        return new POSModel(posModel.getInputStream());
    }

    @Bean
    public TokenNameFinderModel nerPersonModel() throws IOException {
        return new TokenNameFinderModel(nerPersonModel.getInputStream());
    }
}
