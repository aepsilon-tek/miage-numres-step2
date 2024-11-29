package org.aepsilon.dto;

import org.aepsilon.orm.Question;
import org.aepsilon.web.client.TranslateResponse;

public class TranslationDto {
    public String language;
    public String value;


    public TranslationDto(){}

    public TranslationDto(Question q){
        language="fr"; //Default value
        value = q.label;
    }

    public TranslationDto(TranslateResponse r, String lg){
        language=lg;
        value = r.getTranslatedText();
    }
}
