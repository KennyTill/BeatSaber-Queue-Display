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
            FileReader queueReader = new FileReader(queueFileLocation);


            while (true) {
                String[] queueData = queueReader.readFile();

                //lets split this up and refactor it later.

                playerFrame.updateLabel(queueData[0]);
                Thread.sleep(5000);
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
