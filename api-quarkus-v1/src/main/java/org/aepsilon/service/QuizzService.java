package org.aepsilon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aepsilon.dto.QuestionDto;
import org.aepsilon.dto.TranslationDto;
import org.aepsilon.orm.Question;
import org.aepsilon.web.client.TranslateClient;
import org.aepsilon.web.client.TranslateRequest;
import org.aepsilon.web.client.TranslateResponse;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class QuizzService {

    @ConfigProperty(name = "api-quizz.translations", defaultValue = "en")
    private String translatedLanguage;

    @Inject
    @RestClient
    TranslateClient client;
    public List<QuestionDto> listAllQuestions(){
        List<Question> questions =  Question.listAll();
        return translate(questions);
    }

    private List<QuestionDto> translate(List<Question> questions) {
        List<QuestionDto> result = new ArrayList<>();
        for(Question currentQuestion:questions){
            QuestionDto q = new QuestionDto(currentQuestion);
            result.add(q);
            String[] languages = translatedLanguage.split(",");
            for(String currentLanguage:languages){
                TranslateRequest r = new TranslateRequest();
                r.setSource("fr");
                r.setTarget(currentLanguage);
                r.setQ(currentQuestion.label);
                r.setAlternatives(0);
                r.setFormat("text");
                TranslateResponse rep = client.translate(r);
                q.translations.add(new TranslationDto(rep,currentLanguage));
            }//End For Each Question
        }//End For Each

        return result;
    }
}
