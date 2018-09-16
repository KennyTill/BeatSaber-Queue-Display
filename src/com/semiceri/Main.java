package com.semiceri;

public class Main {

    public static void main(String[] args) {
        try {
            TransparentFrame playerFrame = new TransparentFrame("Awaiting Player", 75);
            playerFrame.setVisible(true);

            TransparentFrame queueFrame = new TransparentFrame("Some Info", 30);
            queueFrame.setLocation(960, 100);
            queueFrame.setVisible(true);


            while (true) { //TODO: read/update loop here from queue file
                Thread.sleep(5000);
                playerFrame.updateLabel("Player Name");
            }
        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
