package ar.com.scriptorum.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWalker {

    List<File> files;
    String extension;

    public FileWalker(File file, String extension) {
        if (!file.isDirectory())
            throw new RuntimeException("subdir expected");
        files = Arrays.asList(file.listFiles());
        this.extension = extension;
    }

    /**
     * this method creates recursive calls
     * @return
     */
    public List<File> walk() {
        List<File> result = new ArrayList<File>();
        for (File file : files) {
            if (file.isDirectory())
                 ///////////     recursive call        \\\\\\\\\\\\\\
                result.addAll(new FileWalker(file, extension).walk());
            else if (file.getName().toUpperCase().endsWith(extension.toUpperCase()))
                result.add(file);
        }
        return result;
    }
}
