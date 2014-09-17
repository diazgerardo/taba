package ar.com.scriptorum.util;

public enum Constants {
    
    IF("if", 0), 
    ELSE("else", 1), 
    SWITCH("switch", 2), 
    CASE("case", 3), 
    AUTOWIRED("Autowired", 4), 
    NEW("new", 5);

    private int value;
    private String string;

    private Constants(String string, int value) {
        this.value = value;
        this.string = string;
    }

    public int intValue() {
        return value;
    }
        
    public String stringValue() {
        return string;
    }
}
