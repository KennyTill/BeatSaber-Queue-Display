package com.semiceri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    final String fileLocation;
    final File file;

    public FileReader(String fileLocation) {
        this.fileLocation = fileLocation;
        this.file = new File(fileLocation);
    }

    public String[] readFile(){
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String fileData = new String(data, "UTF-8");
            String[] songArray = fileData.split("\\r?\\n");
            return songArray;
        } catch (IOException ex){
            return new String[]{ex.getMessage()};
        }
    }
}
