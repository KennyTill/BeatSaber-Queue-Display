package com.semiceri;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("No file path specified");
        }

        String filePath = args[0];
        int[] postionValues;
        //get config values
        ConfigFileReader configReader = new ConfigFileReader(filePath);
        postionValues = configReader.getPositionValuesFromFile();


        TransparentFrame playerFrame = new TransparentFrame("", 75, postionValues[0], postionValues[1]);
        playerFrame.setVisible(true);
        playerFrame.updateLabel("Awaiting Player");

        TransparentFrame queueFrame = new TransparentFrame("someinfo", 20, postionValues[2], postionValues[3]);
        queueFrame.setLocation(960, 50);
        queueFrame.setVisible(true);

        try {
            QueueFileReader queueReader = new QueueFileReader(filePath);


            while (true) {
                String[] queueData = queueReader.readFile();
                StringBuilder sb = new StringBuilder();
                //lets split this up and refactor it later.
                for (int i = 0; i < queueData.length; i++){
                    String[] lineSplit = queueData[i].split("`");//using backticks because some song names are weird =/
                    String pluralForm;
                    if (i == 0){
                        playerFrame.updateLabel(lineSplit[0]);
                        sb.append("<html><div style=\"text-align:left\"><ul style=\"list-style-type:none\">");
                        for (int j = 1; j < lineSplit.length; j++){
                            sb.append("<li>"+ lineSplit[j] + "</li>");
                        }
                        sb.append("</ul><br><p style=\"text-align:center\">--------Queue:--------</p><ul style=\"list-style-type:square\">");

                    } else {
                        int numberOfSongsQueued = lineSplit.length - 1;
                        if (numberOfSongsQueued > 1){
                            pluralForm = "songs";
                        } else {
                            pluralForm = "song";
                        }
                        sb.append("<li>" + lineSplit[0] + " -  " + numberOfSongsQueued + " " + pluralForm + "</li>"); //upcoming player and song count.
                    }
                }
                sb.append("</ul></div></html>");
                String outputString = sb.toString();
                queueFrame.updateLabel(outputString);
                Thread.sleep(5000);
            }

        } catch (Exception ex){
            System.out.println(ex);
        }
    }
}
