package com.example.grandshopauto;

import java.io.*;

public class infoCntroler {
    public static void changeFile(int lineNum, String replacement, String file){
        try {
            File temp =new File("temp.txt");
            temp.createNewFile();
            BufferedReader reader=new BufferedReader(new FileReader("file"));
            PrintWriter adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream("temp.txt")));
            while(reader.read()!=-1){
                adder.println(reader.readLine());
            }
            reader.close();
            adder.close();
            reader=new BufferedReader(new FileReader("temp.txt"));
            adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream("file")));
            int i=1;
            while(reader.read()!=-1){
                if(i!=lineNum){
                    adder.println(reader.readLine());
                }
                else{
                    adder.println(replacement);
                }
                i++;
            }
            reader.close();
            adder.close();
            temp.delete();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
