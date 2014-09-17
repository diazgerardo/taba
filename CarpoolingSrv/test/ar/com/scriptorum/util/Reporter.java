package ar.com.scriptorum.util;

import java.util.List;

public interface Reporter<T> {

    Reporter<T> createReport();

    Reporter<T> writeIn(Location location);

    Reporter<T> asCsv()throws Exception;

    List<String[]> transform(List<T> units);
    
    Reporter<T> saved();

}
