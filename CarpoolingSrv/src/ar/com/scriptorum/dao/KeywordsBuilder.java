package ar.com.scriptorum.dao;

import java.util.Date;

import ar.com.scriptorum.beans.Keywords;
import ar.com.scriptorum.util.Constants;

public class KeywordsBuilder {

    private Keywords keywords;

    public Keywords build() {
        return keywords;
    }

    public KeywordsBuilder from(int[] count) {
        keywords.setAutowiredKeyword(count[Constants.AUTOWIRED.intValue()]);
        keywords.setIfKeyword(count[Constants.IF.intValue()]);
        keywords.setElseKeyword(count[Constants.ELSE.intValue()]);
        keywords.setSwitchKeyword(count[Constants.SWITCH.intValue()]);
        keywords.setCaseKeyword(count[Constants.CASE.intValue()]);
        keywords.setNewKeyword(count[Constants.NEW.intValue()]);
        return this;
    }

    public KeywordsBuilder named(String name) {
        keywords = new Keywords();
        keywords.setName(name);
        keywords.setBuiltOn(new Date());
        return this;
    }

}
