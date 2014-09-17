package ar.com.scriptorum.actions;

import java.util.Comparator;

public interface DirectionableComparator<T> extends Comparator<T> {
    public DirectionableComparator<T> direction(Boolean t);
}
