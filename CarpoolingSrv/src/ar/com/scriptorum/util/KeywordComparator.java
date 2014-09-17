package ar.com.scriptorum.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import ar.com.scriptorum.beans.Keywords;

public class KeywordComparator {

    /**
     * Compares its two arguments for order. Returns a negative integer, zero,
     * or a positive integer as the first argument is less than, equal to, or
     * greater than the second.
     */

    static int c[] = new int[] { 0, 0 };

    public boolean compare(Keywords o1, Keywords o2) {
        List<Alias<Keywords>> list = new ArrayList<Alias<Keywords>>();
        list.add(new Alias<Keywords>(o1, "alias1"));
        list.add(new Alias<Keywords>(o2, "alias2"));
        
        Evaluator ev = new Evaluator(list);
        Boolean result = Boolean.TRUE;
        result = result && ev.evaluate("alias1.getAutowiredKeyword() == alias2.getAutowiredKeyword()");
        result = result && ev.evaluate("alias1.getCaseKeyword() == alias2.getCaseKeyword()");
        result = result && ev.evaluate("alias1.getElseKeyword() == alias2.getElseKeyword()");
        result = result && ev.evaluate("alias1.getIfKeyword() == alias2.getIfKeyword()");
        result = result && ev.evaluate("alias1.getNewKeyword() == alias2.getNewKeyword()");
        result = result && ev.evaluate("alias1.getSwitchKeyword() == alias2.getSwitchKeyword()");
        return result;
    }

    class Evaluator {
     
        JexlEngine jexl;
        JexlContext jc;
        
        public Evaluator(List<Alias<Keywords>> list) {
            // Create or retrieve a JexlEngine
            jexl = new JexlEngine();
            // Create an expression object
            
            // Create a context and add data
            jc = new MapContext();
            for(Alias<Keywords> a : list) {
                jc.set(a.getAlias(), a.getObject());
            }
        }
        
        public boolean evaluate(String jexlExp) {
            Expression e = jexl.createExpression( jexlExp );
            Object o = e.evaluate(jc);
            return (Boolean) o;

        }
    }
}
