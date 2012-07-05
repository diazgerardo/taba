package ar.com.scriptorum.patterns.factory;

//deal with plain text file
class CSVFile implements Display{

    public void load(String textfile) {
        System.out.println("load from a txt file");
    }
    public void formatConsistency() {
        System.out.println("txt file format changed");
    } 
}

