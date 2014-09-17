package ar.com.scriptorum.util;

import java.io.File;



public class WorkspaceLocation implements Location {

    final private String root = "C:/Users/Gerardo/git/carpoolershub/";

    @Override
    public String asString() {
        return root;
    }

    @Override
    public File asFile() {
        return new File(root);
    }
}
