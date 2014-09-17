package ar.com.scriptorum.actions;

import org.apache.commons.lang3.StringUtils;

import ar.com.scriptorum.beans.PUnit;

public class ByName implements DirectionableComparator<PUnit> {
    
    static Boolean direction = false;

    @Override
    public int compare(PUnit p1, PUnit p2) {

        // straight direction
        int equal = 0;
        int lower = -1;
        int greater = 1;

        if(!direction) {
            // reversed results in case reverse ordering is required
            lower = 1;
            greater = -1;    
        }
        
        if(p1==null&&p2==null)
            return equal;
        
        
        if(p1==null)
            return lower;
        
        if(p2==null)
            return greater;
        
        
        if(StringUtils.isEmpty(p1.getName())&&StringUtils.isEmpty(p1.getName()))
            // both are equals in their nullness
            return equal;
        
        if(StringUtils.isEmpty(p1.getName()))
            return lower;

        if(StringUtils.isEmpty(p2.getName()))
            return greater;
        
        // neither name1 nor name2 are empty then we must compare
        // however we still need to decide which operator comes first
        if(direction)
            // standard direction
            return p1.getName().compareTo(p2.getName());
        
        // reverse direction
        return p2.getName().compareTo(p1.getName());
    }

    @Override
    public DirectionableComparator<PUnit> direction(Boolean direction) {
        ByName.direction = direction;
       return this;
    }
}
