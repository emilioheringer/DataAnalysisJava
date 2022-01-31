package com.ilegra.dataanalysis;

import java.util.Scanner;

public class KeepRunning implements Runnable {
    static boolean exit=false;
    Scanner scanner = new Scanner(System.in);


    @Override
    public void run() {
        String message="";
        while(!(message.equals("c"))){
            try{
                message = scanner.nextLine();
            }catch (Exception e){
                System.out.println("Error");
            }
        }
        exit=true;
    }
}
