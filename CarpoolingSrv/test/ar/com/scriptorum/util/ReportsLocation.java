package ar.com.scriptorum.util;

import java.io.File;

public class ReportsLocation extends WorkspaceLocation {

    
    @Override
    public String asString() {
        return super.asString()+"reports/";
    }

    public File asFile() {
        return new File(this.asString());
    }

}
