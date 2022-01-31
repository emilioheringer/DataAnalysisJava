package com.ilegra.dataanalysis;

import static com.ilegra.dataanalysis.CheckDirectory.scanDir;

public class DataAnalysis {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new KeepRunning());
        thread.start();
        System.out.println("Press C and Enter to exit");
        do {
            Thread.sleep(1000);
            scanDir();
            //String data = readFileAsString("/home/emilioheringer/Data.dat");

        } while (!KeepRunning.exit);
    }
}
