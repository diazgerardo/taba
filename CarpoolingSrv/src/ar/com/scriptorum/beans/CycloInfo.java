package ar.com.scriptorum.beans;

import ar.com.scriptorum.dao.KeywordsBuilder;
import ar.com.scriptorum.util.Constants;
import ar.com.scriptorum.util.StringUtil;

public class CycloInfo {

    public CycloInfo(CUnit cunit) {
        for (Method method : cunit.getMethods().values()) {
            int[] keywordsAcum = new int[Constants.values().length];
            for (Constants i : Constants.values()) {
                keywordsAcum[i.intValue()] = StringUtil.count(method.getBody(), i.stringValue());
            }
            Keywords k = new KeywordsBuilder().named(method.getName()).from(keywordsAcum).build();
            method.getKeywords().add(k);
        }
    }
}
