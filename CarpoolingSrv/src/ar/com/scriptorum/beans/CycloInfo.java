package ar.com.scriptorum.beans;

import java.util.HashSet;
import java.util.Set;

import ar.com.scriptorum.dao.KeywordsBuilder;
import ar.com.scriptorum.util.Constants;
import ar.com.scriptorum.util.StringUtil;

public class CycloInfo {

    public CycloInfo(CUnit cunit) {
        for (Method method : cunit.getMethods().values()) {
            int[] keywordsAcum = new int[Constants.values().length];
            for (Constants keyword : Constants.values()) {
                keywordsAcum[keyword.intValue()] = StringUtil.count(method.getBody(), keyword.stringValue());
            }
            
            Set<Keywords> set = new HashSet<Keywords>();
            set.add(new KeywordsBuilder().named(method.getName()).from(keywordsAcum).build());
            method.setKeywords(set);
        }
    }
}
