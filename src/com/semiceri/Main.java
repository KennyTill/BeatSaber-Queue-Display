package com.semiceri;

import java.io.File;
import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("No queue file specified");
        }

        String queueFileLocation = args[0];
        TransparentFrame playerFrame = new TransparentFrame("Awaiting Player", 75);
        playerFrame.setVisible(true);

        TransparentFrame queueFrame = new TransparentFrame("", 30);
        queueFrame.setLocation(960, 100);
        queueFrame.setVisible(true);

        try {

            File file = new File(queueFileLocation);


            while (true) {
                FileInputStream fis = new FileInputStream(file);
                byte[] data = new byte[(int) file.length()];
                fis.read(data);
                fis.close();
                String fileData = new String(data, "UTF-8");
                playerFrame.updateLabel(fileData); // need to split things, this is just for testing
                Thread.sleep(5000);
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
