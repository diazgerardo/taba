package ar.com.scriptorum.util;

import japa.parser.JavaParser;
import japa.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import ar.com.scriptorum.beans.CUnit;

public class UnitsFileLoader implements Loader<CUnit>{

    Location location;
    
    public UnitsFileLoader(Location location) {
        this.location = location;
    }

    public List<CUnit> load() {
        List<CUnit> units = new LinkedList<CUnit>();
        FileWalker fw = new FileWalker(new File(location.asString()), "java");
        for (File f : fw.walk()) {
            try {
                units.add(new CUnit(f, JavaParser.parse(f)));
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return units;
    }
    
}
