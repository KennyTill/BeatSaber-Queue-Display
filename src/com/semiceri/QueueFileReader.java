package com.semiceri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class QueueFileReader {

    private final String fileLocation;
    private final File file;
    private final String queueFileName = "/queuefile";

    public QueueFileReader(String fileLocation) {
        this.fileLocation = fileLocation + queueFileName;
        this.file = new File(this.fileLocation);
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
