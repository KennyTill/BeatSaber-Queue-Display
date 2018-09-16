package com.semiceri;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("No queue file specified");
        }

        String queueFileLocation = args[0];
        TransparentFrame playerFrame = new TransparentFrame("", 75);
        playerFrame.setVisible(true);
        playerFrame.updateLabel("Awaiting Player");

        TransparentFrame queueFrame = new TransparentFrame("someinfo", 30);
        //queueFrame.setLocation(500, 100);
        queueFrame.setVisible(true);

        try {
            FileReader queueReader = new FileReader(queueFileLocation);


            String currentPlayer = "Awaiting Player";

            while (true) {
                String[] queueData = queueReader.readFile();
                StringBuilder sb = new StringBuilder();
                //lets split this up and refactor it later.
                for (int i = 0; i < queueData.length; i++){
                    if (i == 0){
                        String[] lineSplit = queueData[i].split("`");//using backticks because some song names are weird =/
                        currentPlayer = lineSplit[0];
                        playerFrame.updateLabel(currentPlayer);
                        sb.append(lineSplit[1]);
                    }

                }
                String outputString = sb.toString();
                queueFrame.updateLabel(outputString);
                Thread.sleep(5000);
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
