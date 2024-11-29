package org.aepsilon.dto;

import org.aepsilon.orm.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    public List<TranslationDto> translations;

    public QuestionDto(){}

    public QuestionDto(Question q){
        translations =  new ArrayList<>();
        translations.add(new TranslationDto(q));
    }
}
