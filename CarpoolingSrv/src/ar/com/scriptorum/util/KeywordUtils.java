package ar.com.scriptorum.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ar.com.scriptorum.beans.Keywords;

public class KeywordUtils {

    public Set<Keywords> addDifferent(Set<Keywords> target, Set<Keywords> candidates) {

        List<Keywords> newOnes = new ArrayList<Keywords>();
        KeywordComparator comparator = new KeywordComparator();
        for (Keywords c : candidates) {
            boolean found = false;
            for (Keywords t : target) {
                if (comparator.compare(c, t)) {
                    found=true;
                    break;
                }
            }
            if(!found){
                newOnes.add(c);
            }
        }
        target.addAll(newOnes);
        return target;
    }

}
