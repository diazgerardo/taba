package ar.com.scriptorum.util;


public class Alias<T> {

    private String alias;
    private T object;

    public Alias(T o1, String alias) {
        this.object = o1;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public T getObject() {
        return object;
    }

}
