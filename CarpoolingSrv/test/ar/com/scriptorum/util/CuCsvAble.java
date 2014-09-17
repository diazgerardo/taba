package ar.com.scriptorum.util;

import java.util.LinkedList;
import java.util.List;

import ar.com.scriptorum.beans.Unit;

public class CuCsvAble implements CsvAble {

    private List<String> values;
    
    public CuCsvAble(Unit unit) {
        this.values = new LinkedList<String>();
        int i = 0;
        values.add(i++, unit.getModule());
        values.add(i++, unit.getName());
        values.add(i++, unit.getModifiedBy());
        values.add(i++, unit.getModifiedOn());
        //values.add(i++, "" + unit.getMethods().size());
        values.add(i++, "" + unit.getNLines());
    }

    @Override
    public List<String> values() {
        return values;
    }
}
