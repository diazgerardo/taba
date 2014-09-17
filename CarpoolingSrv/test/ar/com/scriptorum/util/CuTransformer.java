package ar.com.scriptorum.util;

import java.util.ArrayList;
import java.util.List;

import ar.com.scriptorum.beans.Unit;

public class CuTransformer <T extends Unit>{

    
    private List<T> units;

    public CuTransformer(List<T> units) {
        this.units = units;
    }

    public List<String[]> toCsvs() {
        List<String[]> csvs = new ArrayList<String[]>();
        for(T unit : units) {
            csvs.add(new CuCsvAble(unit).values().toArray(new String[]{}));
        }
        return csvs;
    }

}
