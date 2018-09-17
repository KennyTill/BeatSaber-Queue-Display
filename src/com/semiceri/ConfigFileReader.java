package com.semiceri;

import java.io.File;
import java.io.FileInputStream;

public class ConfigFileReader {
    private final String fileLocation;
    private final File file;
    private final String configFileName = "/configFile";

    public ConfigFileReader(String fileLocation) {
        this.fileLocation = fileLocation + configFileName;
        this.file = new File(this.fileLocation);
    }

    //read in frame position values
    //0: player x pos, 1: player y pos, 2: queue x pos, 3: queue y pos
    public int[] getPositionValuesFromFile() {
        int[] positionValues = new int[]{500, 10, 960, 100}; //some default workable values if the file is missing.

        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String fileData = new String(data, "UTF-8");
            String[] positionStringArray = fileData.split(",");
            for (int i = 0; i < 4; i++){
                positionValues[i] = Integer.parseInt(positionStringArray[i]);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return positionValues;
    }

}
