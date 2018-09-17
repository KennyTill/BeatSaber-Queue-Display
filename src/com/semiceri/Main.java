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

        TransparentFrame queueFrame = new TransparentFrame("someinfo", 20);
        queueFrame.setLocation(960, 50);
        queueFrame.setVisible(true);

        try {
            FileReader queueReader = new FileReader(queueFileLocation);


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
