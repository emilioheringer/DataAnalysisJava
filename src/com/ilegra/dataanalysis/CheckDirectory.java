package com.ilegra.dataanalysis;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CheckDirectory {


    public static String readFileAsString(String file) throws Exception {
        String data;
        String fileName = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void scanDir() throws Exception {
        String[] patchs;
        String home = System.getProperty("user.home");
        home = home.replace("\\","/");
        File f = new File(home+"/data/in");

        //Retorna o caminho de todos os arquivos que contem extensão .dat
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".dat");
            }
        };
        patchs = f.list(filter);
        Path filename;
        String arm;

        assert patchs != null;
        int k=0;
        int m=0;
        int n=0;
        for (String patchname : patchs) {
            filename = Path.of(home+ "/data/in/" + patchname);
            System.out.println(filename);
            arm = Files.readString(filename);
            splitString(arm,k,m,n);
        }
    }

    public static String[] splitString(String str,int k, int m, int n){
        String[] data = str.split("(?=00)");
             //return data;
        String[] Salesman = new String[100000];
        String[] Customer = new String[100000];
        String[] Sales = new String[10000];
        long nClients =0;
        for (String s: data){
            if(s.contains("001ç")){
                Salesman[k] = s;
                k=k+1;
                nClients++;
            }else if(s.contains("002ç")){
                Customer[m] = s;
                nClients++;
                m=m+1;
            }else if(s.contains("003ç")){
                Sales[n] = s;
                n=n+1;
            }
        }
        System.out.println("Number of Clients = " +nClients);
        System.out.println("Number of Clients = " +data.length);
        WriteFiler(nClients,k+1);
        return data;
    }

    public static void WriteFiler(long nClients, long nSalesman){
        String write1 = ("The number of clients is " +nClients);
        String write2 = ("\nThe number of Salesman is " +nSalesman);
        String home = System.getProperty("user.home");
        home = home.replace("\\","/");
      Path filepath = Paths.get(home+"/data/out/","data.txt");
        try{
            File file = new File(home +"/data/out/", "data.txt");
            file.createNewFile();
            Files.writeString(filepath, write1, StandardOpenOption.TRUNCATE_EXISTING);
            Files.writeString(filepath, write2, StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}


