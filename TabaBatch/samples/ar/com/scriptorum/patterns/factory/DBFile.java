package ar.com.scriptorum.patterns.factory;

//deal with binary format file
class DBFile implements Display {

    public  void load(String dbfile) {
        System.out.println("load from a db file");
    }
    public void formatConsistency() {
        System.out.println("db file format changed");
    } 
}

