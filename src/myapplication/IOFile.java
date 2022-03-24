package myapplication;
import java.io.*;
import java.util.*;

public class IOFile {
    public static HashMap<String,String> readDataFromFile(String filepath) throws IOException {
        HashMap<String, String> data = new HashMap<>();
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine()) != null){
                String[] newWord = line.split("`");
                if(newWord[0].equals("Slang")){
                    continue;
                }
                data.put(newWord[0],newWord[1]);
            }
        }catch (Exception e){
            System.out.println("Read file error: "+ e);
        }
        finally {
            br.close();
        }

        return data;
    }
    public static void saveHistoryWords(){

    }


}
